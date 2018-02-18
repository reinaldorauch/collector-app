package tk.reinaldorauch.collectorapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.CollectorAppDatabase;
import tk.reinaldorauch.collectorapp.fragment.ItemFragment;
import tk.reinaldorauch.collectorapp.fragment.ListItem;


public class MainActivity
        extends AppCompatActivity
        implements ItemFragment.OnListFragmentInteractionListener,
            ItemFragment.ListItemContentProviderActivity {

    private List<? extends ListItem> mCollectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context ctx = getApplicationContext();
        CollectorAppDatabase db = Room.databaseBuilder(ctx, CollectorAppDatabase.class, "collections").build();

        this.mCollectionList = db.collectionDao().getAll();
    }

    public List<? extends ListItem> getContent() {
        return this.mCollectionList;
    }

    @Override
    public void onListFragmentInteraction(ListItem item) {
        System.out.println("Interacted with a item");
    }
}
