package tk.reinaldorauch.collectorapp.datasources;

import android.arch.lifecycle.LiveData;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.entity.Collection;

/**
 * Interface para datasources de collection
 * Created by Reinaldo on 18/02/2018.
 */

public interface CollectionDataSource {
    LiveData<List<Collection>> getList();
    void add(Collection c);
}
