package logonBean;

import java.util.Hashtable;


public abstract class ValidationClass
{
    protected Hashtable errors = new Hashtable();

    public final static String EMPTY_STRING = "";

    public String getError(String theError)
    {
        String errorDetails = (String) errors.get(theError);
        if(errorDetails == null)
        {
            return EMPTY_STRING;
        }

        return errorDetails;
    } //end getError

    public abstract boolean process();

    //method to set the errors in the hash table:
    public void setError(String theName, String theValue)
    {
        errors.put(theName,theValue);
    }

}//end class ValidationClass