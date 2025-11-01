#!/usr/bin/perl
# script: age.pl
# Function: Accept the user's age and sex, then put it into cookie
# Author: Tam Koon Wing
use CGI ':standard';

# recover the "gax" cookie.
%age = cookie('gax');

# If the user wants to change the password,
# they will appear among our CGI parameters.
foreach ('age','sex') {
   $age{$_}=param($_) || $age{$_};   	
}

# Refresh the cookie so that it doesn't expire.  This also
# makes any changes the user made permanent.
$cookie1 = cookie(-name=>'gax',
		     -value=>\%age,
		     -expires=>'+30d');				
print header(-cookie=>$cookie1);

# Create the HTML page.  We use several of Netscape's
# extended tags It's safe to use Netscape features here because
# cookies don't work anywhere else anyway.
print start_html('Age and Sex'),
     h1('WellCome !'),
     start_form,
	"Age:",br,textfield(-name=>'age',-size=>3),p(),
	"Sex:",br,
	radio_group(-name=>'sex',-values=>['Female','Male']),
	p(),
	reset(-name=>'Reset'),
	submit(-name=>'Submit'),
     end_form;
print end_html;

