package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;
/**
 * Holds a field which is an array
 * **/
public class ArrayContainer extends DataContainer {
    /**
     * dimensions is a list of the lengths of each dimension of the array. For example, if the array was 2 dimensional
     * with the first dimesniosn being 3 long and the second being 4 long, this array would be [3,4]
     * dimensions.length is the dimension of the array
     */
    private int[] dimensionLens;
    private Object[] data;

    /**
     * elemName is strictly here because of LabVIEW. In LabVIEW each element has a label, however these are all the same
     */
    private String elemName;
    /**
     * elemType is the CMW data type of the elements of the array
     */
    private DataType elemType;
    public ArrayContainer(String name){
        this.name= name;
    }
    public ArrayContainer(String name, String elemName){
        this.name= name;
        this.elemName = elemName;
    }
    public ArrayContainer()   {
        super();
    }

    /**
     * @return {@link ArrayContainer#dimensionLens}
     */
    public int[] getDimensions() {return dimensionLens;}

    /**
     * @param dimensions sets {@link ArrayContainer#dimensionLens}
     */
    public void setDimensions(int[] dimensions) {this.dimensionLens = dimensions;}
    /**
     * @return {@link ArrayContainer#elemName}
     */
    public String getElemName() {return elemName;}
    public void setElemName(String elemName) {this.elemName=elemName;}
    /**
     * @return {@link ArrayContainer#elemType}
     */
    public DataType getElemType() {return elemType;}
    public Object[] getData(){
        return this.data;
    }
    //TODO: consider making a map type to map the array type to the elem type
    public void setData(Object[] data) {
        this.data = data;
        if (data instanceof Byte[]) {
            dataType = DataType.DT_BYTE_ARRAY;
            elemType = DataType.DT_BYTE;
        } else if (data instanceof Short[]) {
            dataType = DataType.DT_SHORT_ARRAY;
            elemType = DataType.DT_SHORT;
        } else if (data instanceof Integer[]) {
            dataType = DataType.DT_INT_ARRAY;
            elemType = DataType.DT_INT;
        } else if (data instanceof Long[]) {
            dataType = DataType.DT_LONG_ARRAY;
            elemType = DataType.DT_LONG;
        } else if (data instanceof Double[]) {
            dataType = DataType.DT_DOUBLE_ARRAY;
            elemType = DataType.DT_DOUBLE;
        } else if (data instanceof Float[]) {
            dataType = DataType.DT_FLOAT_ARRAY;
            elemType = DataType.DT_FLOAT;
        } else if (data instanceof String[]) {
            dataType = DataType.DT_STRING_ARRAY;
            elemType = DataType.DT_STRING;
        } else {
            //TODO: create exception
            throw new RuntimeException();
        }
        this.dimensionLens = new int[]{data.length};
    }

    public void setData(Object[] data, int[] dimensionLens) {
        this.data = data;
        this.dimensionLens = dimensionLens;
        if (data instanceof Byte[]) {
            dataType = DataType.DT_BYTE_MULTI_ARRAY;
            elemType = DataType.DT_BYTE;
        } else if (data instanceof Short[]) {
            dataType = DataType.DT_SHORT_MULTI_ARRAY;
            elemType = DataType.DT_SHORT;
        } else if (data instanceof Integer[]) {
            dataType = DataType.DT_INT_MULTI_ARRAY;
            elemType = DataType.DT_INT;
        } else if (data instanceof Long[]) {
            dataType = DataType.DT_LONG_MULTI_ARRAY;
            elemType=DataType.DT_LONG;
        } else if (data instanceof Double[]) {
            dataType = DataType.DT_DOUBLE_MULTI_ARRAY;
            elemType=DataType.DT_DOUBLE;
        } else if (data instanceof Float[]) {
            dataType = DataType.DT_FLOAT_MULTI_ARRAY;
            elemType=DataType.DT_FLOAT;
        } else if (data instanceof String[]) {
            dataType = DataType.DT_STRING_MULTI_ARRAY;
            elemType = DataType.DT_STRING;
        } else {
            //TODO: create exception
            throw new RuntimeException();
        }
    }

    public void setData(Object[] data, int dim1, int dim2) {
        this.data = data;
        this.dimensionLens = new int[]{dim1, dim2};
        if (data instanceof Byte[]) {
            dataType = DataType.DT_BYTE_ARRAY_2D;
            elemType = DataType.DT_BYTE;
        } else if (data instanceof Short[]) {
            dataType = DataType.DT_SHORT_ARRAY_2D;
            elemType = DataType.DT_SHORT;
        } else if (data instanceof Integer[]) {
            dataType = DataType.DT_INT_ARRAY_2D;
            elemType = DataType.DT_INT;
        } else if (data instanceof Long[]) {
            dataType = DataType.DT_LONG_ARRAY_2D;
            elemType = DataType.DT_LONG;
        } else if (data instanceof Double[]) {
            dataType = DataType.DT_DOUBLE_ARRAY_2D;
            elemType = DataType.DT_DOUBLE;
        } else if (data instanceof Float[]) {
            dataType = DataType.DT_FLOAT_ARRAY_2D;
            elemType = DataType.DT_FLOAT;
        } else if (data instanceof String[]) {
            dataType = DataType.DT_STRING_ARRAY_2D;
            elemType = DataType.DT_STRING;
        } else {
            //TODO: create exception
            throw new RuntimeException();
        }
    }


    /**
     * @return string representation of the array container
     */
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(name).append("\n");
        strB.append("Type: ").append(dataType).append("\n");
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
