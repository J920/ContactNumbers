package com.android.team920.contactnumbers;

import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;


public class Search extends Fragment {

    TextView addButton;
    private List<String> numbersList;
    RecyclerView recyclerView;

    public Search() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        addButton = view.findViewById(R.id.addButton);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                view.setBackgroundColor(R.drawable.add_on_click_effect);
            }
        });


        recyclerView = view.findViewById(R.id.num_rec);
      //  numbersList =new  List();


    }
}
