package id.co.hijr.app.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by RefitD on 10/27/2015.
 */
public class MainApp extends Application{

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MainApp.context = getApplicationContext();
        copyDataBase("hipos.db");
    }

    private static void copyDataBase(String dbname)
    {
        Log.i("Database", "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try
        {
            MainApp.getAppContext().openOrCreateDatabase(dbname, MODE_PRIVATE, null);
            myInput = MainApp.getAppContext().getAssets().open(dbname);
            // transfer bytes from the inputfile to the
            // outputfile
            String dbfile = "/data/data/"+ MainApp.getAppContext().getPackageName()+"/databases/"+ dbname;
            Log.i("Database",dbfile);
            myOutput =new FileOutputStream(dbfile);
            while((length = myInput.read(buffer)) > 0)
            {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            Log.i("Database","New database has been copied to device!");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Context getAppContext() {
        return MainApp.context;
    }
}