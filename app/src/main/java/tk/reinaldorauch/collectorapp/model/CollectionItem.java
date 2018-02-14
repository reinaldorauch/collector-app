package tk.reinaldorauch.collectorapp.model;

/**
 *
 * CollectionItem é um item de uma coleção, e faz parte de uma Collection
 *
 * Created by Reinaldo on 14/02/2018.
 */

public interface CollectionItem {
    int getId();
    String getDescription();
    int getOrder();
    int getCollectionId();
}
