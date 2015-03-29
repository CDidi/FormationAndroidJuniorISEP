package android.junior.formation.fr.formationjuniorisep;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstFormation extends ActionBarActivity {


    private TextView myTv;
    private EditText myEdit;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_formation);

        myTv = (TextView) findViewById(R.id.tv_first_formation);
        myEdit = (EditText) findViewById(R.id.edit_first_formation);
        myButton = (Button) findViewById(R.id.button_first_formation);

        myButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentText = myEdit.getText().toString();

                myTv.setText( currentText );

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_formation, menu);
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
