package storelocator.br.com.storelocator.network.serviceBuilder;

public final class RepoStreamDataPostCall{
    private RepoData repoData;
    MyService alignService;
    protected RepoStreamDataPostCall(RepoData repoData) {
        this.repoData = repoData;
    }
    public void callService() {
        alignService = new MyService();
        alignService.callStreamDataService(repoData);
    }
}

