package logonBean;


import logonBean.*;
import java.util.ResourceBundle;


public class StepOne extends ValidationClass
{
    //protected variables:
    protected String firstName = EMPTY_STRING;
    protected String lastName = EMPTY_STRING;
    protected String emailAddress = EMPTY_STRING;
    protected String userID = EMPTY_STRING;

    //this bundle is where the error reports are stored:
    protected ResourceBundle bundle = ResourceBundle.getBundle("logonBean.StepOneErrorReports");

    //extend the process method as provided by the super class:
    public boolean process()
    {
        //has a first/last name been entered:
        if(firstName == null || firstName.trim().length() == 0)
        {
            //use the hash table to look up the errors:
            errors.put("firstName", getLocalMessage("INVALID_FIRST_NAME"));
        }

        if(lastName == null || lastName.trim().length() == 0)
        {
            errors.put("lastName", getLocalMessage("INVALID_LAST_NAME"));
        }

        //does the email appear to be valid:
        if(emailAddress == null || emailAddress.trim().length() == 0 || emailAddress.indexOf("@") == -1)
        {
            errors.put("email", getLocalMessage("INVALID_EMAIL"));
        }

        //is the username is valid:
        if(userID == null || userID.trim().length() == 0)
        {
            errors.put("userID", getLocalMessage("INVALID_USER_ID"));
        }

        //if all the details are valid, check that the username doesn't already
        //exist:
        else
        {
            try
            {
                ParseUsersXML parser = new ParseUsersXML();
                if(parser.isAMember(userID))
                {
                    errors.put("userID", "Sorry, that username already exists, please choose another");
                }
            } //end try

            catch (ParseUsersFileException err)
            {
            }
        } //end else

        //any errors:
        return errors.isEmpty();

    } //end process()

    /*=========================================================================
      Methods: getter and setter methods
      Below is a list of required getter and setter methods so that external
      classes can access protected data:
    =========================================================================*/

    protected String getLocalMessage(String theKey)
    {
        return bundle.getString(theKey);
    }

    public String getEmail()
    {
        return emailAddress;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setEmail(String newEmail)
    {
        emailAddress = newEmail;
    }

    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    public void setUserId(String newUserID)
    {
        userID = newUserID;
    }

}//end class StepOne