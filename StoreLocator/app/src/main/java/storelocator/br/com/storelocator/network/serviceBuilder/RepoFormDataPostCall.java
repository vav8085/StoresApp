package storelocator.br.com.storelocator.network.serviceBuilder;

public final class RepoFormDataPostCall implements Call{
    RepoData repoData;
    MyService alignService;
    protected RepoFormDataPostCall(RepoData repoData) {
        this.repoData = repoData;
    }
    public Call callService(){
        alignService = new MyService();
        alignService.callStringService(repoData);
        return this;
    }

}
