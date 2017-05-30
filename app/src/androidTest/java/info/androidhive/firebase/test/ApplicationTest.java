package info.androidhive.firebase.test;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

   public void test_esto_siempre_pasa(){
       assertTrue(5 > 1);
   }

    public void test_esto_nunca_pasa(){
        assertTrue(5 < 1);
    }

}