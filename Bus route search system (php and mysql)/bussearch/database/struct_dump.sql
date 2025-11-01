# phpMyAdmin MySQL-Dump
# version 2.2.0
# http://phpwizard.net/phpMyAdmin/
# http://phpmyadmin.sourceforge.net/ (download page)
#
# Host: localhost
# Generation Time: April 18, 2002, 5:07 pm
# Server version: 3.23.41
# PHP Version: 4.0.4pl1
# Database : `bussearch`
# --------------------------------------------------------

#
# Table structure for table `area`
#

CREATE TABLE area (
  area_code char(3) NOT NULL default '',
  dis_code char(2) NOT NULL default '',
  area_name char(30) NOT NULL default '',
  PRIMARY KEY  (area_code,dis_code)
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `bus_det`
#

CREATE TABLE bus_det (
  route_no varchar(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '0',
  stop_area varchar(5) NOT NULL default '',
  stop_desc varchar(30) NOT NULL default '',
  non_fare decimal(4,2) default NULL,
  air_fare decimal(4,2) default NULL,
  stop_desc2 varchar(30) NOT NULL default '',
  next_time int(2) default NULL,
  PRIMARY KEY  (route_no,stop_no,bound),
  KEY stop_no (stop_no)
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `bus_rev`
#

CREATE TABLE bus_rev (
  route_no varchar(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '0',
  stop_area varchar(5) NOT NULL default '',
  stop_desc varchar(30) NOT NULL default '',
  non_fare decimal(4,2) default NULL,
  air_fare decimal(4,2) default NULL,
  stop_desc2 varchar(30) NOT NULL default '',
  next_time int(2) default NULL,
  PRIMARY KEY  (route_no,stop_no,bound)
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `district`
#

CREATE TABLE district (
  dis_code char(2) NOT NULL default '',
  dis_name char(30) NOT NULL default '',
  PRIMARY KEY  (dis_code)
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `temp_bus`
#

CREATE TABLE temp_bus (
  route_no char(5) NOT NULL default '',
  start_area char(5) NOT NULL default '',
  start_route char(30) NOT NULL default '',
  dist_area char(5) NOT NULL default '',
  dist_route char(30) NOT NULL default '',
  non_air decimal(4,2) NOT NULL default '0.00',
  air_cond decimal(4,2) NOT NULL default '0.00',
  stop_no int(2) NOT NULL default '0',
  PRIMARY KEY  (route_no)
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `temp_det`
#

CREATE TABLE temp_det (
  route_no char(5) NOT NULL default '',
  stop_no int(2) NOT NULL default '0',
  bound int(1) NOT NULL default '2',
  stop_d1 char(30) NOT NULL default '',
  stop_d2 char(30) NOT NULL default '',
  air_fare decimal(4,2) NOT NULL default '0.00',
  non_fare decimal(4,2) NOT NULL default '0.00',
  stop_d3 char(30) NOT NULL default ''
) TYPE=MyISAM;
# --------------------------------------------------------

#
# Table structure for table `user_profile`
#

CREATE TABLE user_profile (
  name varchar(40) NOT NULL default '',
  user_id varchar(20) NOT NULL default '',
  password varchar(20) NOT NULL default '',
  PRIMARY KEY  (password)
) TYPE=MyISAM;

