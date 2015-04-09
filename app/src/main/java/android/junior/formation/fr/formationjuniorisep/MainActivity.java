package android.junior.formation.fr.formationjuniorisep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{


    private ListView myListView;
    private ArrayAdapter<String> myAdapter;
    private List<String> myValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myValues = new ArrayList<>();
        myValues.add(getString( R.string.first_formation) );
        myValues.add(getString( R.string.second_formation) );
        myValues.add(getString(R.string.third_formation));

        myListView = (ListView) findViewById(R.id.myListView);

        myAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                myValues
        );

        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = null;

        switch (position)
        {
            case 0:

                intent = new Intent(this, FirstFormation.class);

                break;

            case 1:

                intent = new Intent(this, SecondFormation.class);

                break;

            case 2:

                intent = new Intent(this, ThirdFormation.class);

                break;

        }

        startActivity(intent);
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
