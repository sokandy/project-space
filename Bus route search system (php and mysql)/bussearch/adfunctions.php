<?php

   require 'globals.php' ;

   function DisplayErrMsg($message) {
      printf("<blockquote><blockquote><blockquote><h3><font color=\"#cc0000\">
              %s</font></h3></blockquote></blockquote></blockquote>\n",
             $message);
   }

   function authenticateUser($user, $passwd) {
      global $hostname, $HTTP__HOST, $username, $password, $dataname, $DOCROOT;

      // Open a persistent connection with the MySQl server
      if (!($link = mysql_pconnect($hostname,$username,$password))) {
         DisplayErrMsg(sprintf("Error no %d %s\n",
                               mysql_errno(), mysql_error()));
         return 0 ;
      }

      if (!($result = mysql_db_query("$dataname", "SELECT * FROM user_profile WHERE
                      user_id='$user'"))) {
         DisplayErrMsg(sprintf("Error no %d %s\n",
                               mysql_errno(), mysql_error()));
         return 0 ;
      }

      if (($row = mysql_fetch_array($result)) &&
          ($passwd == $row["password"] && $passwd != ""))
         return 1 ;
      else
         return 0 ;
   }

   function deleteCookies() {


      for ($i = 0; $i < $total_items; $i++) {
         setcookie("items_tray[$i]", "");
         setcookie("quantity[$i]", "");
      }

      setcookie("items_tray", "");
      setcookie("total_items", "");
      setcookie("quantity", "") ;
   }

?>