package tk.reinaldorauch.collectorapp.database.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import tk.reinaldorauch.collectorapp.database.CollectorAppDatabase;
import tk.reinaldorauch.collectorapp.database.entity.Collection;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Tests CollectionDao
 *
 * Created by Reinaldo on 17/02/2018.
 */
@RunWith(AndroidJUnit4.class)
public class CollectionDaoTest {
    private Context ctx;
    private CollectorAppDatabase db;
    private CollectionDao dao;

    public CollectionDaoTest() {
        ctx = InstrumentationRegistry.getContext();
    }

    @Before
    public void createDatabase() {
        db = Room.inMemoryDatabaseBuilder(ctx, CollectorAppDatabase.class).build();
        dao = db.collectionDao();
    }

    @After
    public void destroyDatabase() {
        db.close();
        db = null;
        dao = null;
    }

    private void assertEqualCollections(Collection c1, Collection c2) {
        assertEquals(c1.getId(), c2.getId());
        assertEquals(c1.getName(), c2.getName());
    }

    @Test
    public void testGetAllCollections() throws Exception {
        Collection one = CollectionGenerator.generateCollection();
        Collection two = CollectionGenerator.generateCollection();

        dao.insertAll(one, two);

        List<Collection> collectionList = dao.getAll();

        Collection newOne = collectionList.get(0);
        Collection newTwo = collectionList.get(1);

        assertEqualCollections(one, newOne);
        assertEqualCollections(two, newTwo);
    }

    @Test
    public void testGetCollection() throws Exception {
        Collection c = CollectionGenerator.generateCollection();
        dao.insertAll(c);
        Collection dc = dao.getCollection(c.getId());

        assertEqualCollections(c, dc);
    }

    @Test
    public void testSearchCollection() throws Exception {
        Collection toSearch = CollectionGenerator.generateCollection();
        dao.insertAll(toSearch, CollectionGenerator.generateCollection());

        List<Collection> found = dao.searchByName(toSearch.getName());

        assertEquals(1, found.size());
        assertEqualCollections(toSearch, found.get(0));
    }

    @Test
    public void testUpdateCollection()  throws Exception {
        Collection c = new Collection(10, "FODAS");
        dao.insertAll(c);
        c.setName("CUS");
        dao.updateCollections(c);

        Collection f = dao.getCollection(c.getId());
        assertEqualCollections(c, f);
    }

    @Test(expected = AssertionFailedError.class)
    public void testDeleteCollections() throws Exception {
        dao.insertAll(CollectionGenerator.generateCollection(), CollectionGenerator.generateCollection());
        List<Collection> all = dao.getAll();
        assertEquals(2, all.size());
        Collection toBeRemoved = all.get(0);
        dao.delete(toBeRemoved);
        all = dao.getAll();
        assertEquals(1, all.size());
        assertEqualCollections(toBeRemoved, all.get(0));
    }

    public static class CollectionGenerator {
        private static int sequence = 1;
        static Collection generateCollection() {
            int id = sequence++;
            return new Collection(id, "Collection" + id);
        }
    }
}
