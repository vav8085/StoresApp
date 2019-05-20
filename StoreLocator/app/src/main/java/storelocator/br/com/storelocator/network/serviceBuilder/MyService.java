package storelocator.br.com.storelocator.network.serviceBuilder;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import storelocator.br.com.storelocator.MyApplication;

/**
 * Common class for all network calls, called from datasources
 */
public class MyService implements MyServiceContract {
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private MyResponse myResponse;
    private Gson gson;

    /**
     * String request
     * @param repoData
     */
    @Override
    public void callStringService(final RepoData repoData) {
        StringRequest request = new StringRequest(repoData.getRequestType(), repoData.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting().serializeNulls();
                gson = builder.create();
                myResponse = (MyResponse) gson.fromJson(response, repoData.getResponseClass());
                repoData.getNetworkObserver().onSuccess(myResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    repoData.getNetworkObserver().onFailure(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(repoData.getHeader().isEmpty() || repoData.getHeader() == null){
                    return super.getHeaders();
                }
                return repoData.getHeader();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(repoData.getFormData().isEmpty() || repoData.getFormData() == null){
                    return super.getParams();
                }
                return repoData.getFormData();
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
    }

    /**
     * Json request
     * @param repoData
     * @throws JSONException
     */
    @Override
    public void callJsonService(final RepoData repoData) throws JSONException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        gson = builder.create();
        JSONObject jsonObject = new JSONObject(gson.toJson(repoData.getAlignRequest()));
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(repoData.getRequestType(), repoData.getUrl(), jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                myResponse = (MyResponse) gson.fromJson(response.toString(), repoData.getResponseClass());
                repoData.getNetworkObserver().onSuccess(myResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                repoData.getNetworkObserver().onFailure(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(repoData.getHeader().isEmpty() || repoData.getHeader() == null){
                    return super.getHeaders();
                }
                return repoData.getHeader();
            }
        };
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    /**
     * Customized to upload photos
     * @param repoData
     */
    @Override
    public void callStreamDataService(final RepoData repoData) {
        StringRequest request = new StringRequest(repoData.getRequestType(), repoData.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting().serializeNulls();
                gson = builder.create();
                MyResponse myResponse = (MyResponse) gson.fromJson(response, repoData.getResponseClass());
                repoData.getNetworkObserver().onSuccess(myResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                repoData.getNetworkObserver().onFailure(error);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return APPLICATION_OCTET_STREAM;
            }

            @Override
            public byte[] getBody() {
                return repoData.getStreamData();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(repoData.getHeader().isEmpty() || repoData.getHeader() == null){
                    return super.getHeaders();
                }
                return repoData.getHeader();
            }
        };
        MyApplication.getInstance().addToRequestQueue(request);
    }
}
