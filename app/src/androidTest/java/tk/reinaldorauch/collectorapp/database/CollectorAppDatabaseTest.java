package tk.reinaldorauch.collectorapp.database;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
/**
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
        assertTrue(db instanceof CollectorAppDatabase);
    }

    @Test
    public void testGetCollectionDao() throws Exception {
        assertNotNull(db);
        CollectionDao c = db.collectionDao();
        assertTrue(c instanceof CollectionDao);
    }

    @Test
    public void testGetCollectionItemDao() throws Exception {
        assertNotNull(db);
        CollectionItemDao c = db.collectionItemDao();
        assertTrue(c instanceof CollectionItemDao);
    }

    @After
    public void closeAndDeleteDatabase() {
        db.close();
        db = null;
    }
}
