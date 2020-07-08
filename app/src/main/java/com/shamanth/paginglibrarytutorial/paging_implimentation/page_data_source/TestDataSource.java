package com.shamanth.paginglibrarytutorial.paging_implimentation.page_data_source;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.google.gson.Gson;

import com.shamanth.paginglibrarytutorial.paging_implimentation.model.DataModel;

/**
 * data source to call api and to implementing PAging
 */

public class TestDataSource extends PageKeyedDataSource<Integer, DataModel> {
    private final Gson gson = new Gson();
    public static final int PAGE_SIZE = 5;
    private static final int FIRST_PAGE = 1;

    public TestDataSource(){

    }

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, DataModel> callback) {
        callApi(callback,null,1);
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, DataModel> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, DataModel> callback) {
        callApi(null,callback,params.key);
    }



    private void callApi(LoadInitialCallback<Integer, DataModel> initialCallback,
                         LoadCallback<Integer, DataModel> afterCallback, int page){
        //TODO set data for callbacks
        /**
         * if inital call
         */
        initialCallback.onResult(null,//add data here
                null,
                page+1 //increment page to next count
                );

        /**
         * if next call
         */
        afterCallback.onResult(null,//add data here
                page+1 //increment page to next count
        );

    }
}
