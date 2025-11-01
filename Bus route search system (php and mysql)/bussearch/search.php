<?

   // search.php

   require("globals.php");
   require("common.php");


   if (!$route_no || !$bound) {
      DisplayErrMsg("Wrong: Route no and Bound need to input!\n");
      exit();
   }

   if ($bound == 1)
     $stmt = "SELECT * FROM bus_det,area WHERE route_no = '$route_no' and stop_area = area_code";
   elseif ($bound == 2)
     $stmt = "SELECT * FROM bus_rev,area WHERE route_no = '$route_no' and stop_area = area_code";

   if (!($result = mysql_query($stmt, $link))) {
      DisplayErrMsg(sprintf("Run statement %s occur error", $stmt));
      DisplayErrMsg(sprintf("Fault: %d %s",
                            mysql_errno($link), mysql_error($link)));
      exit();
   }

   $num=mysql_num_rows($result);
if ($num > 0) {
   printf("<HTML>");
   printf("<HEAD> <TITLE> Admin-page </TITLE> </HEAD>");
   printf("<BODY TEXT=\"#000000\" BGCOLOR=\"#F0F3D1\" LINK=\"#0000EE\"
           VLINK=\"#551A8B\" ALINK=\"#FF0000\">\n");
   printf("<H1><FONT SIZE=\"+4\">Admin Page</FONT></H1><BR>");
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=535>");
  printf("<TR><td>&nbsp;</td>");
  printf("<td width=500 align=left>Route No.: <b>$route_no</b></td>");
  printf("</tr></table>");
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=620 >");
  printf("<tr>");
  printf("<td>&nbsp;</td>");
  printf("<TD align=middle><img src=\"./image/etop1a.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1b.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1c.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1d.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1e.gif\"></TD>");
  printf("</TR>");

  while ($row = mysql_fetch_object($result)) {
        $bus_no=$row->route_no;
        $bound=$row->bound;
        printf("<tr bgcolor=\"#ffffe3\">");
        printf("<TD><A HREF=\"delete.php?route_no=$row->route_no&stop_no=$row->stop_no&bound=$row->bound\"><I>delete</I></A></td>");
        printf("<TD align=center valign=center>$row->stop_no</TD>");
        printf("<TD align=center valign=top>$row->area_name</TD>");
        printf("<TD align=center valign=top>$row->stop_desc</TD>");
        if ($row->non_fare > 0)
        echo ("<td align=middle>$$row->non_fare</td>");
        else
        echo ("<td align=middle>--</td>");

        if ($row->air_fare > 0)
        echo ("<td align=middle>$$row->air_fare</td>");
        else
        echo ("<td align=middle>--</td>");
        printf("</tr>");

        printf("<tr bgcolor=\"#ffffe3\">");
        printf("<td>&nbsp;</td>");
        printf("<td>&nbsp;</td>");
        printf("<td>&nbsp;</td>");
        printf("<TD align=center valign=top>$row->stop_desc2</TD>");
        printf("<td>&nbsp;</td>");
        printf("<td>&nbsp;</td>");
        printf("</tr>");
   }
   printf("</TABLE>\n");

//   mysql_free_result($reuslt);
   printf("<BR><FORM METHOD=\"get\" ACTION=\"adddel.php\">\n");
   printf("<font size=4>Stop no : </font><INPUT TYPE=\"text\" NAME=\"stop_no\" size=\"2\">\n<p>");
   printf("<INPUT TYPE=\"HIDDEN\" name=\"route_no\" value=$bus_no>");
   printf("<INPUT TYPE=\"HIDDEN\" name=\"bound\" value=$bound>");
   printf("<INPUT TYPE=\"submit\" NAME=\"choice\" VALUE=\"Add Bus Stop\">\n");
//   printf("<INPUT TYPE=\"submit\" NAME=\"choice\" VALUE=\"delete Bus Stop\">\n</Form>");
}
else
   printf("The Bus Route not found");

ReturnToMain() ;

?>