<?php

require("globals.php");
require("common.php");

if ($choice == "Add Bus Stop") {
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
     $zero = 0;
     $resultEntry["route_no"] = $route_no;
     $resultEntry["bound"] = $bound;
     $resultEntry["stop_no"] = $stop_no;
     $resultEntry["stop_area"] = "";
     $resultEntry["stop_desc"] = "";
     $resultEntry["non_fare"] = "";
     list($dbstop_no)=$row;
     if (($stop_no) && ($stop_no <= $dbstop_no+1) && ($stop_no > $zero)) {
       GenerateHTMLHeader("Input new value: (Route No,Bound and Stop_area is need)");
       GenerateAddHTMLForm($resultEntry, "addstop.php", "Confirm Add");
     }
     else
       printf("stop_no error");
   }

ReturnToMain() ;
}