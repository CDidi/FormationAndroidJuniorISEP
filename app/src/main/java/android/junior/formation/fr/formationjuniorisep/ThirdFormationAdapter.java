package android.junior.formation.fr.formationjuniorisep;

import android.content.Context;
import android.junior.formation.fr.formationjuniorisep.Model.Contact;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by floriantorel on 02/04/15.
 */
public class ThirdFormationAdapter extends BaseAdapter
{
    private List<Contact> contacts;

    private LayoutInflater inflater;



    public ThirdFormationAdapter(List<Contact> contacts, Context c)
    {
        this.contacts = contacts;


        inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    public void updateList(List<Contact> contacts)
    {
        this.contacts = contacts;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        ViewHolder holder = null;

        Contact contact = contacts.get(position);

        if ( v == null)
        {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.custom_item_third_formation, null);

            holder.tvFirstName = (TextView) v.findViewById(R.id.tv_firstname_custom_item);
            holder.tvLastName = (TextView) v.findViewById(R.id.tv_lastname_custom_item);

            v.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) v.getTag();


        }

        holder.tvFirstName.setText( contact.getFirstName() );
        holder.tvLastName.setText( contact.getLastName() );

        return v;
    }

    private static class ViewHolder
    {
        TextView tvFirstName;
        TextView tvLastName;

    }
}
