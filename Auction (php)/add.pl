#!/usr/bin/perl
# script: add.pl
# Function: Accept the user's address and put it into cookie
# Author: Tam Koon Wing

use CGI ':standard';

# recover the "add" cookie.
%address = cookie('add');

# If the user wants to change the password,
# they will appear among our CGI parameters.
foreach ('address') {
   $address{$_}=param($_) || $address{$_};   	
}

# Refresh the cookie so that it doesn't expire.  This also
# makes any changes the user made permanent.
$cookie1 = cookie(-name=>'add',
		     -value=>\%address,
		     -expires=>'+30d');
print header(-cookie=>$cookie1);


# Create the HTML page.  We use several of Netscape's
# extended tags It's safe to use Netscape features here because
# cookies don't work anywhere else anyway.
print start_html('Address Page'),
     h1('WellCome !'),
     start_form,
	"Address:",br,
	textarea(-name=>'address',-rows=>6,
                      -columns=>50,
                      -wrap=>1),
	p(),
	reset(-name=>'Reset'),
	submit(-name=>'Submit'),
     end_form;
print end_html;

