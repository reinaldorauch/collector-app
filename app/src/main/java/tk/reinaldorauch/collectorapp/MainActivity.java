package tk.reinaldorauch.collectorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tk.reinaldorauch.collectorapp.datasources.LocalCollectionDataSource;
import tk.reinaldorauch.collectorapp.fragment.ItemFragment;
import tk.reinaldorauch.collectorapp.fragment.ListItem;
import tk.reinaldorauch.collectorapp.repositories.CollectionRepository;


public class MainActivity
        extends AppCompatActivity
        implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(ListItem item) {
        System.out.println("Interacted with a item");
    }

    public void addCollection(View view) {
        EditText e = findViewById(R.id.newCollectionName);
        String newCollectionName = e.getText().toString();
        CollectionRepository cr = new CollectionRepository(new AppExecutors(), LocalCollectionDataSource.getInstance(getApplicationContext()));
        cr.add(newCollectionName);
    }
}
