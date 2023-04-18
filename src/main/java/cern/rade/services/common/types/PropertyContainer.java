package cern.rade.services.common.types;

import cern.cmw.data.DataType;

public class PropertyContainer extends JavaContainer<JavaContainer[]>{
    public PropertyContainer(String name, JavaContainer<?>[] data, DataType dataType)   {
        super(name, data, dataType);
    }

    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Data Type: ").append(dataType).append("\n");
        strB.append("\n---Begin Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        for (JavaContainer jc : data){
            strB.append(jc.toString());
            strB.append("\n");
        }
        strB.append("---End Data For: ");
        strB.append(name);
        strB.append(" ---\n");
        return strB.toString();
    }
}
