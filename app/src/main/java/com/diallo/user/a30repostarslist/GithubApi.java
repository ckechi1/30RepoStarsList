package com.diallo.user.a30repostarslist;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by octavian on 1/29/17.
 */

public class GithubApi {

    private static GithubApi mInstance;
    private Context mContext;
    private RequestQueue mRequestQueue;
    public static final String URL = "https://api.github.com/search/repositories?q=created:>2019-03-22&sort=stars&order=desc";


    private GithubApi() {
    }

    public synchronized static GithubApi getInstance() {
        if (mInstance == null) {
            mInstance = new GithubApi();
        }
        return mInstance;
    }

    public void initialize(Context context) {
        deinitialize();
        mContext = context.getApplicationContext();
        mRequestQueue = Volley.newRequestQueue(mContext);
        mRequestQueue.start();
    }

    public void deinitialize() {
        if (mRequestQueue != null) {
            mRequestQueue.stop();
            mRequestQueue = null;
        }
    }

    private Context getContext() {
        return mContext;
    }

    private void sendRequest(Request request) {
        request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(request);
    }

    public void get30StarsGithubRepositories(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, successListener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/vnd.github.mercy-preview+json");
                return headers;
            }
        };
        sendRequest(request);
    }

}
