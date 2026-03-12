package cern.rade.services.common.containers.java;

import cern.japc.value.MapParameterValue;
import cern.japc.core.factory.MapParameterValueFactory;
import cern.japc.value.ValueType;

public class PropertyContainer extends DataContainer<MapParameterValue> {

    public PropertyContainer(String name) {
        setName(name);
        setParameterValue(MapParameterValueFactory.newMapParameterValue());
    }

    public ValueType getFieldType(String name){
        return getParameterValue().getValueType(name);
    }

    public void setFieldValue(FieldContainer fc) {
        getParameterValue().put(fc.getName(), fc.getParameterValue());
    }

}
