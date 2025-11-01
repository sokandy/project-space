package logonBean;


public class ParseUsersFileException extends Exception
{
    private String theReason = new String();

    ParseUsersFileException(String theReason)
    {
        //this is the reason for the exception:
        this.theReason = theReason;
    }

    public String toString()
    {
        //overrride to toString method to output the reason:
        return theReason;
    }

}//end class ParseUsersFileException