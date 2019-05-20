package storelocator.br.com.storelocator.network.serviceBuilder;

public final class RepoObserver<T> {
    RepoData repoData;
    protected RepoObserver(RepoData repoData){
        this.repoData = repoData;
    }
    public RepoUrl setObserver(NetworkObserver<T> networkObserver) {
        repoData.setNetworkObserver(networkObserver);
        return new RepoUrl(repoData);
    }

}
