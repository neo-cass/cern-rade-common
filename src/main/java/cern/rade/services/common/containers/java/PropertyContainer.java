package cern.rade.services.common.containers.java;

import cern.japc.core.spi.value.MapParameterValueImpl;

public class PropertyContainer extends MapParameterValueImpl implements DataContainer {
    private final String propertyName;
    public PropertyContainer(String name) {
        this.propertyName = name;
    }

    public String getName() {
        return propertyName;
    }
}
