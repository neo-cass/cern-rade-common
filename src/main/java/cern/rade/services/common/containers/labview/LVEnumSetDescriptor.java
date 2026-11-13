package cern.rade.services.common.containers.labview;

/**
 * Encapsulates the descriptor of a set of enum items (JAPC enum item set), see {@link LVType#ENUM_SET}.
 * <p>
 * It is a cluster of booleans, one per item, each labelled with the item name. The flattened value is that of the
 * cluster: one byte per item (1 if the item is in the set, otherwise 0), in the order of {@link #getItems()}.
 */
public class LVEnumSetDescriptor extends LVItemsDescriptor {
    /**
     * @param name  the LV label
     * @param items the item names (the labels of the booleans), in LV order
     */
    public LVEnumSetDescriptor(String name, String[] items) {
        super(LVType.ENUM_SET, name, items);
    }
}
