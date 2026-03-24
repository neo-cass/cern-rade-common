package cern.rade.services.common.containers;
import cern.cmw.data.DataType;
import cern.japc.value.ValueType;
import cern.rade.services.common.containers.labview.LVType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

/**
 * Utility class which contains mappings of types in one form to another.
 */
public final class TypeLookup {
    private static final HashMap<Byte, LVType> lookupLVTypeByCode = new HashMap<>( Map.ofEntries(
            entry((byte)0x01, LVType.INT_8),
            entry((byte)0x02, LVType.INT_16),
            entry((byte)0x03, LVType.INT_32),
            entry((byte)0x04, LVType.INT_64),
            entry((byte)0x05, LVType.UINT_8),
            entry((byte)0x06, LVType.UINT_16),
            entry((byte)0x07, LVType.UINT_32),
            entry((byte)0x08, LVType.UINT_64),
            entry((byte)0x09, LVType.SGL),
            entry((byte)0x0A, LVType.DBL),
            entry((byte)0x0B, LVType.EXT),
            entry((byte)0x0C, LVType.SGL_CPX),
            entry((byte)0x0D, LVType.DBL_CPX),
            entry((byte)0x0E, LVType.EXT_CPX),
            entry((byte)0x15, LVType.ENUM_8),
            entry((byte)0x16, LVType.ENUM_16),
            entry((byte)0x17, LVType.ENUM_32),
            entry((byte)0x19, LVType.SGL_PHS),
            entry((byte)0x1A, LVType.DBL_PHS),
            entry((byte)0x1B, LVType.EXT_PHS),
            entry((byte)0x1C, LVType.SGL_PHS_CPX),
            entry((byte)0x1D, LVType.DBL_PHS_CPX),
            entry((byte)0x1E, LVType.EXT_PHS_CPX),
            entry((byte)0x21, LVType.BOOL),
            entry((byte)0x30, LVType.STRING),
            entry((byte)0x32, LVType.PATH),
            entry((byte)0x33, LVType.PICTURE),
            entry((byte)0x40, LVType.ARRAY),
            entry((byte)0x50, LVType.CLUSTER),
            entry((byte)0x54, LVType.WAVE_FORM),
            entry((byte)0x70, LVType.REFNUM),
            entry((byte)0x53, LVType.VARIANT),
            entry((byte)-1, LVType.UNKNOWN)
    ));

//    private static final HashMap<DataType, Byte> lookupUpLVTypeCodeByCMW = new HashMap<>( Map.ofEntries(
//            entry(DataType.DT_BYTE, (byte)0x01),
//            entry(DataType.DT_BOOL, (byte)0x21),
//            entry(DataType.DT_SHORT, (byte)0x02),
//            entry(DataType.DT_INT, (byte)0x03),
//            entry(DataType.DT_LONG, (byte)0x04),
//            entry(DataType.DT_FLOAT, (byte)0x09),
//            entry(DataType.DT_DOUBLE, (byte)0x0A),
//            entry(DataType.DT_STRING, (byte)0x30),
//            entry(DataType.DT_BYTE_ARRAY, (byte)0x40),
//            entry(DataType.DT_BOOL_ARRAY, (byte)0x40),
//            entry(DataType.DT_SHORT_ARRAY, (byte)0x40),
//            entry(DataType.DT_INT_ARRAY, (byte)0x40),
//            entry(DataType.DT_LONG_ARRAY, (byte)0x40),
//            entry(DataType.DT_FLOAT_ARRAY, (byte)0x40),
//            entry(DataType.DT_DOUBLE_ARRAY, (byte)0x40),
//            entry(DataType.DT_STRING_ARRAY, (byte)0x40),
//            entry(DataType.DT_BYTE_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_BOOL_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_SHORT_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_INT_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_LONG_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_FLOAT_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_DOUBLE_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_STRING_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_BYTE_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_BOOL_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_SHORT_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_INT_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_LONG_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_FLOAT_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_DOUBLE_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_STRING_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_DATA_ARRAY, (byte)0x40),
//            entry(DataType.DT_DATA_ARRAY_2D, (byte)0x40),
//            entry(DataType.DT_DATA_MULTI_ARRAY, (byte)0x40),
//            entry(DataType.DT_DATA, (byte)0x50)
//    ));

