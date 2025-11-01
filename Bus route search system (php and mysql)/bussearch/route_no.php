<?php

//      route_no.php

require("common.php");
include('busconfig.php');

GenHeader();
GenRouteHeader($route_no);

$geton=substr($select_from,0,3);
$getoff=substr($select_to,0,3);

if ($bound == 2) {

  $select_query="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
                 "from bus_rev, area where bus_rev.route_no = '$route_no' " .
                 "and area_code=stop_area order by stop_no asc";
}
elseif ($bound == 1) {
  $select_query="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
                 "from bus_det, area where bus_det.route_no = '$route_no' " .
                 "and area_code=stop_area order by stop_no asc";
}

if (!($select_result = mysql_query($select_query, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $select_query));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
}

$num_row=mysql_num_rows($select_result);

if ($num_row>0) {
  while ($bus=mysql_fetch_object($select_result)) {

      if ($bus->stop_area == $geton)
        $colour = "#9999ee";
      elseif ($bus->stop_area == $getoff)
          $colour = "#55dd55";
      else
        $colour = "#ffffe3";

      GenRoutehtml($bus,$colour);
  }
}
else {

        $html2="<p>Error in Route_no.php</p>";
        echo $html2;
}

Genfooter();


?>