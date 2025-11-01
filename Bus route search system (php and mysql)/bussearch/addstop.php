<?

   // addstop.php

   require("globals.php");
   require("common.php");


   if (!$route_no || !$bound) {
      DisplayErrMsg("Wrong: Route no and Bound need to input!\n");
      exit();
   }

   $stop_area=substr($stop_area,0,3);

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
      list($max_stop)=$row;
      if ($stop_no >= $max_stop) {

        if ($bound == 1)
           $stmt = "update bus_det set stop_no=stop_no+1 WHERE route_no = '$route_no'
              and stop_no >= '$stop_no'";
        elseif ($bound == 2)
           $stmt = "update bus_rev set stop_no=stop_no+1 WHERE route_no = '$route_no'
              and stop_no >= '$stop_no'";

        if (!($result = mysql_query($stmt, $link))) {
          DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
          DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
        }
      }
      elseif ($stop_no < $max_stop) {
        for ($i = $max_stop; $i >= $stop_no; --$i) {
         if ($bound == 1)
           $stmt = "update bus_det set stop_no=stop_no+1 WHERE route_no = '$route_no'
              and stop_no = '$i'";
         elseif ($bound == 2)
           $stmt = "update bus_rev set stop_no=stop_no+1 WHERE route_no = '$route_no'
              and stop_no = '$i'";

         if (!($result = mysql_query($stmt, $link))) {
           DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
           DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
         exit();
         }
        }
      }

        if ($bound == 1)
          $stmt = "insert into bus_det(route_no,bound,stop_no,stop_area,stop_desc,air_fare,stop_desc2,next_time,
                non_fare) values('$route_no','$bound','$stop_no','$stop_area','$stop_desc','$air_fare','$stop_desc2','$time',
                '$non_fare')";
        elseif ($bound == 2)
          $stmt = "insert into bus_rev(route_no,bound,stop_no,stop_area,stop_desc,air_fare,stop_desc2,next_time,
                non_fare) values('$route_no','$bound','$stop_no','$stop_area','$stop_desc','$air_fare','$stop_desc2','$time',
                '$non_fare')";

        if (!($result = mysql_query($stmt, $link))) {
          DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
          DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
          exit();
        }
        GenerateHTMLHeader("Add Bus Route Complete Successfully");
        ContinueToAdd($route_no,$bound);
     }



   ReturnToMain() ;

?>