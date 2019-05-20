package storelocator.br.com.storelocator.network.serviceBuilder;

import com.android.volley.Request;

public final class RepoReqType{
    RepoData repoData;

    protected RepoReqType(RepoData repoData){
        this.repoData = repoData;
    }

    public RepoGetCall setRequestTypeGET(){

        repoData.setRequestType(Request.Method.GET);
        return new RepoGetCall(repoData);
    }
    public RepoPost setRequestTypePOST(){
        repoData.setRequestType(Request.Method.POST);
        return new RepoPost(repoData);
    }
    public RepoPut setRequestTypePUT(){
        repoData.setRequestType(Request.Method.PUT);
        return new RepoPut(repoData);
    }
}
