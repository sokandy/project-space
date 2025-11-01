<?php

  // inter_no.php

  require("common.php");
  include('busconfig.php');


  GenHeader();
  GeninterHeader($from_no);
  if ($from_bound == 1) {
    $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_det, area where route_no = '$from_no' and bound = 1 and stop_no < $max_from " .
             "and stop_area=area_code order by stop_no asc";
  }
  elseif ($from_bound == 2) {
    $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_rev, area where route_no = '$from_no' and bound = 2 and stop_no < $max_from " .
             "and stop_area=area_code order by stop_no asc";
  }


  if (!($select_result = mysql_query($inter_row, $link))) {
     DisplayErrMsg(sprintf("Run statement %s occur error", $inter_row));
     DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
     exit();
  }

  $num_row=mysql_num_rows($select_result);


$i=0;
if ($num_row>0) {
while ($bus=mysql_fetch_object($select_result)) {

      if ($bus->stop_area == $geton)
        $colour = "#9999ee";
      elseif ($bus->stop_area == $getoff)
          $colour = "#55dd55";
      else
        $colour = "#ffffe3";
      $i=$i+1;
      $bus->stop_no=$i;
      GenRoutehtml($bus,$colour);
}
}

if ($from_bound == 1) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_det, area where route_no = '$from_no' and bound = 1 and stop_no = $max_from and stop_area=area_code order by stop_no asc";
}
elseif ($from_bound == 2) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_rev, area where route_no = '$from_no' and bound = 2 and stop_no = $max_from and stop_area=area_code order by stop_no asc";
}

if (!($select_result = mysql_query($inter_row, $link))) {
     DisplayErrMsg(sprintf("Run statement %s occur error", $inter_row));
     DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
     exit();
}

$num_row=mysql_num_rows($select_result);

if ($num_row>0) {
  while ($bus=mysql_fetch_object($select_result)) {

    $colour = "#F7753A";
    $i=$i+1;
    $bus->stop_no=$i;
    GenRoutehtml($bus,$colour);
  }
}

Genfooter();
GeninterHeader($to_no);

if ($to_bound == 1) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_det, area where route_no = '$to_no' and bound = 1 and stop_no = $min_to " .
             "and stop_area=area_code order by stop_no asc";
}
elseif ($to_bound == 2) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_rev, area where route_no = '$to_no' and bound = 2 and stop_no = $min_to " .
             "and stop_area=area_code order by stop_no asc";
}

if (!($select_result = mysql_query($inter_row, $link))) {
     DisplayErrMsg(sprintf("Run statement %s occur error", $inter_row));
     DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
     exit();
}

$num_row=mysql_num_rows($select_result);

if ($num_row>0) {
  while ($bus=mysql_fetch_object($select_result)) {

    $colour = "#F7753A";
    $i=$i+1;
    $bus->stop_no=$i;
    GenRoutehtml($bus,$colour);
  }
}


if ($to_bound == 1) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_det, area where route_no = '$to_no' and bound = 1 and stop_no > $min_to " .
             "and stop_area=area_code order by stop_no asc";
}
elseif ($to_bound == 2) {
  $inter_row="select route_no,stop_no,stop_area,stop_desc,air_fare,non_fare,area_name,stop_desc2 " .
             "from bus_rev, area where route_no = '$to_no' and bound = 2 and stop_no > $min_to " .
             "and stop_area=area_code order by stop_no asc";
}

if (!($select_result = mysql_query($inter_row, $link))) {
     DisplayErrMsg(sprintf("Run statement %s occur error", $inter_row));
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

      $i=$i+1;
      $bus->stop_no=$i;
      GenRoutehtml($bus,$colour);
  }
}

if (!mysql_close()) {
  printf("Database close error");
  exit();
}
?>
