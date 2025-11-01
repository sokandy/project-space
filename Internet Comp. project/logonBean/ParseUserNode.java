package logonBean;

import org.w3c.dom.*;


public class ParseUserNode
{
    //protected variables:
    protected String userID, userLevel, password;

    public ParseUserNode(Node userNode)
    {
        NamedNodeMap attribs = userNode.getAttributes();
        //get the attributes for the various elements:
        userID = attribs.getNamedItem("userID").getNodeValue();
        password = attribs.getNamedItem("pwd").getNodeValue();
    }

    
    /*=========================================================================
      Methods: getter and setter methods
      Below is a list of required getter and setter methods so that external
      classes can access protected data:
    =========================================================================*/
    
    public void setAlias(String newAlias)
    {
        this.userID = newAlias;
    }

    public String getAlias()
    {
        return userID;
    }

    public void setUserLevel(String newLevel)
    {
        this.userLevel = newLevel;
    }

    public String getLevel()
    {
        return userLevel;
    }

    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }

    public String getPassword()
    {
        return password;
    }

}//end class ParseUserNode