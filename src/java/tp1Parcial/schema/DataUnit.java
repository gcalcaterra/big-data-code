/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package tp1Parcial.schema;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUnit extends org.apache.thrift.TUnion<DataUnit, DataUnit._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DataUnit");
  private static final org.apache.thrift.protocol.TField INTERNET_USE_PROPERTY_FIELD_DESC = new org.apache.thrift.protocol.TField("internetUseProperty", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField INDIVIDUAL_TYPE_PROPERTY_FIELD_DESC = new org.apache.thrift.protocol.TField("individualTypeProperty", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField GEOGRAPHY_PROPERTY_FIELD_DESC = new org.apache.thrift.protocol.TField("geographyProperty", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField FACTS_EDGE_FIELD_DESC = new org.apache.thrift.protocol.TField("factsEdge", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INTERNET_USE_PROPERTY((short)1, "internetUseProperty"),
    INDIVIDUAL_TYPE_PROPERTY((short)2, "individualTypeProperty"),
    GEOGRAPHY_PROPERTY((short)3, "geographyProperty"),
    FACTS_EDGE((short)4, "factsEdge");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // INTERNET_USE_PROPERTY
          return INTERNET_USE_PROPERTY;
        case 2: // INDIVIDUAL_TYPE_PROPERTY
          return INDIVIDUAL_TYPE_PROPERTY;
        case 3: // GEOGRAPHY_PROPERTY
          return GEOGRAPHY_PROPERTY;
        case 4: // FACTS_EDGE
          return FACTS_EDGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INTERNET_USE_PROPERTY, new org.apache.thrift.meta_data.FieldMetaData("internetUseProperty", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InternetUseProperty.class)));
    tmpMap.put(_Fields.INDIVIDUAL_TYPE_PROPERTY, new org.apache.thrift.meta_data.FieldMetaData("individualTypeProperty", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, IndividualTypeProperty.class)));
    tmpMap.put(_Fields.GEOGRAPHY_PROPERTY, new org.apache.thrift.meta_data.FieldMetaData("geographyProperty", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GeographyProperty.class)));
    tmpMap.put(_Fields.FACTS_EDGE, new org.apache.thrift.meta_data.FieldMetaData("factsEdge", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FactsEdge.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DataUnit.class, metaDataMap);
  }

  public DataUnit() {
    super();
  }

  public DataUnit(_Fields setField, Object value) {
    super(setField, value);
  }

  public DataUnit(DataUnit other) {
    super(other);
  }
  public DataUnit deepCopy() {
    return new DataUnit(this);
  }

  public static DataUnit internetUseProperty(InternetUseProperty value) {
    DataUnit x = new DataUnit();
    x.set_internetUseProperty(value);
    return x;
  }

  public static DataUnit individualTypeProperty(IndividualTypeProperty value) {
    DataUnit x = new DataUnit();
    x.set_individualTypeProperty(value);
    return x;
  }

  public static DataUnit geographyProperty(GeographyProperty value) {
    DataUnit x = new DataUnit();
    x.set_geographyProperty(value);
    return x;
  }

  public static DataUnit factsEdge(FactsEdge value) {
    DataUnit x = new DataUnit();
    x.set_factsEdge(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case INTERNET_USE_PROPERTY:
        if (value instanceof InternetUseProperty) {
          break;
        }
        throw new ClassCastException("Was expecting value of type InternetUseProperty for field 'internetUseProperty', but got " + value.getClass().getSimpleName());
      case INDIVIDUAL_TYPE_PROPERTY:
        if (value instanceof IndividualTypeProperty) {
          break;
        }
        throw new ClassCastException("Was expecting value of type IndividualTypeProperty for field 'individualTypeProperty', but got " + value.getClass().getSimpleName());
      case GEOGRAPHY_PROPERTY:
        if (value instanceof GeographyProperty) {
          break;
        }
        throw new ClassCastException("Was expecting value of type GeographyProperty for field 'geographyProperty', but got " + value.getClass().getSimpleName());
      case FACTS_EDGE:
        if (value instanceof FactsEdge) {
          break;
        }
        throw new ClassCastException("Was expecting value of type FactsEdge for field 'factsEdge', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case INTERNET_USE_PROPERTY:
          if (field.type == INTERNET_USE_PROPERTY_FIELD_DESC.type) {
            InternetUseProperty internetUseProperty;
            internetUseProperty = new InternetUseProperty();
            internetUseProperty.read(iprot);
            return internetUseProperty;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case INDIVIDUAL_TYPE_PROPERTY:
          if (field.type == INDIVIDUAL_TYPE_PROPERTY_FIELD_DESC.type) {
            IndividualTypeProperty individualTypeProperty;
            individualTypeProperty = new IndividualTypeProperty();
            individualTypeProperty.read(iprot);
            return individualTypeProperty;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case GEOGRAPHY_PROPERTY:
          if (field.type == GEOGRAPHY_PROPERTY_FIELD_DESC.type) {
            GeographyProperty geographyProperty;
            geographyProperty = new GeographyProperty();
            geographyProperty.read(iprot);
            return geographyProperty;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case FACTS_EDGE:
          if (field.type == FACTS_EDGE_FIELD_DESC.type) {
            FactsEdge factsEdge;
            factsEdge = new FactsEdge();
            factsEdge.read(iprot);
            return factsEdge;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case INTERNET_USE_PROPERTY:
        InternetUseProperty internetUseProperty = (InternetUseProperty)value_;
        internetUseProperty.write(oprot);
        return;
      case INDIVIDUAL_TYPE_PROPERTY:
        IndividualTypeProperty individualTypeProperty = (IndividualTypeProperty)value_;
        individualTypeProperty.write(oprot);
        return;
      case GEOGRAPHY_PROPERTY:
        GeographyProperty geographyProperty = (GeographyProperty)value_;
        geographyProperty.write(oprot);
        return;
      case FACTS_EDGE:
        FactsEdge factsEdge = (FactsEdge)value_;
        factsEdge.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case INTERNET_USE_PROPERTY:
          InternetUseProperty internetUseProperty;
          internetUseProperty = new InternetUseProperty();
          internetUseProperty.read(iprot);
          return internetUseProperty;
        case INDIVIDUAL_TYPE_PROPERTY:
          IndividualTypeProperty individualTypeProperty;
          individualTypeProperty = new IndividualTypeProperty();
          individualTypeProperty.read(iprot);
          return individualTypeProperty;
        case GEOGRAPHY_PROPERTY:
          GeographyProperty geographyProperty;
          geographyProperty = new GeographyProperty();
          geographyProperty.read(iprot);
          return geographyProperty;
        case FACTS_EDGE:
          FactsEdge factsEdge;
          factsEdge = new FactsEdge();
          factsEdge.read(iprot);
          return factsEdge;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case INTERNET_USE_PROPERTY:
        InternetUseProperty internetUseProperty = (InternetUseProperty)value_;
        internetUseProperty.write(oprot);
        return;
      case INDIVIDUAL_TYPE_PROPERTY:
        IndividualTypeProperty individualTypeProperty = (IndividualTypeProperty)value_;
        individualTypeProperty.write(oprot);
        return;
      case GEOGRAPHY_PROPERTY:
        GeographyProperty geographyProperty = (GeographyProperty)value_;
        geographyProperty.write(oprot);
        return;
      case FACTS_EDGE:
        FactsEdge factsEdge = (FactsEdge)value_;
        factsEdge.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case INTERNET_USE_PROPERTY:
        return INTERNET_USE_PROPERTY_FIELD_DESC;
      case INDIVIDUAL_TYPE_PROPERTY:
        return INDIVIDUAL_TYPE_PROPERTY_FIELD_DESC;
      case GEOGRAPHY_PROPERTY:
        return GEOGRAPHY_PROPERTY_FIELD_DESC;
      case FACTS_EDGE:
        return FACTS_EDGE_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public InternetUseProperty get_internetUseProperty() {
    if (getSetField() == _Fields.INTERNET_USE_PROPERTY) {
      return (InternetUseProperty)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'internetUseProperty' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_internetUseProperty(InternetUseProperty value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.INTERNET_USE_PROPERTY;
    value_ = value;
  }

  public IndividualTypeProperty get_individualTypeProperty() {
    if (getSetField() == _Fields.INDIVIDUAL_TYPE_PROPERTY) {
      return (IndividualTypeProperty)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'individualTypeProperty' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_individualTypeProperty(IndividualTypeProperty value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.INDIVIDUAL_TYPE_PROPERTY;
    value_ = value;
  }

  public GeographyProperty get_geographyProperty() {
    if (getSetField() == _Fields.GEOGRAPHY_PROPERTY) {
      return (GeographyProperty)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'geographyProperty' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_geographyProperty(GeographyProperty value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.GEOGRAPHY_PROPERTY;
    value_ = value;
  }

  public FactsEdge get_factsEdge() {
    if (getSetField() == _Fields.FACTS_EDGE) {
      return (FactsEdge)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'factsEdge' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_factsEdge(FactsEdge value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.FACTS_EDGE;
    value_ = value;
  }

  public boolean is_set_internetUseProperty() {
    return setField_ == _Fields.INTERNET_USE_PROPERTY;
  }


  public boolean is_set_individualTypeProperty() {
    return setField_ == _Fields.INDIVIDUAL_TYPE_PROPERTY;
  }


  public boolean is_set_geographyProperty() {
    return setField_ == _Fields.GEOGRAPHY_PROPERTY;
  }


  public boolean is_set_factsEdge() {
    return setField_ == _Fields.FACTS_EDGE;
  }


  public boolean equals(Object other) {
    if (other instanceof DataUnit) {
      return equals((DataUnit)other);
    } else {
      return false;
    }
  }

  public boolean equals(DataUnit other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(DataUnit other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  /**
   * If you'd like this to perform more respectably, use the hashcode generator option.
   */
  @Override
  public int hashCode() {
    return 0;
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
