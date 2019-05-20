package storelocator.br.com.storelocator.network.serviceBuilder;

import org.json.JSONException;

public final class RepoJsonDataPostCall implements Call {
    private RepoData repoData;
    MyService alignService;
    protected RepoJsonDataPostCall(RepoData repoData) {
        this.repoData = repoData;
    }
    public Call callService() throws JSONException {
        alignService = new MyService();
        alignService.callJsonService(repoData);
        return this;
    }
}
