#!/usr/bin/perl
# file: pass.pl
# Function: Request the user entry two time password to make the password cookie
# Author: Cheng Wai Hung (3)

use CGI ':standard';

# recover the "password" cookie.
%password = cookie('password');

# If the user wants to change the password,
# they will appear among our CGI parameters.
foreach ('pass1','pass2') {
   $password{$_}=param($_) || $password{$_};   	
}

# Refresh the cookie so that it doesn't expire.  This also
# makes any changes the user made permanent.
$cookie1 = cookie(-name=>'password',
		     -value=>\%password,
		     -expires=>'+30d');				
print header(-cookie=>$cookie1);

# Create the HTML page.  We use several of Netscape's
# extended tags It's safe to use Netscape features here because
# cookies don't work anywhere else anyway.
print start_html('Password Page'),
    h1('WellCome !'),
     start_form,               # Create the form
       "Password",br,password_field(-name=>'pass1',-size=>8),br,
       "Re-enter",br,password_field(-name=>'pass2',-size=>8),br,
       submit(-label=>'Submit'),
     end_form;

if (param()){
	$p1=param('pass1');
	$p2=param('pass2');
	if ($p1==$p2) {                      # verify password, if true, set the password into cookie
		foreach ('pass1','pass2') {
   			$password{$_}=param($_);   	
		}
	
	print h2('Processing Complete !');
	} else {                             # if false, print the error message
		print h2('Invaild Password. Try Again');
}
}
print end_html;