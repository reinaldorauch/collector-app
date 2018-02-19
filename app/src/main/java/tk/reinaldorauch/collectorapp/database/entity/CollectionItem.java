package tk.reinaldorauch.collectorapp.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import tk.reinaldorauch.collectorapp.fragment.ListItem;

/**
 *
 * Entity based on CollectionItem interface to help persisting it to the database
 *
 * Created by Reinaldo on 10/02/2018.
 */

@Entity(tableName = "collection_item",
        foreignKeys = @ForeignKey(entity = Collection.class,
                                  parentColumns = "id",
                                  childColumns = "collection_id"))
public class CollectionItem implements tk.reinaldorauch.collectorapp.model.CollectionItem, ListItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    private int order;

    @ColumnInfo(name = "collection_id")
    private int collectionId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getCollectionId() {
        return this.collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String toString() {
        return this.getOrder() + " - " + this.getDescription();
    }
}
