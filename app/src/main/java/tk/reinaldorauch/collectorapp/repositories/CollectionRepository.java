package tk.reinaldorauch.collectorapp.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.inject.Singleton;

import tk.reinaldorauch.collectorapp.AppExecutors;
import tk.reinaldorauch.collectorapp.datasources.CollectionDataSource;
import tk.reinaldorauch.collectorapp.database.entity.Collection;

/**
 * Controls access to collection data
 * Created by Reinaldo on 18/02/2018.
 */

@Singleton
public class CollectionRepository {
    private CollectionDataSource collectionDataSource;
    private AppExecutors executors;

    public CollectionRepository (AppExecutors executors, CollectionDataSource collectionDataSource) {
        this.collectionDataSource = collectionDataSource;
        this.executors = executors;
    }

    public LiveData<List<Collection>> getList() {
        Future<LiveData<List<Collection>>> res = executors.diskIO().submit(new Callable<LiveData<List<Collection>>>() {
            @Override
            public LiveData<List<Collection>> call() {
                return collectionDataSource.getList();
            }
        });
        try {
            return res.get();
        } catch (Exception e) {
            Log.d("empty collection list", e.getMessage(), e);
            return new MutableLiveData<>();
        }

    }
}
