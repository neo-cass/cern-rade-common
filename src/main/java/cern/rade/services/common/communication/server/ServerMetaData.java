package cern.rade.services.common.communication.server;

import java.util.Arrays;

public class ServerMetaData {
  private long acquisitionStamp;
  private short[] type_descriptor;
    public ServerMetaData(long acquisitionStamp, short[] type_descriptor)
    {
        this.acquisitionStamp=acquisitionStamp;
        this.type_descriptor = type_descriptor;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type descriptor: ");
        stringBuilder.append(Arrays.toString(type_descriptor));
        stringBuilder.append("\n");
        stringBuilder.append("acquisition stamp: ");
        stringBuilder.append(acquisitionStamp);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
