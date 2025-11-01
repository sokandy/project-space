#!/usr/bin/perl
# file side.pl
# Function: Main page created by frameset, left frame is function menu
# right frame is function page. you can select the any function in the
# left frame at any time.
# Author : Cheng Wai Hung (3)

use CGI qw/:standard :netscape/;
print header;

$frame_name = path_info();
$frame_name =~ s!^/!!;

# If no path information is provided, then we create 
# a side-by-side frame set
if (!$frame_name) {
    print_frameset();
    exit 0;
}

# If we get here, then we either create the query form
# or we create the response.
print start_html();
print_menu()    if $frame_name eq 'left';
print_response() if $frame_name eq 'right';
print end_html();

# Create the frameset
sub print_frameset {
    my $script = "http://localhost/cgi-bin/side.pl";
    print title('SNP Assignment'),
    frameset({-rows=>'20%,80%'},
   	     frame({-name=>'top'}),
	     frameset({-cols=>'20%,80%'},
	     	      frame({-name=>'left',-src=>"$script/left"}),
	              frame({-name=>'right',-src=>"$script/right"}),
	     ));
    exit 0;
}

sub print_menu {
    my $script = "http://localhost/cgi-bin/side.pl";
    print h1("Function Select"),
        start_html(-action=>"$script/right",
                  -target=>"right"),br,br,
	a({-href=>'http://localhost/cgi-bin/name.pl'},"Name"),br,br,
	a({-href=>'http://localhost/cgi-bin/age.pl'},"Age and Sex"),br,br,
	a({-href=>'http://localhost/cgi-bin/add.pl'},"Address"),br,br,
	a({-href=>'http://localhost/cgi-bin/pass.pl'},"Password"),br,br,
        a({-href=>'http://localhost/cgi-bin/rew.pl'},"Review Record"),

	end_html;
	
}

sub print_response {
   print h1("SNP Assignment Part 2 of 2"),br,br,
	 h1("Name: Cheng Wai Hung & Tam Koon Wing");
}
