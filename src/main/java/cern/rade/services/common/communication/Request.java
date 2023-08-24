package cern.rade.services.common.communication;

import cern.rade.services.common.containers.java.DataContainer;

public class Request {
    private MetaData metaData;
    private DataContainer data;
    private RequestAction requestAction;
    private RequestLanguage requestLanguage;
    private AuthenticationType authenticationType;
    private int id;

    public Request(MetaData metaData, DataContainer data)
    {
        this.metaData = metaData;
        this.data = data;
        this.requestAction =metaData.getRequest_action();
        this.requestLanguage = metaData.getRequest_language();
        this.authenticationType = metaData.getAuth_type();
        this.id = createID();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ID: ");
        stringBuilder.append(id);
        stringBuilder.append(" | ");

        stringBuilder.append("Data: ");
        stringBuilder.append(data);
        stringBuilder.append(" | ");

        stringBuilder.append("User: ");
        stringBuilder.append(metaData.getUsername());
        stringBuilder.append(" | ");

        stringBuilder.append("Action: ");
        stringBuilder.append(metaData.getRequest_action());
        stringBuilder.append(" | ");

        stringBuilder.append("Language: ");
        stringBuilder.append(metaData.getRequest_language());
        stringBuilder.append(" | ");

        stringBuilder.append("Device: ");
        stringBuilder.append(metaData.getDevice());
        stringBuilder.append(" | ");

        stringBuilder.append("URL: ");
        stringBuilder.append(metaData.getReq_url());
        stringBuilder.append(" | ");

        stringBuilder.append("Selector: ");
        stringBuilder.append(metaData.getSelector());
        stringBuilder.append(" | ");

        stringBuilder.append("Authentication: ");
        stringBuilder.append(metaData.getAuth_type());

        stringBuilder.append("]");



        return stringBuilder.toString();
    }
    private int createID(){
        return this.hashCode();
    }
    public MetaData getMetaData() {
        return metaData;
    }

    public DataContainer getData() {
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

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }
}
