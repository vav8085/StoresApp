package storelocator.br.com.storelocator.network.serviceBuilder;

import org.json.JSONException;

public interface MyServiceContract {
    /**
     * callStringService takes a requestUrl, a map object(If null then request will be sent as a GET), a NetworkListener and a Hashmap of headers.
     * @param repoData
     */
    public void callStringService(RepoData repoData);

    /**
     * callJsonService takes a requestUrl, a POJO for request body, a NetworkListener and a Hashmap of headers.
     * @param requestUrl
     * @param alignRequest
     * @param headerMap
     * @param alignResponseClass
     */
    public void callJsonService(RepoData repoData) throws JSONException;

    public void callStreamDataService(RepoData repoData);

}
