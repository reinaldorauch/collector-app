package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import tk.reinaldorauch.collectorapp.database.dao.CollectionDao;
import tk.reinaldorauch.collectorapp.database.dao.CollectionItemDao;
import tk.reinaldorauch.collectorapp.database.entity.Collection;
import tk.reinaldorauch.collectorapp.database.entity.CollectionItem;

/**
 *
 * Database descriptor class to be used to instantiate SQLite db acess
 *
 * Created by Reinaldo on 10/02/2018.
 */

@Database(entities = {Collection.class, CollectionItem.class}, version = 2)
public abstract class CollectorAppDatabase extends RoomDatabase {
    public abstract CollectionDao collectionDao();
    public abstract CollectionItemDao collectionItemDao();
}
