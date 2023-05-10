package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    String api = "17df344bb5344e7ea54bb3ddcf6e53de";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country= "in" ;
    private RecyclerView recyclerViewOfhealth ;
    private  String category = "health";



    @Nullable
    @Override // we can override the on create method
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.healthfragment, null);




        recyclerViewOfhealth = view.findViewById(R.id.recyclerViewOfHealth);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewOfhealth.setAdapter(adapter);

        findNews();


        return view;


    }

    private void findNews() {


        ApiUtilities.getApiInterface().getCategoryNews(country , category , 100 , api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });



    }

}

