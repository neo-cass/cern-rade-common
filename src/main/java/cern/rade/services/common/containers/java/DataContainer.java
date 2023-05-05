package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

/**
 * This class is made to encapsulate a field at CERN. However, it is slightly more abstract as we are using a type T
 * This allows the container to be used for fields or for encapsulating properties with multiple fields.
 * You can see this in {@link PropertyContainer}.
 * @param <T> The type which the container will hold.
 */
public class DataContainer<T> {
    /**
     * name is the name of the field or property which this DataContainer encapsulates.
     */
    protected String name;
    /**
     * data is the raw data which the DataContainer holds. For a PropertyContainer this field can be an array of other DataContainers.
     */
    protected T data;
    /**
     * dataType is the data type of {@link DataContainer#data} encoded as a CMW data type.
     */
    protected DataType dataType;
    public DataContainer(String name, T data, DataType dataType)   {
        this.name = name;
        this.data = data;
        this.dataType = dataType;
    }

    /**
     * @return {@link DataContainer#name}
     */
    public String getName() {
        return name;
    }
    /**
     * @return {@link DataContainer#data}
     */
    public T getData() {return data;}
    /**
     * @return {@link DataContainer#dataType}
     */
    public DataType getDataType() {
        return dataType;
    }
    /**
     * sets {@link DataContainer#data}
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return string representation of the DataContainer
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Data: ").append(data.toString()).append("\n");
        strB.append("Data Type: ").append(dataType).append("\n");
        return strB.toString();
    }
}