    private static final HashMap<LVType, ValueType> lookupJAPCTypeByLVType = new HashMap<>( Map.ofEntries(
            entry(LVType.INT_8,   ValueType.BYTE),
            entry(LVType.INT_16,  ValueType.SHORT),
            entry(LVType.INT_32,  ValueType.INT),
            entry(LVType.INT_64,  ValueType.LONG),
            entry(LVType.UINT_8,  ValueType.SHORT),
            entry(LVType.UINT_16, ValueType.INT),
            entry(LVType.UINT_32, ValueType.LONG),
            entry(LVType.SGL,     ValueType.FLOAT),
            entry(LVType.DBL,     ValueType.DOUBLE),
            entry(LVType.ENUM_8,  ValueType.ENUM),
            entry(LVType.ENUM_16, ValueType.ENUM),
            entry(LVType.ENUM_32, ValueType.ENUM),
            entry(LVType.BOOL,    ValueType.BOOLEAN),
            entry(LVType.STRING,  ValueType.STRING)
    ));

//    private static final HashMap<ValueType, DataType> lookupCMWByJAPCType = new HashMap<>( Map.ofEntries(
//            entry(ValueType.BYTE, DataType.DT_BYTE),
//            entry(ValueType.SHORT, DataType.DT_SHORT),
//            entry(ValueType.INT, DataType.DT_INT),
//            entry(ValueType.LONG, DataType.DT_LONG),
//            entry(ValueType.FLOAT,DataType.DT_FLOAT),
//            entry(ValueType.DOUBLE,DataType.DT_DOUBLE),
//            entry(ValueType.ENUM,DataType.DT_INT),
//            entry(ValueType.BOOLEAN,DataType.DT_BOOL),
//            entry(ValueType.STRING,DataType.DT_STRING),
//
//            entry(ValueType.BYTE_ARRAY, DataType.DT_BYTE_ARRAY),
//            entry(ValueType.SHORT_ARRAY, DataType.DT_SHORT_ARRAY),
//            entry(ValueType.INT_ARRAY, DataType.DT_INT_ARRAY),
//            entry(ValueType.LONG_ARRAY, DataType.DT_LONG_ARRAY),
//            entry(ValueType.FLOAT_ARRAY,DataType.DT_FLOAT_ARRAY),
//            entry(ValueType.DOUBLE_ARRAY,DataType.DT_DOUBLE_ARRAY),
//            entry(ValueType.ENUM_ARRAY,DataType.DT_INT_ARRAY),
//            entry(ValueType.BOOLEAN_ARRAY,DataType.DT_BOOL_ARRAY),
//            entry(ValueType.STRING_ARRAY,DataType.DT_STRING_ARRAY),
//
//            entry(ValueType.BYTE_ARRAY_2D, DataType.DT_BYTE_ARRAY_2D),
//            entry(ValueType.SHORT_ARRAY_2D, DataType.DT_SHORT_ARRAY_2D),
//            entry(ValueType.INT_ARRAY_2D, DataType.DT_INT_ARRAY_2D),
//            entry(ValueType.LONG_ARRAY_2D, DataType.DT_LONG_ARRAY_2D),
//            entry(ValueType.FLOAT_ARRAY_2D,DataType.DT_FLOAT_ARRAY_2D),
//            entry(ValueType.DOUBLE_ARRAY_2D,DataType.DT_DOUBLE_ARRAY_2D),
//            entry(ValueType.ENUM_ARRAY_2D,DataType.DT_INT_ARRAY_2D),
//            entry(ValueType.BOOLEAN_ARRAY_2D,DataType.DT_BOOL_ARRAY_2D),
//            entry(ValueType.STRING_ARRAY_2D,DataType.DT_STRING_ARRAY_2D)
//    ));

    private static final HashMap<ValueType, Byte> lookupLVTypeCodeByJAPCType = new HashMap<>( Map.ofEntries(
            entry(ValueType.BYTE,             (byte)0x01),
            entry(ValueType.SHORT,            (byte)0x02),
            entry(ValueType.INT,              (byte)0x03),
            entry(ValueType.LONG,             (byte)0x04),
            entry(ValueType.FLOAT,            (byte)0x09),
            entry(ValueType.DOUBLE,           (byte)0x0A),
            entry(ValueType.ENUM,             (byte)0x03),
            entry(ValueType.BOOLEAN,          (byte)0x21),
            entry(ValueType.STRING,           (byte)0x30),

            entry(ValueType.BYTE_ARRAY,       (byte)0x40),
            entry(ValueType.SHORT_ARRAY,      (byte)0x40),
            entry(ValueType.INT_ARRAY,        (byte)0x40),
            entry(ValueType.LONG_ARRAY,       (byte)0x40),
            entry(ValueType.FLOAT_ARRAY,      (byte)0x40),
            entry(ValueType.DOUBLE_ARRAY,     (byte)0x40),
            entry(ValueType.ENUM_ARRAY,       (byte)0x40),
            entry(ValueType.BOOLEAN_ARRAY,    (byte)0x40),
            entry(ValueType.STRING_ARRAY,     (byte)0x40),

            entry(ValueType.BYTE_ARRAY_2D,    (byte)0x40),
            entry(ValueType.SHORT_ARRAY_2D,   (byte)0x40),
            entry(ValueType.INT_ARRAY_2D,     (byte)0x40),
            entry(ValueType.LONG_ARRAY_2D,    (byte)0x40),
            entry(ValueType.FLOAT_ARRAY_2D,   (byte)0x40),
            entry(ValueType.DOUBLE_ARRAY_2D,  (byte)0x40),
            entry(ValueType.ENUM_ARRAY_2D,    (byte)0x40),
            entry(ValueType.BOOLEAN_ARRAY_2D, (byte)0x40),
            entry(ValueType.STRING_ARRAY_2D,  (byte)0x40)
    ));

