package android.junior.formation.fr.formationjuniorisep;

import android.app.Dialog;
import android.junior.formation.fr.formationjuniorisep.Model.Contact;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by floriantorel on 02/04/15.
 */
public class ThirdFormation extends ActionBarActivity implements View.OnClickListener
{

    private List<Contact> contacts = new ArrayList<>();

    private ListView listView;

    private ThirdFormationAdapter adapter;

    private Button button;

    private Dialog dialog;

    private EditText edFirstName;
    private EditText edLastName;
    private EditText edType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_formation);

        Contact contact1 = new Contact("Theo"       , "Dupon", 3);
        Contact contact2 = new Contact("Andre"      , "Dupuis",1);
        Contact contact3 = new Contact("Valentin"   , "Andro",2);
        Contact contact4 = new Contact("Charles"    , "Oder",4);

        /*
        Contact c = new Contact();
        c.setFirstName("Florian");
        c.setLastName("Torel");
        c.setType(5);
        c.plusOne();
        */

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);


        /*

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getFirstName().compareTo(c2.getFirstName());
            }
        });
        */

        button = (Button) findViewById(R.id.third_formation_button_add_contact);
        button.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.third_formation_listview);

        adapter = new ThirdFormationAdapter(contacts, getApplicationContext());

        listView.setAdapter(adapter);

    }


    private Dialog createCustomDialog()
    {
        final Dialog dialog = new Dialog(ThirdFormation.this);
        dialog.setContentView(R.layout.custom_dialog_third_formation);
        dialog.setTitle(getString(R.string.third_formation_dialog_title));

        Button but = (Button) dialog.findViewById(R.id.custom_dialog_third_formation_finish);
        but.setOnClickListener(this);

        edFirstName = (EditText) dialog.findViewById(R.id.custom_dialog_third_formation_ed_firstname);
        edLastName = (EditText) dialog.findViewById(R.id.custom_dialog_third_formation_last_name);
        edType = (EditText) dialog.findViewById(R.id.custom_dialog_third_formation_ed_type);

        return dialog;
    }

    @Override
    public void onClick(View v)
    {
        switch ( v.getId() )
        {
            case R.id.third_formation_button_add_contact:

                dialog = createCustomDialog();
                dialog.show();

                break;

            case R.id.custom_dialog_third_formation_finish:


                String firstName = edFirstName.getText().toString();
                String lastName = edLastName.getText().toString();
                int type = Integer.parseInt(edType.getText().toString());

                Contact contact = new Contact(firstName,lastName,type);

                dialog.dismiss();

                contacts.add(contact);
                adapter.updateList(contacts);

                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third_formation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_order_by_firstname)
        {

            Collections.sort(contacts, new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getFirstName().compareTo(c2.getFirstName());
                }
            });


            adapter.updateList(contacts);

            return true;
        }

        if (id == R.id.action_order_by_lastname)
        {
            Collections.sort(contacts , new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getLastName().compareTo(c2.getLastName());
                }
            });

            adapter.updateList(contacts);

            return true;
        }

        if (id == R.id.action_order_by_type)
        {
            Collections.sort(contacts , new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getType() - c2.getType() ;
                }
            });

            adapter.updateList(contacts);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
