package info.androidhive.firebase.test;

import android.content.Context;

import static junit.framework.Assert.assertEquals;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Tania on 28/05/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void test_use_AppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("info.androidhive.firebase.test", appContext.getPackageName());
    }
}
