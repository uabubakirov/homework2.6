package com.example.homework26;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultOwner;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.Serializable;
import java.security.Key;


public class Fragment1 extends Fragment {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RecyclerAdapter(getContext());
    }


    Button btnAdd;
    RecyclerView rvTask;
    RecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        btnAdd =view.findViewById(R.id.btn_add);
        rvTask = view.findViewById(R.id.rv_recycle);

        rvTask.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("fragment2").replace(R.id.fragment_container,new Fragment2()).commit();
            }
        });
        Bundle arguments = getArguments();
        if(arguments != null) {
            String title = arguments.getString("title");
            String description = arguments.getString("description");
            TaskModel model = new TaskModel(title, description);
            adapter.addTask(model);
        }
        return view;

    }
}