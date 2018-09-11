package tp1Parcial.tap;

import tp1Parcial.schema.Data;

public class DataPailStructure extends ThriftPailStructure<Data> {
  @Override
  protected Data createThriftObject() {
    return new Data();
  }

  public Class getType() {
    return Data.class;
  }
}
