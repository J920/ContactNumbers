package com.android.team920.contactnumbers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Search extends Fragment {

    TextView addButton;
    private List<Contact> numbersList;
    RecyclerView recyclerView;
    NewAdapter adapter;

    static boolean first;

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
    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            items.add("item " + i);
        }
        return items;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        first=false;

        addButton = view.findViewById(R.id.addButton);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                view.setBackgroundColor(R.drawable.add_on_click_effect);
            }
        });


        recyclerView = view.findViewById(R.id.num_rec);
        numbersList =new ArrayList<>();

        Contact contact = new Contact("STC","900");
        Contact contact1 = new Contact("موبايلkkkkkkkkkkkkkي","1100");
        Contact contact2 = new Contact("Zain","701");
        numbersList.add(contact);
        numbersList.add(contact1);
        numbersList.add(contact2);
        numbersList.add(contact);
        numbersList.add(contact1);
        numbersList.add(contact2);

//        adapter = new Adapter(this.getContext(), numbersList);
        adapter = new NewAdapter(this.getContext(),numbersList);

                LinearLayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setAdapter(oneHandCardAdapter);
        recyclerView.setAdapter(adapter);

//        GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {};
//
//        List<String> yourStringArray = dataSnapshot.getValue(t);



    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private int size;
        private boolean includeEdge;


        public GridSpacingItemDecoration(int spanCount, int spacing ,boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

               // if (position < spanCount) { // top edge
                    outRect.top = spacing;
                //}

                outRect.bottom = spacing; // item bottom


            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
               // if (position >= spanCount) {
                    outRect.top = spacing; // item top
                //}
            }

        }
    }


    //________________________________________________________




    //____________________________________________________


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
