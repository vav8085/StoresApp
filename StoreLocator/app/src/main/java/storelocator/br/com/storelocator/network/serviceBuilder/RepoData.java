package storelocator.br.com.storelocator.network.serviceBuilder;

import android.content.Context;

import java.util.Map;

public final class RepoData<T> {

    private Context context;
    private Map<String, String> header;
    private Map<String, String> formData;
    private String url;
    private Class responseClass;
    private int requestType;
    private MyRequest alignRequest;
    private byte[] streamData;
    private NetworkObserver<T> networkObserver;

    protected RepoData(){}

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, String> getFormData() {
        return formData;
    }

    public void setFormData(Map<String, String> formData) {
        this.formData = formData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class responseClass) {
        this.responseClass = responseClass;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public MyRequest getAlignRequest() {
        return alignRequest;
    }
    public void setAlignRequest(MyRequest alignRequest) {
        this.alignRequest = alignRequest;
    }

    public byte[] getStreamData() {
        return streamData;
    }

    public void setStreamData(byte[] streamData) {
        this.streamData = streamData;
    }

    public NetworkObserver<T> getNetworkObserver() {
        return networkObserver;
    }

    public void setNetworkObserver(NetworkObserver<T> networkObserver) {
        this.networkObserver = networkObserver;
    }
}
