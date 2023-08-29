package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

/**
 * This class is made to encapsulate a field at CERN. However, it is slightly more abstract as we are using a type T
 * This allows the container to be used for fields or for encapsulating properties with multiple fields.
 * You can see this in {@link PropertyContainer}.
 */
public class DataContainer{
    /**
     * name is the name of the field or property which this DataContainer encapsulates.
     */
    protected String name;
    /**
     * data is the raw data which the DataContainer holds. For a PropertyContainer this field can be an array of other DataContainers.
     */
    protected Object data;
    /**
     * dataType is the data type of {@link DataContainer#data} encoded as a CMW data type.
     */
    protected DataType dataType;
    public DataContainer(String name)   {
        this.name = name;
    }
    public DataContainer(String name, DataType type)   {
        this.name = name;
        this.dataType = type;
    }
    public DataContainer(){}

    /**
     * @return {@link DataContainer#name}
     */
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    /**
     * @return {@link DataContainer#data}
     */
    public Object getData() {return data;}
    /**
     * @return {@link DataContainer#dataType}
     */
    public DataType getDataType() {
        return dataType;
    }
    /**
     * sets {@link DataContainer#data}
     */
    public void setData(Object data) {
        this.data = data;
        if(data instanceof Byte){
            dataType = DataType.DT_BYTE;
        }
        else if(data instanceof Short){
            dataType = DataType.DT_SHORT;
        }
        else if(data instanceof Integer){
            dataType = DataType.DT_INT;
        }
        else if(data instanceof Long){
            dataType = DataType.DT_LONG;
        }
        else if(data instanceof Double){
            dataType = DataType.DT_DOUBLE;
        }
        else if(data instanceof Float){
            dataType = DataType.DT_FLOAT;
        }
        else if(data instanceof String){
            dataType = DataType.DT_STRING;
        }
        else{
            throw new ContainerException("The data you are trying to set is of unsupported type: %s".formatted(data.getClass().getName()));
        }
    }

    /**
     * @return string representation of the DataContainer
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append(" | ");
        if(data!=null){strB.append("Data: ").append(data.toString()).append(" | ");}
        strB.append("Type: ").append(dataType).append("\n");
        return strB.toString();
    }

}
