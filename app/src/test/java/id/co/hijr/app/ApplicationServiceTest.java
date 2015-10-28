package id.co.hijr.app;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import id.co.hijr.app.core.MainApp;

/**
 * Created by refitgustaroska on 10/28/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.JELLY_BEAN, manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class ApplicationServiceTest {
    private MainActivity activity;
    private MainApp app;

    // @Before => JUnit 4 annotation that specifies this method should run before each test is run
    // Useful to do setup for objects that are needed in the test
    @Before
    public void setup() {
        // Convenience method to run MainActivity through the Activity Lifecycle methods:
        // onCreate(...) => onStart() => onPostCreate(...) => onResume()
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testListView(){

    }
}
