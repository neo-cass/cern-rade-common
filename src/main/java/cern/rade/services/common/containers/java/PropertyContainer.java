package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Encapsulates a property. In practice, a PropertyContainer is a DataContainer where the {@link DataContainer#data} is a {@link DataContainer}.
 */
public class PropertyContainer extends DataContainer {
    private LinkedHashMap<String, DataContainer> data;
    public PropertyContainer(String name)   {
        super(name, DataType.DT_DATA);
        data = new LinkedHashMap<>();
    }
    public PropertyContainer()   {
        dataType = DataType.DT_DATA;
        data = new LinkedHashMap<>();
    }
    private ArrayContainer getOrCreateArrayField(String name){
        ArrayContainer field = (ArrayContainer) data.get(name);
        if(field==null){
            field = new ArrayContainer(name);
            data.put(name, field);
        }
        return field;
    }
    private DataContainer getOrCreateSimpleField(String name){
        DataContainer field = data.get(name);
        if(field==null){
            field = new DataContainer(name);
            data.put(name, field);
        }
        return field;
    }
    public void setSimple(String name, Object field) throws ContainerException {
        getOrCreateSimpleField(name).setData(field);
    }

    public void setArray(String name, Object[] array) throws ContainerException {
        getOrCreateArrayField(name).setData(array);
    }

    public void setArray(String name, Object[] array, int[] dimensions) throws ContainerException {
        getOrCreateArrayField(name).setData(array, dimensions);
    }

    public void setArray(String name, Object[] array, int dim1, int dim2) throws ContainerException {
        getOrCreateArrayField(name).setData(array, dim1, dim2);
    }
    public void setProperty(String name, PropertyContainer field){
        data.put(name, field);
    }
    public void setDataContainer(String name, DataContainer field){
        data.put(name, field);
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

}
