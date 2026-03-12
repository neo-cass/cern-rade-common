package cern.rade.services.common.containers.java;

import cern.japc.core.factory.SimpleParameterValueFactory;
import cern.japc.value.SimpleParameterValue;
import cern.japc.value.ValueType;
import cern.japc.value.spi.value.SimpleParameterValueImpl;

public class FieldContainer extends DataContainer<SimpleParameterValue> {
    public FieldContainer(String name) {
        setName(name);
        setParameterValue(SimpleParameterValueFactory.newSimpleParameterValue());
    }

    public ValueType getType(){
        return getParameterValue().getValueType(getName());
    }
}
