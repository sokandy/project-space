package logonBean;



public class selector 
{
    //protected variables:
    protected String title = "";
    protected String subselect = "";
    protected String section = "";
    protected String body = "";    
    protected String prio="";
    protected String day="";
    
    public String getTitle()
    {
        return title;
    }
    public String getDay()
    {
        return day;
    }
    public String getPrio()
    {
        return prio;
    }

    public String getSubselect()
    {
        return subselect;
    }

    public String getSection()
    {
        return section;
    }

    public String getBody()
    {
        return body;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void setSubselect(String newSubselect)
    {
        subselect = newSubselect;
    }

    public void setSection(String newSection)
    {
        section = newSection;
    }

    public void setBody(String newBody)
    {
        body = newBody;
    }
    
    public void setPrio(String newPrio)
    {
        prio = newPrio;
    }
    
    public void setDay(String newDay)
    {
        day = newDay;
    }
    
}