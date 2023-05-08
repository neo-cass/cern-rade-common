package cern.rade.services.common;

import java.nio.ByteBuffer;

/**
 * Utility class for byte conversion which is needed for handling/debugging type descriptors.
 */
public final class BytesUtil {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    /**
     * @param bytes the bytes which you would like to convert into a hexadecimal string.
     * @return a hexadecimal string.
     */
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * @param shorts the short array which would like to convert to a byte array.
     * @return the converted bytes.
     */
    public static byte [] shortArrToByteArr(short [] shorts) {
        byte[] bytes = new byte[shorts.length * 2];
        ByteBuffer.wrap(bytes).asShortBuffer().put(shorts);
        return bytes;
    }

    /**
     * @param bytes the bytes which you want to convert to a short array.
     * @return the converted shorts.
     */
    public static short [] byteArrToShortArr(byte [] bytes) {
        short[] shorts = new short[bytes.length/2];
        ByteBuffer.wrap(bytes).asShortBuffer().get(shorts);
        return shorts;
    }
}
