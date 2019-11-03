package com.example.moviefilem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviefilem.DataBase.AdapterRecylerView;
import com.example.moviefilem.DataBase.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    ArrayList<Movie> list;
    RecyclerView recyclerView;
    AdapterRecylerView adapter;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Insilzie();
        MyVolly();

    }

    public void MyVolly() {
        queue = Volley.newRequestQueue(this);
        String url = "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesData.txt?fbclid=IwAR1z6xW4wuwbvKaflTeM0cTeup3UYTR19GvUT0Hsl-x4mxJCE40rwhPd_6I";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray array = response.getJSONArray("movies");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                String image = object.getString("image");
                                Log.d("QQQQQQ", "onResponse: "+object.getString("image"));
                                String movie = object.getString("movie");
                                String story = object.getString("story");
                                int year = object.getInt("year");
                                Log.d("AAAAA", "onResponse: " + object.getInt("year"));
                                Double rating = object.getDouble("rating");
                                String duration = object.getString("duration");
                                String director = object.getString("director");
                                String tagline = object.getString("tagline");
                                Log.d("SSSSSS", "onResponse: " + object.getString("tagline"));
                                JSONArray js = object.getJSONArray("cast");
                                String cast = "";
                                for (int s = 0;  s< js.length(); s++) {
                                    cast +=js.getString(s)+",  ";
                                }
                                Movie movie1 = new Movie();
                                movie1.setImage(image);
                                movie1.setStory(story);
                                movie1.setTagline(tagline);
                                movie1.setDirocter(director);
                                movie1.setDuration(duration);
                                movie1.setYear(year);
                                movie1.setMovie(movie);
                                movie1.setReating(rating);
                                list.add(movie1);
                                adapter.notifyDataSetChanged();
                                bar.setVisibility(View.GONE);

                            }

                        } catch (JSONException e) {
                            Log.d("WWWWWW", "onResponse: " + e.getMessage());
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Check your internet", Toast.LENGTH_SHORT).show();
            }

        });

        queue.add(request);
    }

    public void Insilzie() {
        bar = findViewById(R.id.bar);
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        adapter = new AdapterRecylerView(this, list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }
}
