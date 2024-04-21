package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Objects;

import static cern.rade.services.common.containers.TypeLookup.getCMWType;

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
    private Object data;

    /**
     * elemName is strictly here because of LabVIEW. In LabVIEW each element has a label, however these are all the same
     */
    private String elemName;
    /**
     * elemType is the CMW data type of the elements of the array
     */
    private DataType elemType;
    public ArrayContainer(String name){
        super(name);
        this.elemName="";
    }
    public ArrayContainer(String name, DataType type){
        super(name, type);
        this.elemName="";
    }
    public ArrayContainer(String name, String elemName){
        super(name);
        this.elemName = Objects.requireNonNullElse(elemName, "");
    }
    //TODO: elemType not set? it is instead set in setData
    public ArrayContainer(String name, String elemName, DataType type){
        super(name, type);
        this.elemName = Objects.requireNonNullElse(elemName, "");
    }

    public ArrayContainer(String name, String elemName, DataType type, DataType elemType){
        super(name, type);
        this.elemType=elemType;
        this.elemName = Objects.requireNonNullElse(elemName, "");
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
    public void setDimensions(int[] dimensions) {
        this.dimensionLens = dimensions;
    }
    /**
     * @return {@link ArrayContainer#elemName}
     */
    public String getElemName() {return elemName;}
    public void setElemName(String elemName) {this.elemName=elemName;}
    /**
     * @return {@link ArrayContainer#elemType}
     */
    public DataType getElemType() {return elemType;}
    public Object getData(){
        return this.data;
    }

    //TODO: consider making a map type to map the array type to the elem type
    public void setData(Object data) throws ContainerException {
        if(!data.getClass().isArray()){
            throw new ContainerException("The data you are trying to set is not an array.");
        }
        Class<?> clazz = data.getClass();
        Class<?> componentType = data.getClass().getComponentType();
        if(!clazz.isPrimitive()){
            this.data = ArrayUtils.toPrimitive(data);
        }
        else{
            this.data = data;
        }
        if (componentType == Byte.TYPE || componentType == Byte.class) {
            elemType = DataType.DT_BYTE;
        } else if (componentType == Boolean.TYPE || componentType == Boolean.class) {
            elemType = DataType.DT_BOOL;
        } else if (componentType == Short.TYPE || componentType == Short.class) {
            elemType = DataType.DT_SHORT;
        } else if (componentType == Integer.TYPE || componentType == Integer.class) {
            elemType = DataType.DT_INT;
        } else if (componentType == Long.TYPE || componentType == Long.class){
            elemType = DataType.DT_LONG;
        } else if (componentType == Double.TYPE || componentType == Double.class) {
            elemType = DataType.DT_DOUBLE;
        } else if (componentType == Float.TYPE || componentType == Float.class){
            elemType = DataType.DT_FLOAT;
        } else if (componentType == String.class) {
            elemType = DataType.DT_STRING;
        } else {
            throw new ContainerException("The data you are trying to set is of unsupported type: %s".formatted(data.getClass().getName()));
        }
        dataType = getCMWType(elemType, 1);
        this.dimensionLens = new int[]{Array.getLength(data)};
    }

    public void setData(Object data, int[] dimensionLens) throws ContainerException {
        this.setData(data);
        this.dataType = getCMWType(elemType, dimensionLens.length);
        this.dimensionLens = dimensionLens;
    }

    public void setData(Object data, int dim1, int dim2) throws ContainerException {
        this.setData(data);
        this.dataType = getCMWType(elemType, 2);
        this.dimensionLens = new int[]{dim1, dim2};
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
        if(data==null){
            strB.append("Data: null\n");
            return strB.toString();
        }
        //TODO print data
        return strB.toString();
    }
}
