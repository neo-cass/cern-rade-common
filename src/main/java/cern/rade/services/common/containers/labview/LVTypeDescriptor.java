package cern.rade.services.common.containers.labview;

/**
 * Encapsulates an LV type descriptor. Any type descriptor inherits from this class as it is the most fundamental/elementary.
 */
public class LVTypeDescriptor {
    /**
     * lvType is the LV type
     */
    private LVType lvType;
    /**
     * The LV label of the data. Can be empty if the label is empty.
     */
    private String name;
    public LVTypeDescriptor(LVType lvType, String name){
        this.lvType = lvType;
        this.name = name;
    }

    /**
     * @return {@link LVTypeDescriptor#lvType}
     */
    public LVType getType() {
        return lvType;
    }
    /**
     * @return {@link LVTypeDescriptor#name}
     */
    public String getName() {return name;}

    /**
     * @return string representation of the LVTypeDescriptor
     */
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append(", Type: ");
        stringBuilder.append(lvType);
        stringBuilder.append(" | ");
        return stringBuilder.toString();
    }
}
