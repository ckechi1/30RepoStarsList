package com.diallo.user.a30repostarslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.acl.Owner;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GithubApi.getInstance().initialize(getApplicationContext());

        GithubApi.getInstance().get30StarsGithubRepositories(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("items"); // inside items

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        String name = obj.getString("name");
                        int id = obj.getInt("id");
                        String description = obj.getString("description");


                        JSONObject owner = (JSONObject) obj.get("owner");  // enter object owner
                        String login = owner.getString("login");
                        String photo = owner.getString("avatar_url");


                        //  textView.append(name + ", " + String.valueOf(id) + ", " + description + "\n\n");
                        //textView.append(" login "+ login + "photo " + photo );

                     }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    }
}