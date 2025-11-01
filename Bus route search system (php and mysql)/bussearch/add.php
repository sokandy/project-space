<?

   // add.php

   require("globals.php");
   require("common.php");


   if (!$route_no || !$bound || !($stop_area > 5)) {
      DisplayErrMsg("Wrong: Route no, Bound and Stop_area need to input!\n");
      exit();
   }

   $stop_area=substr($stop_area,0,3);

   if ($bound == 1)
     $stmt = "insert into bus_det(route_no,bound,stop_no,stop_area,stop_desc,air_fare,stop_desc2,next_time,
              non_fare) values('$route_no','$bound','$stop_no','$stop_area','$stop_desc','$air_fare','$stop_desc2','$time','$non_fare')";
   elseif ($bound == 2)
     $stmt = "insert into bus_rev(route_no,bound,stop_no,stop_area,stop_desc,air_fare,stop_desc2,next_time,
              non_fare) values('$route_no','$bound','$stop_no','$stop_area','$stop_desc','$air_fare','$stop_desc2','$time','$non_fare')";

   if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
   }

   GenerateHTMLHeader("Add Bus Route Complete Successfully");

   ContinueToAdd($route_no,$bound);

   ReturnToMain() ;

?>