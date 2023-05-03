package cern.rade.services.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class BytesUtil {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte [] shortArrToByteArr(short [] input) {
        byte[] bytes = new byte[input.length * 2];
        ByteBuffer.wrap(bytes).asShortBuffer().put(input);
        return bytes;
    }

    public static short [] byteArrToShortArr(byte [] input) {
        short[] shorts = new short[input.length/2];
        ByteBuffer.wrap(input).asShortBuffer().get(shorts);
        return shorts;
    }
}
