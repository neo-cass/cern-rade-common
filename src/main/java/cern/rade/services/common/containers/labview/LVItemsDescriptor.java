package cern.rade.services.common.containers.labview;

import java.util.Arrays;

/**
 * Base of the LV type descriptors which are defined by a list of named items: the enums ({@link LVEnumDescriptor})
 * and the enum sets ({@link LVEnumSetDescriptor}).
 * <p>
 * The item names are the ones of the JAPC enum items (their symbols); they are the only link between the LV and the
 * JAPC side, as LV values are positional while JAPC enum items have arbitrary codes.
 */
public abstract class LVItemsDescriptor extends LVTypeDescriptor {
    /**
     * items are the item names, in the order of the LV type descriptor.
     */
    private final String[] items;

    /**
     * @param lvType the LV type
     * @param name   the LV label
     * @param items  the item names in LV order
     */
    protected LVItemsDescriptor(LVType lvType, String name, String[] items) {
        super(lvType, name);
        this.items = items.clone();
    }

    /**
     * @return a copy of the item names, in LV order.
     */
    public String[] getItems() {
        return items.clone();
    }

    /**
     * @return the number of items.
     */
    public int size() {
        return items.length;
    }

    /**
     * @return the name of the item at the given LV position.
     */
    public String getItem(int index) {
        return items[index];
    }

    /**
     * @return the LV position of the item with the given name, or -1 if it is not part of this descriptor.
     */
    public int indexOf(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return string representation of the descriptor
     */
    @Override
    public String toString() {
        return super.toString() + "Items: " + Arrays.toString(items) + " | ";
    }
}
