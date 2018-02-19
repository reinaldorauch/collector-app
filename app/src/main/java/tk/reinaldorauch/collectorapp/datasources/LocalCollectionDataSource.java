package tk.reinaldorauch.collectorapp.datasources;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.CollectorAppDatabase;
import tk.reinaldorauch.collectorapp.database.dao.CollectionDao;
import tk.reinaldorauch.collectorapp.database.entity.Collection;

/**
 * Datasource para as coleções salvas localmente
 * Created by Reinaldo on 18/02/2018.
 */

public class LocalCollectionDataSource implements CollectionDataSource {
    private static volatile LocalCollectionDataSource INSTANCE;

    private CollectionDao dao;

    private LocalCollectionDataSource(CollectionDao dao) {
        this.dao = dao;
    }

    public static LocalCollectionDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LocalCollectionDataSource.class) {
                if (INSTANCE == null) {
                    CollectionDao dao = CollectorAppDatabase.getInstance(context).collectionDao();
                    INSTANCE = new LocalCollectionDataSource(dao);
                }
            }
        }

        return INSTANCE;
    }

    public LiveData<List<Collection>> getList() {
        return dao.getAll();
    }
}
