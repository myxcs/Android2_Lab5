package com.example.android2_lab.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android2_lab.R;
import com.example.android2_lab.adapter.UserAdapter;
import com.example.android2_lab.dao.UserDAO;
import com.example.android2_lab.model.UserModel;

import java.util.ArrayList;


public class Display extends Fragment {
    private ArrayList<UserModel> listUser = new ArrayList<>();
    UserAdapter userAdapter;

    RecyclerView recyclerView;


    private UserDAO userDAO;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        recyclerView = view.findViewById(R.id.view_fragment);
        userDAO = new UserDAO(getActivity());
        listUser = userDAO.getAllUser();
        userAdapter = new UserAdapter(getActivity(), listUser);
        recyclerView.setAdapter(userAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}