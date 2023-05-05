package cern.rade.services.common.containers.labview;

import static cern.rade.services.common.BytesUtil.bytesToHex;

/**
 * Holds the raw type descriptor bytes from LV.
 */
public class LVRawTypeDescriptor {

    private byte[] bytes;
    private LVRawTypeDescriptor(byte[] bytes){
        this.bytes = bytes;
    }

    /**
     * @param bytes raw type descriptor bytes
     * @return a new instance of LVRawTypeDescriptor with the bytes set.
     */
    public static LVRawTypeDescriptor wrap(byte[] bytes){
        return new LVRawTypeDescriptor(bytes);
    }

    /**
     * @return a string encoded to display the raw bytes as hexadecimal, the way in which NI documentation displays the descriptors.
     */
    public String toString(){
        return bytesToHex(bytes);
    }
}
