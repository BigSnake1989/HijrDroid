package id.co.hijr.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import id.co.hijr.app.dao.UserDao;
import id.co.hijr.app.dao.UserDaoImpl;
import id.co.hijr.app.domain.Role;
import id.co.hijr.app.domain.User;
import id.co.hijr.app.service.ApplicationService;
import id.co.hijr.app.service.ApplicationServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationService appSvc = new ApplicationServiceImpl();
        User user = new User();
        user.setUsername("Epot");
        Role role = new Role();
        role.setName("manager");
        appSvc.createUser(user, role);

        UserDao userDao = new UserDaoImpl();
        List<User> lst =  userDao.list();
        for(User u: lst){
            Log.i("MainActivity", u.getUsername());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
