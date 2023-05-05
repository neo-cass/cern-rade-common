package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;
/**
 * Holds a field which is an array
 * @param <T> Defines the type of array the ArrayContainer will hold
 * **/
public class ArrayContainer<T> extends DataContainer<T[]> {
    /**
     * dimensions is a list of the lengths of each dimension of the array. For example, if the array was 2 dimensional
     * with the first dimesniosn being 3 long and the second being 4 long, this array would be [3,4]
     * dimensions.length is the dimension of the array
     */
    private int[] dimensions;

    /**
     * elemName is strictly here because of LabVIEW. In LabVIEW each element has a label, however these are all the same
     */
    private String elemName;
    /**
     * elemType is the CMW data type of the elements of the array
     */
    private DataType elemType;
    public ArrayContainer(String name, String elemName, T[] data, int[] dimensions, DataType dataType, DataType elemType)   {
        super(name, data, dataType);
        this.dimensions = dimensions;
        this.elemName = elemName;
        this.elemType = elemType;
    }
    /**
     * @return {@link ArrayContainer#dimensions}
     */
    public int[] getDimensions() {return dimensions;}

    /**
     * @param dimensions sets {@link ArrayContainer#dimensions}
     */
    public void setDimensions(int[] dimensions) {this.dimensions = dimensions;}
    /**
     * @return {@link ArrayContainer#elemName}
     */
    public String getElemName() {return elemName;}
    /**
     * @return {@link ArrayContainer#elemType}
     */
    public DataType getElemType() {return elemType;}

    /**
     * @return string representation of the array container
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Array Type: ").append(dataType).append("\n");
        strB.append("Element Name: ").append(elemName).append("\n");
        strB.append("Element Type: ").append(elemType).append("\n");
        strB.append("Data: [");
        for(int i = 0; i< data.length; i++){
            strB.append(data[i].toString());
            if(i != data.length - 1){strB.append(", ");}
        }
        strB.append("]\n");
        return strB.toString();
    }
}
