package cern.rade.services.common.containers.java;

import cern.japc.core.SimpleParameterDescriptor;
import cern.japc.core.factory.SimpleParameterValueFactory;
import cern.japc.value.SimpleParameterValue;
import cern.japc.value.ValueDescriptor;
import cern.japc.value.ValueStatus;
import cern.japc.value.spi.value.SimpleParameterValueImpl;



public class FieldContainer extends SimpleParameterValueImpl implements DataContainer {
    private final String fieldName;

    public FieldContainer(String name) {
        this.fieldName = name;
    }

    // State is fully copied via AbstractMapSimpleValue.put() — no delegation needed
    public FieldContainer(String name, SimpleParameterValue value) {
        this.fieldName = name;
        super.put(name, value); // copies all fields from value into this
    }

    @Override
    public String getName() {
        return fieldName;
    }

    @Override
    public FieldContainer clone() {
        return (FieldContainer) super.clone();
    }
}
