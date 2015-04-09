package android.junior.formation.fr.formationjuniorisep.Model;

/**
 * Created by floriantorel on 02/04/15.
 */
public class Contact
{

    private String firstName;
    private String lastName;
    private int type;


    //Constructor
    public Contact(String firstName, String lastName, int type)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public Contact() {
    }

    public void plusOne()
    {
        type  = type +  1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
