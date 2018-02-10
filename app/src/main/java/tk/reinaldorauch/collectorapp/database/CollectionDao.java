package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Reinaldo on 10/02/2018.
 */

@Dao
public interface CollectionDao {
    @Query("SELECT * FROM collection")
    List<Collection> getAll();

    @Query("SELECT * FROM collection WHERE id = :id")
    Collection getCollection(int id);

    @Query("SELECT * FROM collection WHERE name LIKE :name")
    List<Collection> searchByName(String name);

    @Insert
    void insertAll(Collection... collections);

    @Update
    void updateCollections(Collection... collections);

    @Delete
    void delete(Collection collection);
}
