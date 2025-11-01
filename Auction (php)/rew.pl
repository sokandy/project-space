#!/usr/bin/perl
# file rew.pl
# Function: Detect the user password for review the personal record
# Author: Tam Koon Wing

use CGI ':standard';

# recover all cookie.
%username = cookie('username');
%age = cookie('gax');
%address = cookie('add');
%pass = cookie('password');

# Create the HTML page.  We use several of Netscape's
# extended tags It's safe to use Netscape features here because
# cookies don't work anywhere else anyway.
print header,
    start_html('Reveiw Record Page'),
    h2('If you want view record, please enter the password first !'),	
    br,
    start_form,
       "Password",br,password_field('pass1'),br,
       submit(-label=>'Submit'),
    end_form;
    end_html;

if (param()){
	$p1=param('pass1');          #Detect the password true or false, if true, view record
	if ($pass{'pass1'}==$p1) {   #else print error message!
	        view_record();
	}
	else {
		print h3('Invalid Password. Enter Again');
	}
}

sub view_record {

print   "Your First name is $username{'fname'}",br,
    	"Your Last name is $username{'lname'}",br,
    	"Your age is $age{'age'}",br,
    	"Your sex is $age{'sex'}",br,
    	"Your address is $address{'address'}",br;
    			
}
