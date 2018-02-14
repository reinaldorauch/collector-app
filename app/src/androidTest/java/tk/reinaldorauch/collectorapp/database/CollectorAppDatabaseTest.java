package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import tk.reinaldorauch.collectorapp.database.dao.CollectionDao;
import tk.reinaldorauch.collectorapp.database.dao.CollectionItemDao;

import static org.junit.Assert.*;
/**
 *
 * Testing the database access class
 *
 * Created by Reinaldo on 10/02/2018.
 */

@RunWith(AndroidJUnit4.class)
public class CollectorAppDatabaseTest {
    private CollectorAppDatabase db;

    @Before
    public void createDatabase() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), CollectorAppDatabase.class).build();
    }

    @Test
    public void testCreateDatabaseInstance() throws Exception {
        assertNotNull(db);
    }

    @Test
    public void testGetCollectionDao() throws Exception {
        assertNotNull(db);
        CollectionDao c = db.collectionDao();
        assertNotNull(c);
    }

    @Test
    public void testGetCollectionItemDao() throws Exception {
        assertNotNull(db);
        CollectionItemDao c = db.collectionItemDao();
        assertNotNull(c);
    }

    @After
    public void closeAndDeleteDatabase() {
        db.close();
        db = null;
    }
}
