package storelocator.br.com.storelocator.network.serviceBuilder;

import java.util.Map;

public final class RepoPut {
    private RepoData repoData;

    protected RepoPut(RepoData repoData){
        this.repoData = repoData;
    }

    public RepoFormDataPostCall setFormData(Map<String, String> formData){
        repoData.setFormData(formData);
        return new RepoFormDataPostCall(repoData);
    }
    public RepoJsonDataPostCall setJsonData(MyRequest request){
        repoData.setAlignRequest(request);
        return new RepoJsonDataPostCall(repoData);
    }
}
