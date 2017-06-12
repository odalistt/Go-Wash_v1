package info.androidhive.firebase.test;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Tania on 30/05/2017.
 */

public class InternetConnectionTests extends TestCase {
    try {
        URL url = new URL("https://odalistt.github.io/Proyecto/");
        URLConnection connection = url.openConnection();

        if (connection.getContentLength() == -1){
            fail("Failed to verify connection");
        }
    }
    catch (IOException e) {
        fail("Failed to open a connection");
        e.printStackTrace();
    }
}
