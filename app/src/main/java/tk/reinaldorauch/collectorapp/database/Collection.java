package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Reinaldo on 10/02/2018.
 */

@Entity(indices = {@Index(value = { "id" }, unique = true)})
public class Collection {
    @PrimaryKey
    public int id;

    public String name;
}
