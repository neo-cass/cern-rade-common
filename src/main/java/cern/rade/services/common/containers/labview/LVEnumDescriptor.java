package cern.rade.services.common.containers.labview;

/**
 * Encapsulates an LV enum type descriptor.
 * <p>
 * A LabVIEW enum is positional: the flattened value is the index (0..n-1) of the selected item, as an unsigned 8, 16
 * or 32 bit integer, and the type descriptor carries the item names. A JAPC enum has arbitrary codes, so the two are
 * mapped by item name, never by code.
 */
public class LVEnumDescriptor extends LVItemsDescriptor {
    /**
     * @param name   the LV label
     * @param lvType one of {@link LVType#ENUM_8}, {@link LVType#ENUM_16} or {@link LVType#ENUM_32}
     * @param items  the item names in LV order (the index of an item is its LV value)
     */
    public LVEnumDescriptor(String name, LVType lvType, String[] items) {
        super(lvType, name, items);
        if (!isEnum(lvType)) {
            throw new IllegalArgumentException("LVEnumDescriptor requires an enum LVType, got " + lvType);
        }
    }

    /**
     * @return true if the LV type is one of the enum types ({@link LVType#ENUM_8}, {@link LVType#ENUM_16}, {@link LVType#ENUM_32}).
     */
    public static boolean isEnum(LVType lvType) {
        return lvType == LVType.ENUM_8 || lvType == LVType.ENUM_16 || lvType == LVType.ENUM_32;
    }
}
