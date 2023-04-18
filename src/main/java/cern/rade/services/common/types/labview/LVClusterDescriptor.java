package cern.rade.services.common.types.labview;

public class LVClusterDescriptor extends LVTypeDescriptor {
    private LVTypeDescriptor[] fieldDescriptors;
    public LVClusterDescriptor(String name, LVTypeDescriptor[] fieldDescriptors){
        super(LVType.CLUSTER, name);
        this.fieldDescriptors= fieldDescriptors;

    }
    public LVTypeDescriptor[] getFieldDescriptors() {return fieldDescriptors;}

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n-----CLUSTER INFO-----\n");
        for (int i = 0; i< fieldDescriptors.length; i++){
            stringBuilder.append(fieldDescriptors[i].toString());
        }
        stringBuilder.append("\n----------------------\n");
        return stringBuilder.toString();
    }
}
