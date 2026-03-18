package cern.rade.services.common.containers.java;

import cern.japc.value.spi.value.SimpleParameterValueImpl;



public class FieldContainer extends SimpleParameterValueImpl implements DataContainer {
    private final String fieldName;
    public FieldContainer(String name) {
        this.fieldName = name;
    }

    public String getName(){
        return fieldName;
    }
}
