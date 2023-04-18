package cern.rade.services.common.types.labview;

public class LVArrayDescriptor extends LVTypeDescriptor {
    private int dimension;
    private LVTypeDescriptor elemDescriptor;
    public LVArrayDescriptor(String name, int dimension, LVTypeDescriptor elemDescriptor){
        super(LVType.ARRAY, name);
        this.dimension = dimension;
        this.elemDescriptor = elemDescriptor;
    }
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
    public LVTypeDescriptor getElemDescriptor() {
        return elemDescriptor;
    }

    public int getDimension() {
        return dimension;
    }
}
