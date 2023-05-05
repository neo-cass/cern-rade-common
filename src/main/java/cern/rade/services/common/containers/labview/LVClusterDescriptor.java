package cern.rade.services.common.containers.labview;

/**
 *  Encapsulates an LV cluster type descriptor. The cluster in LV is essentially a property, with each element being a field.
 */
public class LVClusterDescriptor extends LVTypeDescriptor {
    /**
     * fieldDescriptors is an array of descriptors of the elements of the LV cluster.
     */
    private LVTypeDescriptor[] fieldDescriptors;
    public LVClusterDescriptor(String name, LVTypeDescriptor[] fieldDescriptors){
        super(LVType.CLUSTER, name);
        this.fieldDescriptors= fieldDescriptors;

    }

    /**
     * @return {@link LVClusterDescriptor#fieldDescriptors}
     */
    public LVTypeDescriptor[] getFieldDescriptors() {return fieldDescriptors;}
    /**
     * @return string representation of the LVClusterDescriptor
     */
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
