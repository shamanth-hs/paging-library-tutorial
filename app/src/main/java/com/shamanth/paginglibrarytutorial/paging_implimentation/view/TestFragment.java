package com.shamanth.paginglibrarytutorial.paging_implimentation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.shamanth.paginglibrarytutorial.R;
import com.shamanth.paginglibrarytutorial.paging_implimentation.bl.viewmodel.TestViewModel;
import com.shamanth.paginglibrarytutorial.paging_implimentation.model.DataModel;


public class TestFragment extends Fragment {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    TestViewModel itemViewModel;
    TestAdapter adapter;
    TextView noDataMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        initView(view);
        setAdapter(view);
        setViewModel();
        return view;

    }

    private void initView(View view) {
        //TODO init all views
    }

    private void setAdapter(View view) {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                itemViewModel.refresh();
                noDataMessage.setVisibility(View.GONE);
            }
        } );

        adapter = new TestAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private void setViewModel(){
        itemViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        itemViewModel.pagedList.observe(getViewLifecycleOwner(), new Observer<PagedList<DataModel>>() {
            @Override
            public void onChanged(final PagedList<DataModel> liveLeadsData) {
                TestFragment.this.initViewWithData(liveLeadsData);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void initViewWithData(PagedList<DataModel> liveLeadsData){
        mRecyclerView.setVisibility(View.VISIBLE);
        adapter.submitList(liveLeadsData);
    }



    @Override
    public void onStart() {
        super.onStart();

    }


}
