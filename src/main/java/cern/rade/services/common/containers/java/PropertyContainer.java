package cern.rade.services.common.containers.java;

import cern.japc.core.spi.value.MapParameterValueImpl;
import cern.japc.value.SimpleParameterValue;

public class PropertyContainer extends MapParameterValueImpl implements DataContainer {
    private final String propertyName;

    public PropertyContainer(String name) {
        this.propertyName = name;
    }

    @Override
    public String getName() {
        return propertyName;
    }

    @Override
    public void put(String name, SimpleParameterValue value) {
        if (value instanceof FieldContainer fc) {
            super.put(name, fc);
        } else {
            super.put(name, new FieldContainer(name, value)); // full copy, wrap once on entry
        }
    }

    public void put(DataContainer container) {
        if (container instanceof FieldContainer fc) {
            this.put(fc);
        } else if (container instanceof PropertyContainer pc) {
            throw new UnsupportedOperationException("Nested PropertyContainers are not supported");
        } else {
            throw new IllegalArgumentException("Unknown DataContainer type: " + container.getClass());
        }
    }

    public void put(FieldContainer field) {
        super.put(field.getName(), field);
    }

    @Override
    public FieldContainer get(String name) {
        return (FieldContainer) super.get(name); // always safe — put() enforces the invariant
    }
}
