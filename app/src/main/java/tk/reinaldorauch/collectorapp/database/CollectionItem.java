package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Reinaldo on 10/02/2018.
 */

@Entity(tableName = "collection_item",
        foreignKeys = @ForeignKey(entity = Collection.class,
                                  parentColumns = "id",
                                  childColumns = "collection_id"))
public class CollectionItem {
    @PrimaryKey
    public int id;

    public String description;
    public int order;

    @ColumnInfo(name = "collection_id")
    public int collectionId;
}
