package cern.rade.services.common.types;

import cern.cmw.data.DataType;

public class JavaContainer<T> {
    protected String name;
    protected T data;
    protected DataType dataType;
    public JavaContainer(String name, T data, DataType dataType)   {
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
