package cern.rade.services.common.communication;

import cern.rade.services.common.containers.java.DataContainer;

public class Request {
    private MetaData metaData;
    private RequestAction requestAction;
    private RequestLanguage requestLanguage;
    private AuthenticationType authenticationType;
    private int id;

    public Request(MetaData metaData)
    {
        this.metaData = metaData;
        this.requestAction =metaData.getRequest_action();
        this.requestLanguage = metaData.getRequest_language();
        this.authenticationType = metaData.getAuth_type();
        this.id = createID();
    }

    public String toString(){
        String url;
        if(metaData.getReq_url()==null){
            url = "device";
        }
        else{
            url= metaData.getReq_url();
        }

        return String.format("[id: %d | user: %s | action: %s | language: %s | authentication: %s | url: %s | selector: %s]",
                id, metaData.getUsername(), metaData.getRequest_action().getName(), metaData.getRequest_language().getName(),
                metaData.getAuth_type().getName(), url, metaData.getSelector());
    }
    private int createID(){
        return this.hashCode();
    }
    public MetaData getMetaData() {
        return metaData;
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
