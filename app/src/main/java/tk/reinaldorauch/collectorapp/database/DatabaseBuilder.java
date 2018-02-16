package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 *
 * Classe singleton para manutenção de uma instância de base de dados SQLite
 *
 * Created by Reinaldo on 10/02/2018.
 */

public final class DatabaseBuilder {
    private static CollectorAppDatabase db = null;

    public synchronized static CollectorAppDatabase create(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context, CollectorAppDatabase.class, "collections").build();
        }

        return db;
    }
}
