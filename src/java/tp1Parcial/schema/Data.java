/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package tp1Parcial.schema;

import org.apache.commons.lang3.builder.HashCodeBuilder;
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

public class Data implements org.apache.thrift.TBase<Data, Data._Fields>, java.io.Serializable, Cloneable, Comparable<Data> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Data");

  private static final org.apache.thrift.protocol.TField PEDIGREE_FIELD_DESC = new org.apache.thrift.protocol.TField("pedigree", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_UNIT_FIELD_DESC = new org.apache.thrift.protocol.TField("dataUnit", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DataStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DataTupleSchemeFactory());
  }

  private Pedigree pedigree; // required
  private DataUnit dataUnit; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PEDIGREE((short)1, "pedigree"),
    DATA_UNIT((short)2, "dataUnit");

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
        case 1: // PEDIGREE
          return PEDIGREE;
        case 2: // DATA_UNIT
          return DATA_UNIT;
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

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PEDIGREE, new org.apache.thrift.meta_data.FieldMetaData("pedigree", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Pedigree.class)));
    tmpMap.put(_Fields.DATA_UNIT, new org.apache.thrift.meta_data.FieldMetaData("dataUnit", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DataUnit.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Data.class, metaDataMap);
  }

  public Data() {
  }

  public Data(
    Pedigree pedigree,
    DataUnit dataUnit)
  {
    this();
    this.pedigree = pedigree;
    this.dataUnit = dataUnit;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Data(Data other) {
    if (other.is_set_pedigree()) {
      this.pedigree = new Pedigree(other.pedigree);
    }
    if (other.is_set_dataUnit()) {
      this.dataUnit = new DataUnit(other.dataUnit);
    }
  }

  public Data deepCopy() {
    return new Data(this);
  }

  @Override
  public void clear() {
    this.pedigree = null;
    this.dataUnit = null;
  }

  public Pedigree get_pedigree() {
    return this.pedigree;
  }

  public void set_pedigree(Pedigree pedigree) {
    this.pedigree = pedigree;
  }

  public void unset_pedigree() {
    this.pedigree = null;
  }

  /** Returns true if field pedigree is set (has been assigned a value) and false otherwise */
  public boolean is_set_pedigree() {
    return this.pedigree != null;
  }

  public void set_pedigree_isSet(boolean value) {
    if (!value) {
      this.pedigree = null;
    }
  }

  public DataUnit get_dataUnit() {
    return this.dataUnit;
  }

  public void set_dataUnit(DataUnit dataUnit) {
    this.dataUnit = dataUnit;
  }

  public void unset_dataUnit() {
    this.dataUnit = null;
  }

  /** Returns true if field dataUnit is set (has been assigned a value) and false otherwise */
  public boolean is_set_dataUnit() {
    return this.dataUnit != null;
  }

  public void set_dataUnit_isSet(boolean value) {
    if (!value) {
      this.dataUnit = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PEDIGREE:
      if (value == null) {
        unset_pedigree();
      } else {
        set_pedigree((Pedigree)value);
      }
      break;

    case DATA_UNIT:
      if (value == null) {
        unset_dataUnit();
      } else {
        set_dataUnit((DataUnit)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PEDIGREE:
      return get_pedigree();

    case DATA_UNIT:
      return get_dataUnit();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PEDIGREE:
      return is_set_pedigree();
    case DATA_UNIT:
      return is_set_dataUnit();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Data)
      return this.equals((Data)that);
    return false;
  }

  public boolean equals(Data that) {
    if (that == null)
      return false;

    boolean this_present_pedigree = true && this.is_set_pedigree();
    boolean that_present_pedigree = true && that.is_set_pedigree();
    if (this_present_pedigree || that_present_pedigree) {
      if (!(this_present_pedigree && that_present_pedigree))
        return false;
      if (!this.pedigree.equals(that.pedigree))
        return false;
    }

    boolean this_present_dataUnit = true && this.is_set_dataUnit();
    boolean that_present_dataUnit = true && that.is_set_dataUnit();
    if (this_present_dataUnit || that_present_dataUnit) {
      if (!(this_present_dataUnit && that_present_dataUnit))
        return false;
      if (!this.dataUnit.equals(that.dataUnit))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_pedigree = true && (is_set_pedigree());
    builder.append(present_pedigree);
    if (present_pedigree)
      builder.append(pedigree);

    boolean present_dataUnit = true && (is_set_dataUnit());
    builder.append(present_dataUnit);
    if (present_dataUnit)
      builder.append(dataUnit);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(Data other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(is_set_pedigree()).compareTo(other.is_set_pedigree());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_pedigree()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pedigree, other.pedigree);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_dataUnit()).compareTo(other.is_set_dataUnit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_dataUnit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dataUnit, other.dataUnit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Data(");
    boolean first = true;

    sb.append("pedigree:");
    if (this.pedigree == null) {
      sb.append("null");
    } else {
      sb.append(this.pedigree);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dataUnit:");
    if (this.dataUnit == null) {
      sb.append("null");
    } else {
      sb.append(this.dataUnit);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!is_set_pedigree()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pedigree' is unset! Struct:" + toString());
    }

    if (!is_set_dataUnit()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dataUnit' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (pedigree != null) {
      pedigree.validate();
    }
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

  private static class DataStandardSchemeFactory implements SchemeFactory {
    public DataStandardScheme getScheme() {
      return new DataStandardScheme();
    }
  }

  private static class DataStandardScheme extends StandardScheme<Data> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Data struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PEDIGREE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.pedigree = new Pedigree();
              struct.pedigree.read(iprot);
              struct.set_pedigree_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA_UNIT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.dataUnit = new DataUnit();
              struct.dataUnit.read(iprot);
              struct.set_dataUnit_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Data struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.pedigree != null) {
        oprot.writeFieldBegin(PEDIGREE_FIELD_DESC);
        struct.pedigree.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.dataUnit != null) {
        oprot.writeFieldBegin(DATA_UNIT_FIELD_DESC);
        struct.dataUnit.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DataTupleSchemeFactory implements SchemeFactory {
    public DataTupleScheme getScheme() {
      return new DataTupleScheme();
    }
  }

  private static class DataTupleScheme extends TupleScheme<Data> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Data struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.pedigree.write(oprot);
      struct.dataUnit.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Data struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.pedigree = new Pedigree();
      struct.pedigree.read(iprot);
      struct.set_pedigree_isSet(true);
      struct.dataUnit = new DataUnit();
      struct.dataUnit.read(iprot);
      struct.set_dataUnit_isSet(true);
    }
  }

}

