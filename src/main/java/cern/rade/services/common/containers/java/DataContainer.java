package cern.rade.services.common.containers.java;

import cern.japc.core.spi.value.MapParameterValueImpl;
import cern.japc.value.MapParameterValue;
import cern.japc.value.ParameterValue;
import cern.japc.value.Type;
import cern.japc.value.ValueType;

public abstract class DataContainer<T extends MapParameterValue> {
    private String name;
    private T pv;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getParameterValue(){return pv;};
    public void setParameterValue(T pv) {
        this.pv = pv;
    }

    @Override
    public  String toString(){
        return getName() + ":" + getParameterValue().toString();
    }
}
