package com.example.emilia.busqueda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends Fragment {


    View v;


    private RecyclerView myrecyclerView;
    private List<Contact> lstContact;


    public FragmentSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.search_fragment,container,false);
        myrecyclerView = v.findViewById(R.id.search_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);

        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact("Ytalo","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Pedro","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Loreso","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Pablo","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Juancho","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Franco","999123456",R.drawable.cpu));

    }
}
