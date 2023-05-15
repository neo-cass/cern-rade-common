package cern.rade.services.common.communication.client;

import cern.rade.services.common.containers.java.DataContainer;

public class Request {
    private MetaData metaData;
    private DataContainer<?> data;
    private RequestAction requestAction;
    private RequestLanguage requestLanguage;
    private int id;

    public Request(MetaData metaData, DataContainer<?> data, String requestAction, String requestLanguage)
    {
        this.metaData = metaData;
        this.data = data;
        this.requestAction = RequestAction.valueOf(requestAction);
        this.requestLanguage = RequestLanguage.valueOf(requestLanguage);
        this.id = createID();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("meta data: ");
        stringBuilder.append(metaData);
        stringBuilder.append("\n");

        stringBuilder.append("data: ");
        stringBuilder.append(data);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    private int createID(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(metaData.getUsername()).append("/");
        stringBuilder.append(metaData.getDevice()).append("/");
        stringBuilder.append(metaData.getProperty()).append("/");
        stringBuilder.append(metaData.getRequest_action()).append("/");
        stringBuilder.append(metaData.getRequest_language()).append("/");
        stringBuilder.append(metaData.getSelector());
        return stringBuilder.toString().hashCode();
    }
    public MetaData getMetaData() {
        return metaData;
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
