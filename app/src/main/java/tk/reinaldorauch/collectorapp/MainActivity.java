package tk.reinaldorauch.collectorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tk.reinaldorauch.collectorapp.fragment.ItemFragment;
import tk.reinaldorauch.collectorapp.fragment.ListItem;


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
}
