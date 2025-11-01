<?php

//      route_info.php

require("common.php");
include('busconfig.php');


$geton=substr($select_from,0,3);
$getoff=substr($select_to,0,3);


$insert_from_query= "insert into temp_from (route_no,stop_no,bound) " .
                    "select route_no,stop_no,bound from bus_det " .
                    "where stop_area = '$geton'";
$insert_from_q= "insert into temp_from (route_no,stop_no,bound) " .
                    "select route_no,stop_no,bound from bus_rev " .
                    "where stop_area = '$geton'";

$insert_to_query= "insert into temp_to (route_no,stop_no,bound) " .
                  "select route_no,stop_no,bound from bus_det " .
                  "where stop_area = '$getoff'";
$insert_to_q= "insert into temp_to (route_no,stop_no,bound) " .
                  "select route_no,stop_no,bound from bus_rev " .
                  "where stop_area = '$getoff'";

$stmt="select a.route_no, a.bound , max(a.stop_no) as stop_no from temp_from as a,temp_to as b " .
      "where a.route_no = b.route_no and a.bound = b.bound and a.stop_no < b.stop_no group by a.route_no";

$insert_from_result=mysql_query($insert_from_query, $link);

$insert_to_result=mysql_query($insert_to_query, $link);

$insert_from_r=mysql_query($insert_from_q, $link);

$insert_to_r=mysql_query($insert_to_q, $link);

if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
}

$num_row=mysql_num_rows($result);

// only one bus need to arrive the destination

if ($num_row>0) {
  GenHeader();
  GeninfoHeader();
  while ($bus=mysql_fetch_object($result)) {

      if ($bus->bound == 1) {
         $no_query="select route_no,bound,air_fare,non_fare from bus_det where " .
                "route_no = '$bus->route_no' and stop_no = 1";
         $stmt1="select min(stop_no) as min_on from bus_det where route_no = '$bus->route_no' ".
               "and stop_area = '$geton' group by route_no";
         $stmt2="select min(stop_no) as min_off from bus_det where route_no = '$bus->route_no' ".
               "and stop_area = '$getoff' group by route_no";
         $stmt3="select sum(next_time) as next_time from bus_det where route_no = '$bus->route_no' and ".
               "stop_no >= '$row1->min_on' and stop_no < '$row2->min_off'";

      }
      elseif ($bus->bound == 2) {
         $no_query="select route_no,bound,air_fare,non_fare from bus_rev where " .
                "route_no = '$bus->route_no' and stop_no = 1";
         $stmt1="select min(stop_no) as min_on from bus_rev where route_no = '$bus->route_no' ".
               "and stop_area = '$geton' group by route_no";
         $stmt2="select min(stop_no) as min_off from bus_rev where route_no = '$bus->route_no' ".
               "and stop_area = '$getoff' group by route_no";
         $stmt3="select sum(next_time) as next_time from bus_rev where route_no = '$bus->route_no' and ".
               "stop_no >= '$row1->min_on' and stop_no < '$row2->min_off'";
      }

      if (!($no_result = mysql_query($no_query, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $no_query));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }

      if (!($result1 = mysql_query($stmt1, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $stmt1));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }
      if (!($result2 = mysql_query($stmt2, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $stmt2));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }

      $row1=mysql_fetch_object($result1);
      $row2=mysql_fetch_object($result2);

      if ($bus->bound == 1) {
         $stmt3="select sum(next_time) as next_time from bus_det where route_no = '$bus->route_no' and ".
               "stop_no >= '$row1->min_on' and stop_no < '$row2->min_off'";

      }
      elseif ($bus->bound == 2) {
         $stmt3="select sum(next_time) as next_time from bus_rev where route_no = '$bus->route_no' and ".
               "stop_no >= '$row1->min_on' and stop_no < '$row2->min_off'";
      }

      if (!($result3 = mysql_query($stmt3, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $stmt3));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }

      $row3=mysql_fetch_object($result3);

      if ($busrow=mysql_fetch_object($no_result)) {
        Geninfohtml($busrow,$row3->next_time,$geton,$getoff);
      }
  }
}
// one bus can't arrive the destination

