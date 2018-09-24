package tp1Parcial.tap;

import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TUnion;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import tp1Parcial.schema.Data;
import tp1Parcial.schema.DataUnit;

import java.util.*;


public class SplitDataPailStructure extends DataPailStructure {
    protected static interface FieldStructure {
        public boolean isValidTarget(String[] dirs);

        public void fillTarget(List<String> ret, Object val);
    }

    public static HashMap<Short, FieldStructure> validFieldMap =
            new HashMap<Short, FieldStructure>();

    private static Map<TFieldIdEnum, FieldMetaData>
    getMetadataMap(Class c) {
        try {
            Object o = c.newInstance();
            return (Map) c.getField("metaDataMap").get(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static class EdgeStructure implements FieldStructure {
        public boolean isValidTarget(String[] dirs) {
            return true;
        }

        public void fillTarget(List<String> ret, Object val) {
        }
    }

    protected static class PropertyStructure implements FieldStructure {
        private TFieldIdEnum valueId;
        private HashSet<Short> validIds;

        private static TFieldIdEnum getIdForClass(
                Map<TFieldIdEnum, FieldMetaData> meta,
                Class toFind) {
            for (TFieldIdEnum k : meta.keySet()) {
                FieldValueMetaData md = meta.get(k).valueMetaData;
                if (md instanceof StructMetaData) {
                    if (toFind.equals(((StructMetaData) md).structClass)) {
                        return k;
                    }
                }
            }
            throw new RuntimeException("Could not find " + toFind.toString() +
                    " in " + meta.toString());
        }

        public PropertyStructure(Class prop) {
            try {
                Map<TFieldIdEnum, FieldMetaData> propMeta = getMetadataMap(prop);
                Class valClass = Class.forName(prop.getName() + "Value");
                valueId = getIdForClass(propMeta, valClass);

                validIds = new HashSet<Short>();
                Map<TFieldIdEnum, FieldMetaData> valMeta = getMetadataMap(valClass);
                for (TFieldIdEnum valId : valMeta.keySet()) {
                    validIds.add(valId.getThriftFieldId());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean isValidTarget(String[] dirs) {
            if (dirs.length < 2) return false;
            try {
                short s = Short.parseShort(dirs[1]);
                return validIds.contains(s);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public void fillTarget(List<String> ret, Object val) {
            ret.add("" + ((TUnion) ((TBase) val)
                    .getFieldValue(valueId))
                    .getSetField()
                    .getThriftFieldId());
        }
    }

    static {
        for (DataUnit._Fields k : DataUnit.metaDataMap.keySet()) {
            FieldValueMetaData md = DataUnit.metaDataMap.get(k).valueMetaData;
            FieldStructure fieldStruct;
            if (md instanceof StructMetaData && ((StructMetaData) md)
                    .structClass
                    .getName()
                    .endsWith("Property")) {
                fieldStruct = new PropertyStructure(((StructMetaData) md)
                        .structClass);
            } else {
                fieldStruct = new EdgeStructure();
            }
            validFieldMap.put(k.getThriftFieldId(), fieldStruct);
        }
    }

    @Override
    public boolean isValidTarget(String[] dirs) {
        if (dirs.length < 2) return false;
        try {
            short id = Short.parseShort(dirs[0]);
            FieldStructure s = validFieldMap.get(id);
            if (s == null) return false;
            if (!s.isValidTarget(dirs)) return false;

            if (s instanceof EdgeStructure) {
                String fieldName = dirs[1];
                //Agregar aquí los criterios de particionamiento horizontal (Edges)
                switch (fieldName) {
                    case ("factsEdge"):
                        if (dirs.length < 3) return false;
                        int year = Integer.parseInt(dirs[2]);
                        return 1900 < year && year < 2100;
                    default:
                        return false;
                }
            }

            else if (s instanceof PropertyStructure){
                String fieldName = dirs[1];
                //Agregar aquí los criterios de particionamiento horizontal (Properties)
                switch (fieldName) {
                    case ("internetUseProperty"):
                        return true;
                    case ("individualTypeProperty"):
                        return true;
                    case ("geographyProperty"):
                        return true;
                    default:
                        return false;
                }
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public List<String> getTarget(Data object) {
        List<String> ret = new ArrayList<>();
        DataUnit du = object.get_dataUnit();
        DataUnit._Fields setField = du.getSetField();

        short id = setField.getThriftFieldId();
        ret.add(Short.toString(id));

        String fieldName = setField.getFieldName();
        ret.add(fieldName);

        //Agregar aquí los criterios de particionamiento horizontal
        switch (fieldName) {
            /*
            * case ("xxx"):
            *   ret.add("criterio_de_particionamiento_1")
            *   ret.add("criterio_de_particionamiento_2")
            *   ...
            * */
            case ("factsEdge"):
                int year = du.get_factsEdge().get_year();
                ret.add(Integer.toString(year));
                break;
            /*
            case ("internetUseProperty"):
                break;
            case ("individualTypeProperty"):
                break;
            case("geographyProperty"):
                break;
            */
        }

        validFieldMap.get(id).fillTarget(ret, du.getFieldValue());
        return ret;
    }
}
