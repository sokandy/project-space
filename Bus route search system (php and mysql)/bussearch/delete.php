<?php

require("globals.php");
require("common.php");

   if (!$route_no || !$bound || !$stop_no) {
      DisplayErrMsg("Wrong: Route no and Bound need to input!\n");
      exit();
   }

   if ($bound == 1)
     $stmt = "SELECT max(stop_no) FROM bus_det WHERE route_no = '$route_no'";
   elseif ($bound == 2)
     $stmt = "SELECT max(stop_no) FROM bus_rev WHERE route_no = '$route_no'";

   if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
   }
   if ($row=mysql_fetch_row($result)) {
     list($dbstop_no)=$row;
     if (($stop_no) && ($stop_no <= $dbstop_no) && ($stop_no > $zero)) {
       if ($bound == 1)
         $stmt = "delete from bus_det where route_no = '$route_no' and stop_no = '$stop_no'";
       elseif ($bound == 2)
         $stmt = "delete from bus_rev where route_no = '$route_no' and stop_no = '$stop_no'";

       if (!($result = mysql_query($stmt, $link))) {
          DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
          DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
          exit();
       }
       else {
         if ($bound == 1)
           $stmt = "update bus_det set stop_no=stop_no-1 WHERE route_no = '$route_no'
                    and stop_no > '$stop_no'";
         elseif ($bound == 2)
           $stmt = "update bus_rev set stop_no=stop_no-1 WHERE route_no = '$route_no'
                    and stop_no > '$stop_no'";

         if (!($result = mysql_query($stmt, $link))) {
          DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
          DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
          exit();
         }
       }


     GenerateHTMLHeader("Delete Bus Route Complete Successfully");
     }
   }
   DisplayAfterDel($route_no,$bound) ;