if ($num_row==0) {
    $diff_from = "select route_no,bound,max(stop_no) from temp_from group by route_no,bound";
    $diff_to = "select route_no,bound,max(stop_no) from temp_to group by route_no,bound";

    if (!($dfrom_result=mysql_query($diff_from, $link))) {
      DisplayErrMsg(sprintf("Run Stat. %s appear Error!", $diff_from));
      DisplayErrMsg(sprintf("Error : %d %s",
                        mysql_errno($link), mysql_error($link)));
      exit();
    }
    if (!($dto_result=mysql_query($diff_to, $link))) {
      DisplayErrMsg(sprintf("Run Stat. %s appear Error!", $diff_to));
      DisplayErrMsg(sprintf("Error : %d %s",
                        mysql_errno($link), mysql_error($link)));
      exit();
    }

    while ($row=mysql_fetch_row($dfrom_result)) {

      list($route_no,$bound) = $row;
      if ($bound == 1) {
        $no_query="insert into diff1 (route_no,stop_no,bound,stop_area,stop_desc,stop_desc2) " .
                "select route_no,stop_no,bound,stop_area,stop_desc,stop_desc2 from bus_det where " .
                "route_no = '$route_no' and bound = 1";
      }
      elseif ($bound == 2) {
        $no_query="insert into diff1 (route_no,stop_no,bound,stop_area,stop_desc,stop_desc2) " .
                "select route_no,stop_no,bound,stop_area,stop_desc,stop_desc2 from bus_rev where " .
                "route_no = '$route_no' and bound = 2";
      }

      if (!($no_result = mysql_query($no_query, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $no_query));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }

    }

    while ($row=mysql_fetch_row($dto_result)) {

      list($route_no,$bound) = $row;
      if ($bound == 1) {
        $no_query="insert into diff2 (route_no,stop_no,bound,stop_area,stop_desc,stop_desc2) " .
                "select route_no,stop_no,bound,stop_area,stop_desc,stop_desc2 from bus_det where " .
                "route_no = '$route_no' and bound = 1";
      }
      elseif ($bound == 2) {
        $no_query="insert into diff2 (route_no,stop_no,bound,stop_area,stop_desc,stop_desc2) " .
                "select route_no,stop_no,bound,stop_area,stop_desc,stop_desc2 from bus_rev where " .
                "route_no = '$route_no' and bound = 2";
      }

      if (!($no_result = mysql_query($no_query, $link))) {
        DisplayErrMsg(sprintf("Run statement %s occur error", $no_query));
        DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
        exit();
      }

    }

  $diff_query= "insert into temp_diff (from_no,from_stop,from_bound,stop_area,to_no,to_stop,to_bound,stop_desc,stop_desc2) " .
               "select diff1.route_no,diff1.stop_no,diff1.bound,diff1.stop_area,diff2.route_no,diff2.stop_no,diff2.bound,diff1.stop_desc,diff1.stop_desc2 " .
               "from diff1,diff2 where diff1.stop_area = diff2.stop_area and diff1.stop_desc = diff2.stop_desc";

  if (!($diff_result=mysql_query($diff_query, $link))) {
    DisplayErrMsg(sprintf("Run Stat. %s appear Error!", $diff_query));
    DisplayErrMsg(sprintf("Error : %d %s",
                 mysql_errno($link), mysql_error($link)));
    exit();
  }


  $inter_query = "SELECT from_no,from_bound,to_no,to_bound,area_name,max(from_stop) as max_no," .
                 "max(to_stop) as min_no,d.stop_desc,d.stop_desc2 FROM temp_diff as d,temp_from " .
                 "as f,temp_to as t,area where d.from_no=f.route_no and d.from_bound=f.bound " .
                 "and d.to_no=t.route_no and d.to_bound=t.bound " .
                 "and d.from_stop > f.stop_no and d.to_stop < t.stop_no and " .
                 "d.stop_area=area_code group by from_no, to_no";

  if (!($inter_result=mysql_query($inter_query, $link))) {
    DisplayErrMsg(sprintf("Run Stat. %s appear Error!", $inter_query));
    DisplayErrMsg(sprintf("Error : %d %s",
                 mysql_errno($link), mysql_error($link)));
    exit();
  }
  GenHeader();
  while ($bus=mysql_fetch_object($inter_result)) {
    Geninterhtml($bus,$geton,$getoff);
  }
}

if (!mysql_close()) {
  printf("Database close error");
  exit();
}

Genfooter();

?>