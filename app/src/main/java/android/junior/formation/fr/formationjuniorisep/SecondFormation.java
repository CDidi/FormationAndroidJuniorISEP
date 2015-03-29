package android.junior.formation.fr.formationjuniorisep;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SecondFormation extends ActionBarActivity implements View.OnClickListener{

    private ListView myList;
    private ArrayAdapter myAdapter;
    private List<String> myValues = new ArrayList<>();

    private Button myButton;
    private EditText myEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_formation);

        init();


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.second_formation_button_add:

                String currentText = myEditText.getText().toString();
                myValues.add(currentText);
                myAdapter.notifyDataSetChanged();
                myEditText.setText("");

                break;
        }
    }

    private void init()
    {
        myAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                myValues
        );

        myList = (ListView) findViewById(R.id.second_formation_listview);
        myList.setAdapter(myAdapter);

        myButton = (Button) findViewById(R.id.second_formation_button_add);
        myButton.setOnClickListener(this);

        myEditText = (EditText) findViewById(R.id.second_formation_edit);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_formation, menu);
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
