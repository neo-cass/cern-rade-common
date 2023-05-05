package cern.rade.services.common.containers.labview;

/**
 * Encapsulates an LV array type descriptor.
 */
public class LVArrayDescriptor extends LVTypeDescriptor {
    /**
     * dimension is the dimension of the LV array.
     */
    private int dimension;
    /**
     * elemDescriptor is the LV type descriptor of the elements in the array. N.B. the element type descriptor is the same for each element.
     */
    private LVTypeDescriptor elemDescriptor;
    public LVArrayDescriptor(String name, int dimension, LVTypeDescriptor elemDescriptor){
        super(LVType.ARRAY, name);
        this.dimension = dimension;
        this.elemDescriptor = elemDescriptor;
    }

    /**
     * @return string representation of the LVArrayDescriptor
     */
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n-----ARRAY DIMENSION AND TYPE-----\n");
        stringBuilder.append("DIMENSION: ");
        stringBuilder.append(dimension);
        stringBuilder.append(", TYPE: ");
        stringBuilder.append(elemDescriptor.toString());
        stringBuilder.append("\n--------------------------------------\n");
        return stringBuilder.toString();
    }

    /**
     * @return {@link LVArrayDescriptor#elemDescriptor}
     */
    public LVTypeDescriptor getElemDescriptor() {
        return elemDescriptor;
    }
    /**
     * @return {@link LVArrayDescriptor#dimension}
     */
    public int getDimension() {
        return dimension;
    }
}
