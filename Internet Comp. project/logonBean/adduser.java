package logonBean;

public class adduser extends ValidationClass
{
    //protected variables:
    protected String firstName = "";
    protected String lastName = "";
    protected String emailAddress = "";
    protected String userID = "";
    protected String passwordOne = "";
    protected String passwordTwo = "";
    protected String homePhoneNumber = "";
    

    public boolean process()
    {
        //has a first/last name been entered:
        if(firstName == null || firstName.trim().length() == 0)
        {
            //use the hash table to look up the errors:
            errors.put("firstName", "Please enter a valid first name");
        }

        if(lastName == null || lastName.trim().length() == 0)
        {
            errors.put("lastName", "Please enter a valid last name");
        }

        //does the email appear to be valid:
        if(emailAddress == null || emailAddress.trim().length() == 0 || emailAddress.indexOf("@") == -1)
        {
            errors.put("email", "Please enter a valid email address");
        }

        //is the username is valid:
        if(userID == null || userID.trim().length() == 0)
        {
            errors.put("userID", "Please enter a valid username");
        }

	if(passwordOne.length() < 8)
        {
            errors.put("passwordOne", "Password must be at least 8 characters");
        }

        //check the password has been entered:
        if(passwordOne == null || passwordOne.trim().length() == 0)
        {
            errors.put("passwordOne", "Please enter a valid password");
        }

        //ensure people don't use 'password' for a password
        if(passwordOne.equals("password"))
        {
            errors.put("passwordOne", "That password is too obvious, enter another");
        }


        //check the two passwords match:
        if(!passwordOne.equals(passwordTwo))
        {
            errors.put("passwordTwo", "Please ensure both passwords match");
        }
	
	
        if(homePhoneNumber != null)
        {
            if(!isDigit(homePhoneNumber))
              {
                  errors.put("homePhoneNumber", "The phone numbers must consist of all digits");
              }
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
    
    
    public boolean isDigit(String theNumber)
    {
        int j;
        char myArray[] = theNumber.toCharArray();

        for (j = 0; j < myArray.length; j++ )
        {
            if(!Character.isDigit(myArray[j]))
            {
                //not a digit:
                return false;
            }
        } //end for
        //it is a digit:
        return true;


    } //end isDigit()
    
    


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
    
    public String getPasswordOne()
    {
        return passwordOne;
    }

    public String getPasswordTwo()
    {
        return passwordTwo;
    }
    
    public String getHomePhoneNumber()
    {
        return homePhoneNumber;
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
    
    public void setPasswordOne(String newPasswordOne)
    {
        passwordOne = newPasswordOne;
    }

    public void setPasswordTwo(String newPasswordTwo)
    {
        passwordTwo = newPasswordTwo;
    }
    
    public void setHomePhoneNumber(String newHomePhoneNumber)
    {
        homePhoneNumber = newHomePhoneNumber;
    }

}//end class StepOne