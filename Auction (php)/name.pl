#!/usr/bin/perl
# file:name.pl
# Function: Accept the user name and put it into cookie
# Author: Cheng Wai Hung (3)

use CGI ':standard';

# recover the "username" cookie.
%username = cookie('username');

# If the user wants to change the password,
# they will appear among our CGI parameters.
foreach ('fname','lname') {
   $username{$_}=param($_) || $username{$_};   	
}

# Refresh the cookie so that it doesn't expire.  This also
# makes any changes the user made permanent.
$cookie1 = cookie(-name=>'username',
		     -value=>\%username,
		     -expires=>'+30d');		
print header(-cookie=>$cookie1);

# Create the HTML page.  We use several of Netscape's
# extended tags It's safe to use Netscape features here because
# cookies don't work anywhere else anyway.
print start_html('Name Page'),
     h1('WellCome !'),
     start_form,
       "First Name",br,textfield('fname'),br,
       "Last Name",br,textfield('lname'),br, 	 	
       submit(-label=>'Submit'),
     end_form;
print end_html;