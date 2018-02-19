package tk.reinaldorauch.collectorapp.database.migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

/**
 * Migration para a terceira versão do banco de dados
 * Created by Reinaldo on 18/02/2018.
 */

public class TwoToThreeMigration extends Migration {
    private int fromVersion;
    private int toVersion;

    public TwoToThreeMigration(int fromVersion, int toVersion) {
        super(fromVersion, toVersion);
        this.fromVersion = fromVersion;
        this.toVersion = toVersion;
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
        database.beginTransaction();
        database.execSQL("ALTER TABLE Collection MODIFY COLUMN id INTEGER NOT NULL");
    }
}
