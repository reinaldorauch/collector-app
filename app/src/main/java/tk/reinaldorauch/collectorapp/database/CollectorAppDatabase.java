package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

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
    private static CollectorAppDatabase INSTANCE = null;
    private static final Object sLock = new Object();

    public abstract CollectionDao collectionDao();
    public abstract CollectionItemDao collectionItemDao();

    public static CollectorAppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CollectorAppDatabase.class, "collections.db")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getInstance(context)
                                                    .collectionDao()
                                                    .insertAll(
                                                            new Collection(1, "TEST"),
                                                            new Collection(2, "TESTE2"),
                                                            new Collection(3, "TESTE3")
                                                    );
                                        }
                                    });
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
