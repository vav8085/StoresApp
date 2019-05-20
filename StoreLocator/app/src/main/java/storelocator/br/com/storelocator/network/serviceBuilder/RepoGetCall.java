package storelocator.br.com.storelocator.network.serviceBuilder;

public final class RepoGetCall implements Call{

    RepoData repoData;
    MyService alignService;

    protected RepoGetCall(RepoData repoData){
        this.repoData = repoData;
    }

    public Call callService(){
        alignService = new MyService();
        alignService.callStringService(repoData);
        return this;
    }


}
