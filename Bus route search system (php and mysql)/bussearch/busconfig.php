<?php

  // busconfig.php

  include('globals.php');


  if (!($link = mysql_connect($hostname, $username, $password))) {
    printf("User $username Connect to $hostname appear Error");
    exit();
  }

  if (!mysql_select_db($dataname, $link)) {
    printf("Select %s Database Appear Error",$dataname);
    exit();
  }

  if (!mysql_query($temptab1, $link)) {
    printf("create temp table1 error");
    exit();
  }

  if (!mysql_query($temptab2, $link)) {
    printf("create temp table2 error");
    exit();
  }

  if (!mysql_query($temptab3, $link)) {
    printf("create temp table3 error");
    exit();
  }

  if (!mysql_query($temptab4, $link)) {
    printf("create temp table4 error");
    exit();
  }

  if (!mysql_query($temptab5, $link)) {
    printf("create temp table5 error");
    exit();
  }


?>



