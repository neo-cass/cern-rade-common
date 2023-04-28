package cern.rade.services.common.communication.server;

import java.util.Arrays;

public class ServerMetaData {
  private long acquisitionStamp;
    public ServerMetaData(long acquisitionStamp)
    {
        this.acquisitionStamp=acquisitionStamp;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("acquisition stamp: ");
        stringBuilder.append(acquisitionStamp);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
