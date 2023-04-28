package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

/**
 * This class is made to encapsulate a field at CERN. However, it is slightly more abstract as we are using a type T
 * This allows the container to be used for fields or for encapsulating properties with multiple fields.
 * You can see this in {@link PropertyContainer}
 * @param <T> The type which the container will hold
 */
public class DataContainer<T> {
    protected String name;
    protected T data;
    protected DataType dataType;
    public DataContainer(String name, T data, DataType dataType)   {
        this.name = name;
        this.data = data;
        this.dataType = dataType;
    }
    public String getName() {
        return name;
    }

    public T getData() {return data;}

    public DataType getDataType() {
        return dataType;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Data: ").append(data.toString()).append("\n");
        strB.append("Data Type: ").append(dataType).append("\n");
        return strB.toString();
    }
}
