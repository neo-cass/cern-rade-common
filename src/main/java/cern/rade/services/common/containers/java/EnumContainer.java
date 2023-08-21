package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;

import java.util.HashMap;

public class EnumContainer extends DataContainer {
    private HashMap<String, Integer> enumLabels;
    public EnumContainer(String fieldName) {
        super (fieldName);
    }
    public HashMap<String, Integer> getEnumLabels() {
        return enumLabels;
    }

    //TODO: implement toString
}
