package cern.rade.services.common.communication.client;

import cern.rade.services.common.containers.java.DataContainer;

public class Request {
    private ClientMetaData clientMetaData;
    private DataContainer<?> data;
    private RequestAction requestAction;
    private RequestLanguage requestLanguage;
    private int id;

    public Request(ClientMetaData clientMetaData, DataContainer<?> data, String requestType, String requestLanguage)
    {
        this.clientMetaData = clientMetaData;
        this.data=data;
        this.requestAction = RequestAction.valueOf(requestType);
        this.requestLanguage = RequestLanguage.valueOf(requestLanguage);
        this.id = createID();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("meta data: ");
        stringBuilder.append(clientMetaData);
        stringBuilder.append("\n");

        stringBuilder.append("data: ");
        stringBuilder.append(data);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    private int createID(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clientMetaData.getUsername()).append("/");
        stringBuilder.append(clientMetaData.getDevice()).append("/");
        stringBuilder.append(clientMetaData.getProperty()).append("/");
        stringBuilder.append(clientMetaData.getRequest_action()).append("/");
        stringBuilder.append(clientMetaData.getRequest_language()).append("/");
        stringBuilder.append(clientMetaData.getSelector());
        return stringBuilder.toString().hashCode();
    }
    public ClientMetaData getMetaData() {
        return clientMetaData;
    }

    public DataContainer<?> getData() {
        return data;
    }
    public int getId() {
        return id;
    }

    public RequestAction getRequestAction() {
        return requestAction;
    }

    public RequestLanguage getRequestLanguage() {
        return requestLanguage;
    }
}
