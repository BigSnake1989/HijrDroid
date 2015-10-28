package id.co.hijr.app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import id.co.hijr.app.dao.UserDao;
import id.co.hijr.app.dao.UserDaoImpl;
import id.co.hijr.app.domain.Role;
import id.co.hijr.app.domain.User;
import id.co.hijr.app.service.ApplicationService;
import id.co.hijr.app.service.ApplicationServiceImpl;

public class MainActivity extends AppCompatActivity {

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

    MainActivity m_this;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_this = this;

        //begin init test data
        final ArrayList<HashMap<String, Object>> m_data = new ArrayList<HashMap<String, Object>>();


        ApplicationService appSvc = new ApplicationServiceImpl();
        User user = new User();
        user.setUsername("Epot");
        user.setName("Insert User");
        Role role = new Role();
        role.setName("manager");
        appSvc.createUser(user, role);

        UserDao userDao = new UserDaoImpl();
        List<User> lst =  userDao.list();
        for(User u: lst){
            Log.i("MainActivity", u.getUsername());
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("maintext", u.getUsername());
            map.put("subtext", u.getName());
            m_data.add(map);
        }

        for (HashMap<String, Object> m :m_data) //make data of this view should not be null (hide )
            m.put("checked", false);
        //end init data


        final ListView lv = (ListView) m_this.findViewById(R.id.lv1);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        final SimpleAdapter adapter = new SimpleAdapter(m_this,
                m_data,
                R.layout.list_single_check,
                new String[] {"maintext", "subtext", "checked"},
                new int[] {R.id.tv_MainText, R.id.tv_SubText, R.id.rb_Choice});

        adapter.setViewBinder(new SimpleAdapter.ViewBinder()
        {
            public boolean setViewValue(View view, Object data, String textRepresentation)
            {
                if (data == null) //if 2nd line text is null, its textview should be hidden
                {
                    view.setVisibility(View.GONE);
                    return true;
                }
                view.setVisibility(View.VISIBLE);
                return false;
            }

        });


        // Bind to our new adapter.
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
                RadioButton rb = (RadioButton) v.findViewById(R.id.rb_Choice);
                if (!rb.isChecked()) //OFF->ON
                {
                    for (HashMap<String, Object> m :m_data) //clean previous selected
                        m.put("checked", false);

                    m_data.get(arg2).put("checked", true);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        //show result
        ((Button)m_this.findViewById(R.id.Button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = -1;
                for (int i = 0; i < m_data.size(); i++) //clean previous selected
                {
                    HashMap<String, Object> m = m_data.get(i);
                    Boolean x = (Boolean) m.get("checked");
                    if (x == true)
                    {
                        r = i;
                        break; //break, since it's a single choice list
                    }
                }
                new AlertDialog.Builder(m_this).setMessage("you selected:" + r).show();
            }
        });

    }
}