    private TypeLookup() {

    }

    public static LVType getLVType(byte type){
        return lookupLVTypeByCode.get(type);
    }

    public static ValueType getJAPCType(LVType type){return lookupJAPCTypeByLVType.get(type);}

    /**
     * @param type the data type which you would like the LV type code for.
     * @return The LV type code which the CMW data type maps to.
     */
    public static byte getLVTypeCode(ValueType type){return lookupLVTypeCodeByJAPCType.get(type);}

    public static byte getLVClusterTypeCode(){
        return  (byte) 0x50;
    }

    public static byte getLVArrayTypeCode(){
        return  (byte) 0x40;
    }

    /**
     *
     * @param dt the data type of the elements in the array.
     * @param dimension the dimension of the array.
     * @return The CMW data type of the array, with dimension specified.
     */
    public static DataType getCMWType(DataType dt, int dimension){
            DataType dataType = null;
            if (dimension == 1){
                switch(dt){
                    case DT_BYTE -> dataType = DataType.DT_BYTE_ARRAY;
                    case DT_SHORT -> dataType = DataType.DT_SHORT_ARRAY;
                    case DT_INT -> dataType = DataType.DT_INT_ARRAY;
                    case DT_LONG -> dataType = DataType.DT_LONG_ARRAY;
                    case DT_FLOAT -> dataType = DataType.DT_FLOAT_ARRAY;
                    case DT_DOUBLE -> dataType = DataType.DT_DOUBLE_ARRAY;
                    case DT_BOOL -> dataType = DataType.DT_BOOL_ARRAY;
                    case DT_STRING -> dataType = DataType.DT_STRING_ARRAY;
                    case DT_DATA -> dataType = DataType.DT_DATA_ARRAY;
                }
            }
            else if (dimension == 2){
                switch(dt){
                    case DT_BYTE -> dataType = DataType.DT_BYTE_ARRAY_2D;
                    case DT_SHORT -> dataType = DataType.DT_SHORT_ARRAY_2D;
                    case DT_INT -> dataType = DataType.DT_INT_ARRAY_2D;
                    case DT_LONG -> dataType = DataType.DT_LONG_ARRAY_2D;
                    case DT_FLOAT -> dataType = DataType.DT_FLOAT_ARRAY_2D;
                    case DT_DOUBLE -> dataType = DataType.DT_DOUBLE_ARRAY_2D;
                    case DT_BOOL -> dataType = DataType.DT_BOOL_ARRAY_2D;
                    case DT_STRING -> dataType = DataType.DT_STRING_ARRAY_2D;
                    case DT_DATA -> dataType = DataType.DT_DATA_ARRAY_2D;
                }
            }
            else if (dimension > 2){
                switch(dt){
                    case DT_BYTE -> dataType = DataType.DT_BYTE_MULTI_ARRAY;
                    case DT_SHORT -> dataType = DataType.DT_SHORT_MULTI_ARRAY;
                    case DT_INT -> dataType = DataType.DT_INT_MULTI_ARRAY;
                    case DT_LONG -> dataType = DataType.DT_LONG_MULTI_ARRAY;
                    case DT_FLOAT -> dataType = DataType.DT_FLOAT_MULTI_ARRAY;
                    case DT_DOUBLE -> dataType = DataType.DT_DOUBLE_MULTI_ARRAY;
                    case DT_BOOL -> dataType = DataType.DT_BOOL_MULTI_ARRAY;
                    case DT_STRING -> dataType = DataType.DT_STRING_MULTI_ARRAY;
                    case DT_DATA -> dataType = DataType.DT_DATA_MULTI_ARRAY;
                }
            }
        return dataType;
        }


}
