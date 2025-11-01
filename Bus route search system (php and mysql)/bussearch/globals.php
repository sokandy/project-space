<?php


  // globals.php


  $hostname = "localhost";
  $username = "andy";
  $password = "sokandy";
  $dataname = "bussearch";

  $HTTP_HOST = "192.168.0.1";
  $DOCROOT = "~andy/bussearch";


  $temptab1 = "CREATE TEMPORARY TABLE IF NOT EXISTS diff1 (
         route_no char(5) NOT NULL default '',
         stop_no int(2) NOT NULL default '0',
         bound int(1) NOT NULL default '0',
         stop_area char(5) NOT NULL default '',
         stop_desc char(30) NOT NULL default '',
         stop_desc2 char(30) NOT NULL default '',
         PRIMARY KEY  (route_no,stop_no,bound)
         ) TYPE=MyISAM;";

  $temptab2 = "CREATE TEMPORARY TABLE IF NOT EXISTS diff2 (
  route_no char(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '0',
  stop_area char(5) NOT NULL default '',
  stop_desc char(30) NOT NULL default '',
  stop_desc2 char(30) NOT NULL default '',
  PRIMARY KEY  (route_no,stop_no,bound)
) TYPE=MyISAM;";

  $temptab3 = "CREATE TEMPORARY TABLE IF NOT EXISTS temp_diff (
  from_no varchar(5) NOT NULL default '',
  from_stop int(2) NOT NULL default '0',
  from_bound int(1) NOT NULL default '0',
  stop_area varchar(5) NOT NULL default '',
  to_no varchar(5) NOT NULL default '',
  to_stop int(2) NOT NULL default '0',
  to_bound int(1) NOT NULL default '0',
  stop_desc varchar(30) NOT NULL default '',
  stop_desc2 varchar(30) NOT NULL default '',
  PRIMARY KEY  (from_no,from_stop,to_no,to_stop,from_bound,to_bound)
) TYPE=MyISAM;";

  $temptab4 = "CREATE TEMPORARY TABLE IF NOT EXISTS temp_from (
  route_no char(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '0',
  stop_area char(5) NOT NULL default '',
  stop_desc char(30) NOT NULL default '',
  air_fare decimal(4,2) default NULL,
  non_fare decimal(4,2) default NULL,
  stop_desc2 char(30) NOT NULL default '',
  PRIMARY KEY  (route_no,stop_no,bound)
) TYPE=MyISAM;";

  $temptab5 = "CREATE TEMPORARY TABLE IF NOT EXISTS temp_to (
  route_no char(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '0',
  stop_area char(5) NOT NULL default '',
  stop_desc char(30) NOT NULL default '',
  air_fare decimal(4,2) default NULL,
  non_fare decimal(4,2) default NULL,
  stop_desc2 char(30) NOT NULL default '',
  PRIMARY KEY  (route_no,stop_no,bound)
) TYPE=MyISAM;";

?>