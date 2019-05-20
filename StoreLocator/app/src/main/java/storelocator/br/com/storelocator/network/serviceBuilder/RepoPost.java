package storelocator.br.com.storelocator.network.serviceBuilder;

import java.util.Map;

public final class RepoPost {
    private RepoData repoData;

    protected RepoPost(RepoData repoData){
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
    public RepoStreamDataPostCall setOctetStream(byte[] bytes){
        repoData.setStreamData(bytes);
        return new RepoStreamDataPostCall(repoData);
    }

}
