package cern.rade.services.common.containers.labview;

import static cern.rade.services.common.BytesUtil.bytesToHex;

public class LVRawTypeDescriptor {

    private byte[] bytes;
    private LVRawTypeDescriptor(byte[] bytes){
        this.bytes = bytes;
    }
    public static LVRawTypeDescriptor wrap(byte[] bytes){
        return new LVRawTypeDescriptor(bytes);
    }

    public String toString(){
        return bytesToHex(bytes);
    }
}
