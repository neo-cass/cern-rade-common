package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

/**
 * Encapsulates a property. In practice, a PropertyContainer is a DataContainer where the {@link DataContainer#data} is a {@link DataContainer}.
 */
public class PropertyContainer extends DataContainer<DataContainer<Object>[]> {
    public PropertyContainer(String name, DataContainer<Object>[] data, DataType dataType)   {
        super(name, data, dataType);
    }

    public PropertyContainer(String name, DataType dataType)   {
        super(name, dataType);
    }

    /**
     * @return string representation of the PropertyContainer
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Data Type: ").append(dataType).append("\n");
        strB.append("\n---Begin Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        for (DataContainer<?> jc : data){
            strB.append(jc.toString());
            strB.append("\n");
        }
        strB.append("---End Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        return strB.toString();
    }
}
