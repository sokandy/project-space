<?php

//      search_row.php

require("common.php");
include('busconfig.php');

  GenHeader();
  GenRouteHeader($route_no);

  if ($bound == 1) {
    $stmt="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
          "from bus_det, area where bus_det.route_no = '$route_no' " .
          "and area_code=stop_area order by stop_no asc";
  }
  elseif ($bound == 2) {
    $stmt="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
          "from bus_rev, area where bus_rev.route_no = '$route_no' " .
          "and area_code=stop_area order by stop_no asc";
  }

  if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
  }


  while ($bus=mysql_fetch_object($result)) {

      $colour = "#ffffe3";
      GenRoutehtml($bus,$colour);
  }

if (!($num_row=mysql_num_rows($result))) {

   $html2="<p>Error in Route_no.php</p>";
   echo $html2;
}

  Genfooter();


?>