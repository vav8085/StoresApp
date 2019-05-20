package storelocator.br.com.storelocator.network.serviceBuilder;

import android.content.Context;

public final class Repo {
    private Repo(){}
    public static Repo newInstance(){
        return new Repo();
    }
    public RepoHeader setContext(Context context) {
        RepoData repoData = new RepoData();
        repoData.setContext(context);
        return new RepoHeader(repoData);
    }
}
