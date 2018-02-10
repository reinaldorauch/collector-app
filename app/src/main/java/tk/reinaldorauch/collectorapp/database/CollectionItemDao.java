package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Reinaldo on 10/02/2018.
 */

@Dao
public interface CollectionItemDao {
    @Query("SELECT * FROM collection_item WHERE collection_id = :collectionId")
    List<CollectionItem> getAllFromCollection(int collectionId);

    @Query("SELECT COUNT(*) FROM collection_item WHERE collection_id = :collectionId")
    int getItemCountInCollection(int collectionId);
}
