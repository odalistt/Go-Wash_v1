package info.androidhive.firebase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.test.AndroidTestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import com.loopj.android.http.HttpGet;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test(expected = NullPointerException.class)
    public void nullStringTest() {
        String str = null;
        assertTrue(str.isEmpty());
    }

    public void testAdd() {
        // Preparar
        Set<Integer> s = new HashSet<>();
        // Actuar
        s.add(42);
        // Verificar
        assertEquals(1, s.size());
    }

    // Prueba para las conexiones de red
    /* public void testHttpGet() {
        HttpGet httpget = new HttpGet("https://github.com");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    // Prueba para los permisos de red
    public void testPermissionsACCESS_NETWORK_STATE_isInManifest() {
        PackageManager pm = this.getContext().getPackageManager();
        int res = pm.checkPermission("android.permission.ACCESS_NETWORK_STATE", "org.miaplicacion");
        assertEquals(res, PackageManager.PERMISSION_GRANTED );
    }

    // Prueba para los permisos de conexión a Internet
    public void testPermissionsACCESS_INTERNETA_STATE_isInManifest() {
        PackageManager pm = this.getContext().getPackageManager();
        int res = pm.checkPermission("android.permission.INTERNET", "org.miaplicacion");
        assertEquals(res, PackageManager.PERMISSION_GRANTED );
    }
    // Prueba para los permisos de GPS
    public void testPermissionsACCESS_GPS_STATE_isInManifest() {
        PackageManager pm = this.getContext().getPackageManager();
        int res = pm.checkPermission("android.permission.ACCESS_FINE_LOCATION", "org.miaplicacion");
        assertEquals(res, PackageManager.PERMISSION_GRANTED );
    }

    // Prueba para los permisos de almacenamiento
    public void testPermissionsACCESS_STORAGE_STATE_isInManifest() {
        PackageManager pm = this.getContext().getPackageManager();
        int res = pm.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "org.miaplicacion");
        assertEquals(res, PackageManager.PERMISSION_GRANTED );
    } */


}