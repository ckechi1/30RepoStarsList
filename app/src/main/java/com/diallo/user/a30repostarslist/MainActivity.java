package com.diallo.user.a30repostarslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<RepoModel> mylistRepo  ;
    private RepoModel RepoModel;
    private RecyclerView.LayoutManager myLayoutManager;
    private RecyclerView myRecyclerveiw;
    private RcCvAdapter RcCvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerveiw = findViewById(R.id.repoRecycler_view);

        GithubApi.getInstance().initialize(getApplicationContext());

        mylistRepo = new ArrayList<>();
        RcCvAdapter = new RcCvAdapter(this, mylistRepo);
        myLayoutManager = new  LinearLayoutManager(this);
        myRecyclerveiw.setLayoutManager(myLayoutManager);
        myRecyclerveiw.setAdapter(RcCvAdapter);

        GithubApi.getInstance().get30StarsGithubRepositories(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    Log.d("json ma reponse ", response.toString());

                    JSONArray jsonArray = response.getJSONArray("items"); // inside items

                    for (int i = 0; i < 10; i++) {

                        RepoModel = new RepoModel();

                        JSONObject obj = jsonArray.getJSONObject(i);
                        String name = obj.getString("name");
                        String description = obj.getString("description");
                        int Stars = obj.getInt("stargazers_count");

                        JSONObject owner = (JSONObject) obj.get("owner");  // inside object owner
                        String ownerName = owner.getString("login");
                        String photo = owner.getString("avatar_url");

                        RepoModel.setRepoName(name);
                        RepoModel.setRepoDescription(description);
                        RepoModel.setRepoStars(Stars);
                        RepoModel.setOwnerUsername(ownerName);
                        RepoModel.setOwnerPhoto(photo);

                        mylistRepo.add(RepoModel);
                     }

                myRecyclerveiw.getAdapter().notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d( "mon erreur: " + error.getMessage());
                error.printStackTrace();
            }
        });

    }
}