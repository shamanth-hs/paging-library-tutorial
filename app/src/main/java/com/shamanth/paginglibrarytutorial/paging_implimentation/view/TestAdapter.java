package com.shamanth.paginglibrarytutorial.paging_implimentation.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shamanth.paginglibrarytutorial.paging_implimentation.model.DataModel;

import org.jetbrains.annotations.NotNull;

public class TestAdapter extends PagedListAdapter<DataModel, TestAdapter.MyViewHolder> {
    View mView;
    Activity mActivity;

    private static DiffUtil.ItemCallback<DataModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<DataModel>() {
                @Override
                public boolean areItemsTheSame(DataModel oldItem, DataModel newItem) {
                    return oldItem == newItem;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(DataModel oldItem, @NotNull DataModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

    TestAdapter(Activity activity){
        super(DIFF_CALLBACK);
        mActivity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        mView = LayoutInflater.from(parent.getContext()).inflate(null, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

    }




    static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view){
            //TODO init views
        }


    }
}
