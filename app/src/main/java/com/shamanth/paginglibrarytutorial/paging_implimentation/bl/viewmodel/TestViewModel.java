package com.shamanth.paginglibrarytutorial.paging_implimentation.bl.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.shamanth.paginglibrarytutorial.paging_implimentation.model.DataModel;
import com.shamanth.paginglibrarytutorial.paging_implimentation.page_data_source.DataSourceFactory;
import com.shamanth.paginglibrarytutorial.paging_implimentation.page_data_source.TestDataSource;

public class TestViewModel extends ViewModel {
    public LiveData<PagedList<DataModel>> pagedList;
    private DataSourceFactory itemDataSourceFactory;

    public TestViewModel() {
        itemDataSourceFactory = new DataSourceFactory();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(true)
                        .setPageSize(TestDataSource.PAGE_SIZE).build();

        pagedList = new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig).build();
    }

    public void refresh() {
        if (itemDataSourceFactory == null)
            return;

        MutableLiveData<PageKeyedDataSource<Integer, DataModel>> pageKeyedDataSourceMutableLiveData
                = itemDataSourceFactory.getItemLiveDataSource();
        if (pageKeyedDataSourceMutableLiveData == null)
            return;

        PageKeyedDataSource<Integer, DataModel> dataSource = pageKeyedDataSourceMutableLiveData.getValue();

        if (dataSource == null)
            return;

        dataSource.invalidate();
    }
}
