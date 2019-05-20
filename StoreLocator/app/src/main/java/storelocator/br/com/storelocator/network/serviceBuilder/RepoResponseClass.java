package storelocator.br.com.storelocator.network.serviceBuilder;

public final class RepoResponseClass {

    RepoData repoData;
    protected RepoResponseClass(RepoData repoData){
        this.repoData = repoData;
    }
    public RepoReqType setMyResponseClass(Class responseClass){
        repoData.setResponseClass(responseClass);
        return new RepoReqType(repoData);
    }

}
