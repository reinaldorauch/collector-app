package tk.reinaldorauch.collectorapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.Collection;
import tk.reinaldorauch.collectorapp.database.CollectorAppDatabase;
import tk.reinaldorauch.collectorapp.database.DatabaseBuilder;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollectorAppDatabase db = DatabaseBuilder.create(getApplicationContext());

        List<Collection> collectionList = db.collectionDao().getAll();


    }
}
