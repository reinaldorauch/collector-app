package tk.reinaldorauch.collectorapp.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import tk.reinaldorauch.collectorapp.fragment.ListItem;

/**
 *
 * Entity based on Collection model interface to help persisting it to the database
 *
 * Created by Reinaldo on 10/02/2018.
 */

@Entity(indices = {@Index(value = { "id" }, unique = true)})
public class Collection implements tk.reinaldorauch.collectorapp.model.Collection, ListItem {
    @PrimaryKey
    private int id;

    private String name;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
