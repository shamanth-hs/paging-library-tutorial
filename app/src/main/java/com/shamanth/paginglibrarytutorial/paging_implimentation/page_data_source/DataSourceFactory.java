package com.shamanth.paginglibrarytutorial.paging_implimentation.page_data_source;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.shamanth.paginglibrarytutorial.paging_implimentation.model.DataModel;

import org.jetbrains.annotations.NotNull;

/**
 * data source factory for creating data source

 */
public class DataSourceFactory extends DataSource.Factory {
    private MutableLiveData<PageKeyedDataSource<Integer, DataModel>> itemLiveDataSource = new MutableLiveData<>();

    @NotNull
    @Override
    public DataSource<Integer, DataModel> create() {
        TestDataSource testDataSource = new TestDataSource();
        itemLiveDataSource.postValue(testDataSource);
        return testDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, DataModel>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
