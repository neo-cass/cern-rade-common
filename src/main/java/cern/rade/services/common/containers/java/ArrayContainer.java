package cern.rade.services.common.containers.java;

import cern.cmw.data.DataType;
import cern.japc.value.ValueType;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Objects;

import static cern.rade.services.common.containers.TypeLookup.getCMWType;

/**
 * Holds a field which is an array
 * **/
public class ArrayContainer extends FieldContainer {
    /**
     * dimensions is a list of the lengths of each dimension of the array. For example, if the array was 2 dimensional
     * with the first dimesniosn being 3 long and the second being 4 long, this array would be [3,4]
     * dimensions.length is the dimension of the array
     */
    private int[] dimensionLens;

    /**
     * elemName is strictly here because of LabVIEW. In LabVIEW each element has a label, however these are all the same
     */
    private String elemName;
    /**
     * elemType is the JAPC data type of the elements of the array
     */
    private ValueType elemType;
    public ArrayContainer(String name){
        super(name);
        this.elemName="";
    }

    public ArrayContainer(String name, String elemName){
        super(name);
        this.elemName = Objects.requireNonNullElse(elemName, "");
    }

    public ArrayContainer(String name, String elemName, ValueType type, ValueType elemType){
        super(name);
        this.elemType = elemType;
        this.elemName = Objects.requireNonNullElse(elemName, "");
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
    public ValueType getElemType() {return elemType;}
}
