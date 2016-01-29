package com.natateam.materialplays;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ThingListFragment extends android.support.v4.app.Fragment {
    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    ThingRecyclerAdapter recyclerAdapter;

    public ThingListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thing_list, container, false);
        ButterKnife.inject(this, rootView);
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        recyclerAdapter = new ThingRecyclerAdapter();
        recyclerAdapter.updateList(getThings());
        recyclerAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<Thing>() {
            @Override
            public void onItemClick(View view, Thing item, boolean isLongClick) {
                //startDescription(view);
                ((MainActivity)getActivity()).toSecondFragment(view);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);


    }

    public void startDescription(View view){
        Intent intent = new Intent(getActivity(), DescActivity.class);
// Pass data object in the bundle and populate details activity.
        //intent.putExtra(DetailsActivity.EXTRA_CONTACT, contact);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), (View) view.findViewById(R.id.ivProfile), "profile");
        getActivity().startActivity(intent, options.toBundle());
    }



    public static List<Thing> getThings() {
        ArrayList<Thing> list = new ArrayList<>();
        for (int l = 0; l < 100; l++) {
            list.add(new Thing("Thing "+l, null));
        }
        return list;
    }

}

