package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

import java.util.LinkedHashMap;

/**
 * Encapsulates a property. In practice, a PropertyContainer is a DataContainer where the {@link DataContainer#data} is a {@link DataContainer}.
 */
public class PropertyContainer extends DataContainer{
    private LinkedHashMap<String, DataContainer> data;
    public PropertyContainer(String name)   {
        super(name);
        dataType = DataType.DT_DATA;
        data = new LinkedHashMap<>();
    }
    public PropertyContainer()   {
        dataType = DataType.DT_DATA;
        data = new LinkedHashMap<>();
    }

    public void setSimple(String name, Object field){
        DataContainer curField = data.get(name);
        if(curField==null){
            curField = new DataContainer();
            data.put(name, curField);
        }
        curField.setData(field);
    }
    public void setArray(String name, Object[] array){
        ArrayContainer curField = (ArrayContainer) data.get(name);
        if(curField==null){
            curField = new ArrayContainer();
            data.put(name, curField);
        }
        curField.setData(array);
    }

    public void setArray(String name, Object[] array, int[] dimensions){
        ArrayContainer curField = (ArrayContainer) data.get(name);
        if(curField==null){
            curField = new ArrayContainer();
            data.put(name, curField);
        }
        curField.setData(array, dimensions);
    }

    public void setArray(String name, Object[] array, int dim1, int dim2){
        ArrayContainer curField = (ArrayContainer) data.get(name);
        if(curField==null){
            curField = new ArrayContainer();
            data.put(name, curField);
        }
        curField.setData(array, dim1, dim2);
    }

    public void setProperty(String name, PropertyContainer field){
        data.put(name, field);
    }

    public DataContainer getField(String name){
        return data.get(name);
    }

    /**
     * @return string representation of the PropertyContainer
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Type: ").append(dataType).append("\n");
        strB.append("\n---Begin Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        data.forEach((key, value) -> strB.append(value.toString()));
        strB.append("---End Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        return strB.toString();
    }
}
