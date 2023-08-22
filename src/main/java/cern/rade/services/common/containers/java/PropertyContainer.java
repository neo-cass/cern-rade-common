package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Encapsulates a property. In practice, a PropertyContainer is a DataContainer where the {@link DataContainer#data} is a {@link DataContainer}.
 */
public class PropertyContainer extends DataContainer implements Cloneable{
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
            curField = new DataContainer(name);
            data.put(name, curField);
        }
        curField.setData(field);
    }

    public void setArray(String name, Object[] array){
        ArrayContainer curField = (ArrayContainer) data.get(name);
        if(curField==null){
            curField = new ArrayContainer(name);
            data.put(name, curField);
        }
        curField.setData(array);
    }

    public void setArray(String name, Object[] array, int[] dimensions){
        ArrayContainer curField = (ArrayContainer) data.get(name);
        if(curField==null){
            curField = new ArrayContainer(name);
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
    public void setDataContainer(String name, DataContainer field){
        data.put(name, field);
    }

    public void setDataContainer(DataContainer field){
        data.put(field.getName(), field);
    }

    public DataContainer getField(String name){
        return data.get(name);
    }
    public LinkedHashMap<String, DataContainer> getData(){
        return this.data;
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

    @Override
    public PropertyContainer clone() {
        PropertyContainer clone = new PropertyContainer(name);
        for(Map.Entry<String, DataContainer> entry : data.entrySet()){
            DataContainer val = entry.getValue();
            String key = entry.getKey();
            if(val instanceof ArrayContainer){
                clone.setDataContainer(key, new ArrayContainer(key));
            }
            else if(val instanceof PropertyContainer){
                clone.setProperty(key, ((PropertyContainer) val).clone());
            }
            else {
                clone.setDataContainer(key, new DataContainer(key));
            }
        }
        return clone;
    }
}
