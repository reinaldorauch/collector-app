package tk.reinaldorauch.collectorapp.database;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Created by Reinaldo on 10/02/2018.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseBuilderTest {
    CollectorAppDatabase one, two;
    public void setUp() {
        Context ctx = InstrumentationRegistry.getContext();
        one = DatabaseBuilder.create(ctx);
        two = DatabaseBuilder.create(ctx);
    }

    @Test
    public void testDatabaseSingleton() throws Exception {
        assertEquals(one, two);
    }

    public void tearDown() {
        one.close();
        one = two = null;
    }
}
