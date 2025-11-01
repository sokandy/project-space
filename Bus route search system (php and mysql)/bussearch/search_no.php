<?php

//      search_no.php

require("common.php");
include('busconfig.php');

GenHeader();

$stmt="select route_no,air_fare,non_fare,bound,stop_desc from bus_det where " .
                "route_no = '$bus_no' and stop_no = 1";

if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
}

$i = 0;
if ($bus=mysql_fetch_object($result)) {
   GennoHeader($bus->route_no);
   Gennohtml($bus);
}
else {
  $i = 1;
}

$stmt="select route_no,air_fare,non_fare,bound,stop_desc from bus_rev where " .
                "route_no = '$bus_no' and stop_no = 1";

if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
}

$j = 0;
if ($bus=mysql_fetch_object($result)) {
  if ($i == 1)
    GennoHeader($bus->route_no);
  Gennohtml($bus);
}
else
  $j = 1;


$v = $i + $j;
if ($v >= 2)
  echo ("Cannot find you bus stop");

Genfooter();

?>