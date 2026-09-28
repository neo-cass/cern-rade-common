package cern.rade.services.common.containers.java;

import cern.japc.core.MapParameterDescriptor;
import cern.japc.core.spi.MapParameterDescriptorImpl;
import cern.japc.core.spi.value.AbstractMapParameterValue;
import cern.japc.core.spi.value.MapParameterValueImpl;
import cern.japc.value.SimpleParameterValue;
import cern.japc.value.ValueDescriptor;
import cern.japc.value.ValueType;

import java.util.LinkedHashMap;
import java.util.Map;

public class PropertyContainer extends MapParameterValueImpl implements DataContainer {
    private final String propertyName;

    // enforce ordered Map is passed to preserve insertion order
    public PropertyContainer(String name) {
        super(new LinkedHashMap<>());
        this.propertyName = name;
    }

    public PropertyContainer(String name, LinkedHashMap<String, SimpleParameterValue> namesAndValues) {
        super(namesAndValues);
        this.propertyName = name;
    }

    public SimpleParameterValue setValueType(String name, ValueType valueType){
        return super.createOrGetValue(name, valueType);
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
    // the clone in AbstractParameterValue makes namesAndValues a HashMap, which is unordered, we need an ordered Map otherwise when we send back to LabVIEW it will be corrupted
    @Override
    public Object clone() {
        // 1. Let the framework clone the metadata and the internal SimpleParameterValues
        PropertyContainer cloned = (PropertyContainer) super.clone();

        try {
            // 2. Grab the private field from the abstract parent class
            java.lang.reflect.Field field = AbstractMapParameterValue.class.getDeclaredField("namesAndValues");
            field.setAccessible(true);

            // 3. Get the unordered HashMap created by super.clone()
            @SuppressWarnings("unchecked")
            Map<String, SimpleParameterValue> clonedHashMap = (Map<String, SimpleParameterValue>) field.get(cloned);

            // 4. Create a new LinkedHashMap to restore the order
            Map<String, SimpleParameterValue> orderedMap = new LinkedHashMap<>(clonedHashMap.size());

            // 5. Populate it using the exact insertion order of the ORIGINAL object ('this')
            for (String name : this.getNames()) {
                orderedMap.put(name, clonedHashMap.get(name));
            }

            // 6. Inject our LinkedHashMap back into the cloned object
            field.set(cloned, orderedMap);

        } catch (Exception e) {
            throw new RuntimeException("Failed to restore LinkedHashMap order during clone", e);
        }

        return cloned;
    }
}
