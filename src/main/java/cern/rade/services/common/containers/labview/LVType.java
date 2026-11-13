package cern.rade.services.common.containers.labview;

/**
 * An enumeration of all the LV types.
 */
public enum LVType {
     INT_8,
     INT_16,
     INT_32,
     INT_64,
     UINT_8,
     UINT_16,
     UINT_32,
     UINT_64,
     SGL,
     DBL,
     EXT,
     SGL_CPX,
     DBL_CPX,
     EXT_CPX,
     ENUM_8,
     ENUM_16,
     ENUM_32,
     SGL_PHS,
     DBL_PHS,
     EXT_PHS,
     SGL_PHS_CPX,
     DBL_PHS_CPX,
     EXT_PHS_CPX,
     BOOL ,
     STRING,
     PATH,
     PICTURE,
     ARRAY,
     CLUSTER,
     WAVE_FORM,
     REFNUM,
     VARIANT,
     /**
      * Not a LabVIEW type: JAPC discrete function. LabVIEW describes it as a 2D array of DBL (row 0 = X values,
      * row 1 = Y values, so that X and Y always have the same length) and patches the type code of that array
      * descriptor from 0x40 to {@link cern.rade.services.common.containers.TypeLookup#getLVDiscreteFunctionTypeCode()}.
      * The flattened data is the one of the 2D array: dim0 (=2), dim1 (=N), the N X values then the N Y values.
      * <p>
      * A JAPC discrete function list is not a type of its own: it is a 1D LV array whose element is a cluster of
      * exactly one element, a DISCRETE_FUNCTION (LabVIEW cannot nest an array directly in an array).
      */
     DISCRETE_FUNCTION,
     /**
      * Not a LabVIEW type: JAPC enum item set. LabVIEW describes it as a cluster of BOOL, one per enum item, each labelled
      * with the item name (the JAPC enum item symbol), and patches the type code of that cluster descriptor from 0x50 to
      * {@link cern.rade.services.common.containers.TypeLookup#getLVEnumSetTypeCode()}.
      * The flattened data is the one of the cluster: one byte (1 or 0) per item, in the order of the descriptor.
      * <p>
      * Arrays of enum sets are 1D or 2D LV arrays whose element is this cluster.
      */
     ENUM_SET,
     UNKNOWN;
     private LVType(){}
}
