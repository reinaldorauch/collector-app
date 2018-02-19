package tk.reinaldorauch.collectorapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.entity.Collection;
import tk.reinaldorauch.collectorapp.repositories.CollectionRepository;
/**
 * Handles the list of collections to be showed on ListFragment
 * Created by Reinaldo on 18/02/2018.
 */

public class CollectionListViewModel extends ViewModel {
    private LiveData<List<Collection>> mCollectionList = null;

    public LiveData<List<Collection>> getList(@NonNull CollectionRepository repo) {
        if (mCollectionList == null) {
            mCollectionList = repo.getList();
        }
        return mCollectionList;
    }
}
