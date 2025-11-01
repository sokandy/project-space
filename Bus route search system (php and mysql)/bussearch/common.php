
<script language=javascript>
<!--
function check_select()
{
	if (document.route1.select_from.options[document.route1.select_from.selectedIndex].value.substring(0, 6) == "header" ||
	    document.route1.select_to.options[document.route1.select_to.selectedIndex].value.substring(0, 6) == "header")
		 {
		   alert("Please select area before search")
		 }
	else if (document.route1.select_from.options[document.route1.select_from.selectedIndex].value == "all" ||
	    document.route1.select_to.options[document.route1.select_to.selectedIndex].value == "all")
		 {
		   alert("Please select area before search")
		 }
	else if (document.route1.select_from.options[document.route1.select_from.selectedIndex].value ==
		 document.route1.select_to.options[document.route1.select_to.selectedIndex].value)
		 {
		   alert("Please select different area");
		 }
	else
		document.route1.submit();
}

function populate_data(ddlb, val, dis_info) {
	var j=0, l, i=0, count=0;
	var s = new String("")


	clear_header(ddlb);

	var no = new Option();
	insert_option( "header" + dis_info, "---- " + dis_info + " ----",0, ddlb);

	for (i=2; j < ddlb.length; i++)
	{
		s = ddlb.options[j].value
		if (s.substr(3,2) == val)
		{
			insert_option(ddlb[j].value, ddlb[j].text, 1, ddlb);
				//return;
			j++;
		}
		j++;
	}


	ddlb[0].selected = true;
}

function insert_option(ival, itext, ix, iddlb) {
	var lno = new Option();
	var u,i,k;

	u = iddlb.length-1;
	// last value
	lno.value = iddlb.options[u].value;
	lno.text = iddlb.options[u].text;
	// append new object
	iddlb.options[u+1] = lno;

	u=iddlb.length-2;
	for(i=u; i>=ix; i--)
	{
		k = i+1;
		iddlb.options[k].text = iddlb.options[i].text;
		iddlb.options[k].value = iddlb.options[i].value;
	}
	iddlb.options[ix].text = itext;
	iddlb.options[ix].value = ival;
}

function clear_header(cddlb) {
	var ptr, i, j;
	for (i=0; i<cddlb.length; i++)
	{
		if (cddlb.options[i].value == "all")
		{
			ptr = i;
		}
	}

	j=0;
	if (ptr > 0)
	{
		for (i=ptr; i<cddlb.length; i++)
		{
			cddlb.options[i-ptr].value = cddlb.options[i].value;
			cddlb.options[i-ptr].text = cddlb.options[i].text;
			j++;
		}
		cddlb.length = j
	}
}
//-->
</script>



<?php

// common.php

include('busconfig.php');

   function GenerateHTMLHeader($message) {
      printf("<HTML>");
      printf("<HEAD> <TITLE> Admin-page </TITLE> </HEAD>");
      printf("<BODY TEXT=\"#000000\" BGCOLOR=\"#F0F3D1\" LINK=\"#0000EE\"
                    VLINK=\"#551A8B\" ALINK=\"#FF0000\">\n");
      printf("<H1><FONT SIZE=\"+4\">Admin Page</FONT></H1><BR><BR>");
      printf("<TABLE CELLPADDING=4 CELLSPACING=0 BORDER=0 WIDTH=600>");
      printf("<TR BGCOLOR=\"#DCDCDC\"><TD><B>");
      printf("%s</B></TD>", $message);
      printf("</TR>");
      printf("</TABLE>");
      printf("<BR>");
      printf("<BR>");
   }


   function GenerateFrontPage() {
      printf("<FORM METHOD=\"post\" ACTION=\"main.php\">");
      printf("<INPUT TYPE=\"submit\" NAME=\"choice\" VALUE=\"Search Route\">");
      printf("&nbsp; &nbsp; &nbsp;");
      printf("<INPUT TYPE=\"submit\" NAME=\"choice\" VALUE=\"Add Route\">");
      printf("<BR>");
      printf("<BR>");
      printf("<UL>");
      printf("<LI>If you want to search bus route, please click <B>Search Route</B> button</LI>");
      printf("<LI>If you want to add bus route, please click <B>Add Route</B> button</LI>");
      printf("<LI>If you want to modify bus route, Firstly, please click <B>Search Route </B> button,
                  then choice your bus route to modify</LI>");
      printf("<LI>If you want to delete bus route, Firstly, please click <B>Search Route </B> button,
                  then choice your bus route to delete</LI>");
      printf("</UL>");
      printf("</FORM>");
   }

   function DisplayErrMsg($message) {
      printf("<BLOCKQUOTE><BLOCKQUOTE><BLOCKQUOTE>
              <H3><FONT COLOR=\"#CC0000\">%s</FONT></H3>
              </BLOCKQUOTE></BLOCKQUOTE></BLOCKQUOTE>\n", $message);
   }

   function ReturnToMain() {
      printf("<BR><FORM METHOD=\"post\" ACTION=\"main.php\">\n");
      printf("<INPUT TYPE=\"submit\" VALUE=\"Back To Main\"></FORM>");
   }

   function GoToClient() {
      printf("<BR><FORM METHOD=\"post\" ACTION=\"busearch.php\">\n");
      printf("<INPUT TYPE=\"submit\" VALUE=\"Go To Bus Search\"></FORM>");
   }

   function ContinueToAdd($route_no,$bound) {
      printf("<BR><FORM METHOD=\"get\" ACTION=\"search.php\">\n");
      printf("<INPUT TYPE=\"HIDDEN\" name=\"route_no\" value=$route_no>");
      printf("<INPUT TYPE=\"HIDDEN\" name=\"bound\" value=$bound>");
      printf("<INPUT TYPE=\"submit\" VALUE=\"Display Result\">\n</FORM>");
   }

   function DisplayAfterDel($route_no,$bound) {
      printf("<BR><FORM METHOD=\"get\" ACTION=\"search.php\">\n");
      printf("<INPUT TYPE=\"HIDDEN\" name=\"route_no\" value=$route_no>");
      printf("<INPUT TYPE=\"HIDDEN\" name=\"bound\" value=$bound>");
      printf("<INPUT TYPE=\"submit\" VALUE=\"Display Result\">\n</FORM>");
   }


function GenHeader() {
  printf("<html>");
  printf("<head>");
  printf("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
  printf("<title>Kowloon Motor Bus - search</title>");

  printf("<style type=\"text/css\">
        A:link    {text-decoration:none ; color:#cc0000;}
        A:visited {text-decoration:none ; color:#cc0000;}
        A:hover   {text-decoration: underline; color:#cc0000;}");
  printf("</style>");
  printf("</head>");

  printf("<body background=\"./image/conbg.gif\" BGCOLOR=\"#F0F3D1\" marginwidth=\"0\" marginheight=\"0\" topmargin=0 leftmargin=0 onload=\"preloadImages();\">");
  printf("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
  printf("<td colspan=4><img src=./image/tc1.gif border=0 usemap=#about></td>  </tr>");
  printf("</table>");

}

function GennoHeader($route_no) {
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=150>");
  printf("<TR><td width=500 align=left>Route No.: <b>$route_no</b></td>");
  printf("</tr></table>");
  printf("<p>");
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=150 >");
  printf("<tr>");
  echo ("<td align=middle><img src=\"./image/etop3a.gif\"></td>");
  echo ("<td align=middle><img src=\"./image/etop3b.gif\"></td>");
  echo ("<td align=middle><img src=\"./image/etop3c.gif\"></td>");
  echo ("</tr>");
}

function GenRouteHeader($route_no) {
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=620>");
  printf("<TR><td width=500 align=left>Route No.: <b>$route_no</b></td>");
  printf("<td width=40 bgcolor=#9999ee><strong>Get On</strong></td><td width=40 bgcolor=#55dd55><strong>Get Off</strong></td></tr></table>");
  printf("<p>");
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=620 >");
  printf("<tr>");
  printf("<TD align=middle><img src=\"./image/etop1a.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1b.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1c.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1d.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1e.gif\"></TD>");
  printf("</TR>");
}

function GeninterHeader($route_no) {
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=620>");
  printf("<TR><td width=500 align=left>Route No.: <b>$route_no</b></td>");
  printf("<td width=40 bgcolor=#9999ee><strong>Get On</strong></td><td width=40 bgcolor=#F7753A><strong>Interchange</strong></td><td width=40 bgcolor=#55dd55><strong>Get Off</strong></td></tr></table>");
  printf("<p>");
  printf("<TABLE border=0 cellPadding=1 cellSpacing=1 width=620 >");
  printf("<tr>");
  printf("<TD align=middle><img src=\"./image/etop1a.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1b.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1c.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1d.gif\"></TD>");
  printf("<TD align=middle><img src=\"./image/etop1e.gif\"></TD>");
  printf("</TR>");
}

function GeninfoHeader() {
  echo ("<p><p>Please select from the following:</p>");
  echo ("<table border=0 cellpadding=1 cellspacing=1>");
  echo ("<tr bgcolor=#FFEFCE>");
  echo ("<td align=middle><img src=\"./image/etop3a.gif\"></td>");
  echo ("<td align=middle><img src=\"./image/etop3b.gif\"></td>");
  echo ("<td align=middle><img src=\"./image/etop3c.gif\"></td>");
  printf("<TD valign=bottom><font color=\"red\"><B>Time Needs</B></font></TD>");
  echo ("</tr>");
}

function GenRoutehtml($bus,$colour) {
  printf("<tr bgcolor=$colour>");
  printf("<TD align=center valign=center>$bus->stop_no</TD>");
  printf("<TD align=center valign=center>$bus->area_name</TD>");
  printf("<TD align=center valign=center>$bus->stop_desc</TD>");
  if ($bus->non_fare > 0)
    echo ("<td align=middle>$$bus->non_fare</td>");
  else
    echo ("<td align=middle>--</td>");

  if ($bus->air_fare > 0)
    echo ("<td align=middle>$$bus->air_fare</td>");
  else
    echo ("<td align=middle>--</td>");
  printf("</tr>");
  printf("<tr bgcolor=$colour><td>&nbsp;</td>");
  printf("<td>&nbsp;</td>");
  printf("<TD align=center valign=center>$bus->stop_desc2</TD>");
  printf("<td>&nbsp;</td>");
  printf("<td>&nbsp;</td>");
  printf("</tr>");
}

function Geninterhtml2($route_no,$stop_no,$stop_desc,$air,$nor,$area_name,$colour,$stop_desc2) {
  printf("<tr bgcolor=$colour><TD align=center valign=top>");
  printf("$stop_no</TD>");
  printf("<TD align=center valign=top>$area_name</TD>");
  printf("<TD align=center valign=top>$stop_desc</TD>");
  if ($nor > 0)
    echo ("<td align=middle>$$nor</td>");
  else
    echo ("<td align=middle>--</td>");

  if ($air > 0)
    echo ("<td align=middle>$$air</td>");
  else
    echo ("<td align=middle>--</td>");
  printf("</tr>");
  printf("<tr bgcolor=$colour><td>&nbsp;</td>");
  printf("<td>&nbsp;</td>");
  printf("<TD align=center valign=top>$stop_desc2</TD>");
  printf("<td>&nbsp;</td>");
  printf("<td>&nbsp;</td>");
  printf("</tr>");
}

function Geninterhtml($bus,$geton,$getoff) {
  echo ("<p><p>Interchange Area: <b>$bus->area_name         </b>");
  echo ("<p><table bgcolor=#FFEFCE>");
  echo ("<TR bgcolor=#9E1A45>");
  echo ("<TD align=middle><font color=#FFFFFF><B>Bus Number</B></font></TD>");
  echo ("<TD align=middle><font color=#FFFFFF><B>Interchange</B></font></TD>");
  echo ("<TD align=middle><font color=#FFFFFF><B>Bus Number</B></font></TD>");
  echo ("</TR>");
  echo ("<tr bgcolor=#ffffe3>");
  echo ("<td align=middle><a href=\"inter_no.php?from_bound=$bus->from_bound&to_bound=$bus->to_bound&geton=$geton&getoff=$getoff&max_from=$bus->max_no&min_to=$bus->min_no&from_no=$bus->from_no&to_no=$bus->to_no\">$bus->from_no</a></td>");
  echo ("<td align=middle>$bus->stop_desc</td>");
  echo ("<td align=middle><a href=\"inter_no.php?from_bound=$bus->from_bound&to_bound=$bus->to_bound&geton=$geton&getoff=$getoff&max_from=$bus->max_no&min_to=$bus->min_no&from_no=$bus->from_no&to_no=$bus->to_no\">$bus->to_no</a></td>");
  echo ("</tr>");
  echo ("<tr bgcolor=#ffffe3>");
  echo ("<td>&nbsp;</td>");
  echo ("<td align=middle>$bus->stop_desc2</td>");
  echo ("<td>&nbsp;</td>");
//  echo ("<td>&nbsp;</td>");
  echo ("</tr>");
//  echo ("<tr>");
//  echo ("<td>&nbsp;</td>");
//  echo ("<td align=middle></td>");
//  echo ("<td>&nbsp;</td>");
//  echo ("<td>&nbsp;</td>");
//  echo ("</tr>");
  echo ("</table>");
}


function Genfooter() {
  echo ("</tr>");
  echo ("</table>");
  echo ("<map name=\"about\">");
  echo ("<area shape=\"rect\" coords=\"550,15,617,26\" href=\"busearch.php\">");
  echo ("</map>");
  echo ("</body>");
  echo ("</html>");
  echo ("<p><p>");
}

function Geninfohtml($busrow,$need_time,$geton,$getoff) {
  echo ("<tr bgcolor=#ffffe3>");
  echo ("<td align=middle><a href=\"route_no.php?&route_no=$busrow->route_no&bound=$busrow->bound&select_from=$geton&select_to=$getoff\"> $busrow->route_no </a></td>");

  if ($busrow->non_fare > 0)
    echo ("<td align=middle>$$busrow->non_fare</td>");
  else
    echo ("<td align=middle>Air Cond. Only</td>");

  if ($busrow->air_fare > 0)
    echo ("<td align=middle>$$busrow->air_fare</td>");
  else
    echo ("<td align=middle>Non Air Cond.</td>");
  echo ("<td align=middle>$need_time</td>");
  echo ("</tr>");
}

function Gennohtml($bus) {
  printf ("<tr bgcolor=#ffffe3>");
  printf ("<td align=center valign=center><a href=\"search_row.php?&route_no=$bus->route_no&bound=$bus->bound\"> $bus->stop_desc </a></td>");

  if ($bus->non_fare > 0)
    echo ("<td align=middle>$$bus->non_fare</td>");
  else
    echo ("<td align=middle>Air Cond. Only</td>");

  if ($bus->air_fare > 0)
    echo ("<td align=middle>$$bus->air_fare</td>");
  else
    echo ("<td align=middle>Non Air Cond. Only</td>");
  echo ("</tr>");
}


function Genresult() {
  printf("<td valign=top>");
  printf("<table border=\"0\" cellspacing=\"10\" cellpadding=\"10\" width=\"620\">");
  printf("<tr>");
  printf("<td>");

  printf("<form action=\"search_no.php\" method=\"get\">");
  printf("  <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
  printf("    <tr> ");
  printf("    <td width=\"402\" height=\"30\" align=\"left\" valign=\"top\"><img src=\"./image/shder1.gif\" width=\"189\" height=\"30\"></td>");
  printf("    <td rowspan=\"2\" align=\"left\" valign=\"top\" width=\"10\"></td>");
  printf("    <td rowspan=\"2\" align=\"left\" valign=\"bottom\" width=\"170\">");
  printf("<p><font size=2>If you know the required route number, you can directly input the route number, then press \"Search\" button.</font>");
  printf("      </td>");
  printf("    </tr>");
  printf("    <tr> ");
  printf("      <td width=\"402\" valign=\"middle\" align=\"center\" bgcolor=\"black\" height=\"2\"> ");
  echo("        <table width=\"98%\" border=\"0\" cellpadding=\"4\" bgcolor=\"#B50018\" height=\"98%\">");
  printf("          <tr valign=\"middle\"> ");
  printf("            <td valign=\"middle\"><img src=\"./image/txt1.gif\" width=\"92\" height=\"32\"> ");
  printf("            </td>");
  printf("            <td valign=\"middle\"> ");
  printf("              <INPUT id=bus_no name=bus_no size=5 maxlength=5>");
  printf("              <p></P>");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"select_from\" value=\"\">");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"select_to\" value=\"\">");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"page\" value=\"search\">");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"prog\" value=\"route_no.php\">");
  printf("            </td>");
  printf("            <td valign=\"middle\">");
  printf("              <INPUT TYPE=image SRC=\"./image/searchbut.gif\" border=0>");
  printf("            </td>");
  printf("          </tr>");
  printf("        </table>");
  printf("      </td>");
  printf("    </tr>");
  printf("  </table>");
  printf("</form>");
}

function Gensearchfooter() {
  printf("          <tr align=\"center\" valign=\"middle\" bgcolor=\"#B50018\"> ");
  printf("            <td colspan=\"2\">");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"page\" value=\"search\">");
  printf("              <INPUT TYPE=\"HIDDEN\" name=\"prog\" value=\"route_info.php\">");
  printf("              <a href=\"javascript:check_select()\"><img src=\"./image/searchbut.gif\" width=\"128\" height=\"43\" border=\"0\"></a>");
  printf("            </td>");
  printf("          </tr>");
  printf("        </table>");
  printf("      </td>");
  printf("    </tr>");
  printf("  </table>");
  printf("</form> ");
  printf("          </td>");
  printf("        </tr>");
  printf("      </table>");
  printf("    </td>");
  printf("  </tr>");
  printf("  <tr>");
  printf("    <td></td>");
  printf("  </tr>");
  printf("</table>");
  printf("<map name=\"about\">");
  printf("<area shape=\"rect\" coords=\"550,15,617,26\" href=\"busearch.php\"> ");
  printf("</map>");
  printf("</body>");
  printf("</html>");
}

function Gensearcheader() {
  printf("<form action=\"route_info.php\" method=\"get\" name=route1>");
  printf("  <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
  printf("    <tr> ");
  printf("    <td align=\"left\" valign=\"top\" height=\"28\" width=\"402\"><img src=\"./image/shder2.gif\" width=\"222\" height=\"28\"></td>");
  printf("    <td rowspan=\"2\" align=\"left\" valign=\"top\" width=\"10\"></td>");
  printf("    <td rowspan=\"2\" align=\"left\" valign=\"top\" width=\"170\">");

  printf("<font size=2>");
  printf("<p>1. First, select the district of the origin");
  printf("<br>Example: Kowloon City, Central and Western etc.");
  printf("<p>2. Next, select the area in the origin");
  printf("<br>Example: the Peak, Ho Man Tin etc.");
  printf("<p>3. Next, input the district and area of the destination.");
  printf("<p>4. Press \"Search\" button to show the route search result.");
  printf("</font>");
  printf("      </td>");
  printf("    </tr>");
  printf("    <tr> ");
  printf("      <td bgcolor=\"#000000\" valign=\"middle\" align=\"center\" height=\"119\"> ");
  echo("        <table width=\"100%\" border=\"0\" cellspacing=\"2\" cellpadding=\"4\" bgcolor=\"#990000\">");
}

function Gensearchwhere($txt,$colour,$where) {
  $i1="./image/";
  $i2=".gif";
  $d1="district_";
  $s1="select_";
  $t1="this.form.select_";
  $t2="this.form.district_";
  $t2_2=".options[this.form.district_";
  $t2_3=".selectedIndex].value";
  $t2_4=".selectedIndex].text";
  $dilocate = $d1 . $where;
  $selocate = $s1 . $where;
  $imlocate = $i1 . $txt . $i2;
  $w1locate = $t1 . $where;
  $w2locate = $t2 . $where . $t2_2 . $where . $t2_3;
  $w3locate = $t2 . $where . $t2_2 . $where . $t2_4;


  printf("<tr> ");
  echo("<td valign=\"middle\" align=\"center\" bgcolor=\"#733108\" width=\"29%\"><img src=\"./image/up.gif\" width=\"89\" height=\"89\"></td>");
  echo("<td width=\"100%\" align=\"left\" valign=\"middle\" bgcolor=$colour> ");
  echo("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
  printf("<tr align=\"left\"> ");
  printf("<td><img src=$imlocate width=\"148\" height=\"30\"></td>");
  printf("</tr>");
  printf("<tr> ");
  printf("<td> ");
  printf("<p> ");
  printf("<select id=$dilocate name=$dilocate onChange=\"populate_data($w1locate, $w2locate, $w3locate)\">");
  printf("<OPTION selected value=\"all\">--- All Districts ---");
  printf("<OPTION value=\"15\">CENTRAL & WESTERN");
  printf("<OPTION value=\"18\">EASTERN H.K. ISLAND");
  printf("<OPTION value=\"02\">ISLANDS");
  printf("<OPTION value=\"04\">KOWLOON CITY");
  printf("<OPTION value=\"12\">KWAI TSING");
  printf("<OPTION value=\"05\">KWUN TONG");
  printf("<OPTION value=\"09\">NORTH N.T.");
  printf("<OPTION value=\"10\">SAI KUNG");
  printf("<OPTION value=\"07\">SHA TIN");
  printf("<OPTION value=\"03\">SHAM SHUI PO");
  printf("<OPTION value=\"17\">SOUTHERN H.K. ISLAND");
  printf("<OPTION value=\"08\">TAI PO");
  printf("<OPTION value=\"11\">TSUEN WAN");
  printf("<OPTION value=\"13\">TUEN MUN");
  printf("<OPTION value=\"16\">WAN CHAI");
  printf("<OPTION value=\"06\">WONG TAI SIN");
  printf("<OPTION value=\"01\">YAU TSIM MONG");
  printf("<OPTION value=\"14\">YUEN LONG");

  printf("</select>");
  printf("</p>");
  printf("<p> ");
  printf("<select id=$selocate name=$selocate>");
  printf("<OPTION selected value=\"all\">--- All Areas ---");
  printf("<OPTION value=\"17B17\">ABERDEEN/WONG CHUK HANG");
  printf("<OPTION value=\"02B02\">AIRPORT PASSENGER TERMINA");
  printf("<OPTION value=\"02C02\">AIRPORT SUPPORTING AREA");
  printf("<OPTION value=\"11D11\">ALLWAY/BELVEDERE GARDENS");
  printf("<OPTION value=\"16C16\">CAUSEWAY BAY");
  printf("<OPTION value=\"15D15\">CENTRAL/ADMIRALTY");
  printf("<OPTION value=\"18D18\">CHAI WAN/SIU SAI WAN");
  printf("<OPTION value=\"03E03\">CHAK ON/TAI HANG TUNG");
  printf("<OPTION value=\"02D02\">CHEK LAP KOK FERRY PIER");
  printf("<OPTION value=\"12A12\">CHEUNG CHING/CHEUNG HONG");
  printf("<OPTION value=\"12G12\">CHEUNG HANG");
  printf("<OPTION value=\"12B12\">CHEUNG ON/TSING YI AR STN");
  printf("<OPTION value=\"03C03\">CHEUNG SHA WAN");
  printf("<OPTION value=\"06I06\">CHOI WAN");
  printf("<OPTION value=\"09G09\">CHOI YUEN/TAI PING");
  printf("<OPTION value=\"06F06\">CHUK YUEN/TSUI CHUK");
  printf("<OPTION value=\"10G10\">CLEAR WATER BAY/HKUST");
  printf("<OPTION value=\"12J12\">CONTAINER TERMINAL");
  printf("<OPTION value=\"06C06\">DIAMOND HILL");
  printf("<OPTION value=\"17D17\">DP.WATER BAY/REPULSE BAY");
  printf("<OPTION value=\"09B09\">FANLING CENTRE");
  printf("<OPTION value=\"07A07\">FO TAN/CUHK/RACECOURSE");
  printf("<OPTION value=\"06B06\">FUNG TAK/FUNG WONG");
  printf("<OPTION value=\"10E10\">HANG HAU");
  printf("<OPTION value=\"16D16\">HAPPY VALLEY");
  printf("<OPTION value=\"07H07\">HENG ON/KAM FUNG");
  printf("<OPTION value=\"05K05\">HIP HONG");
  printf("<OPTION value=\"15C15\">HKU/MID-LEVELS EAST");
  printf("<OPTION value=\"04B04\">HO MAN TIN");
  printf("<OPTION value=\"04E04\">HUNG HOM/WHAMPOA");
  printf("<OPTION value=\"08E08\">IND.EST./TAI MEI TUK");
  printf("<OPTION value=\"16G16\">JARDINE'S LOOKOUT");
  printf("<OPTION value=\"01B01\">JORDAN/YAU MA TEI");
  printf("<OPTION value=\"09D09\">KA FUK/YAN SHING");
  printf("<OPTION value=\"04D04\">KAI TAK");
  printf("<OPTION value=\"05C05\">KAI YIP/PING SHEK");
  printf("<OPTION value=\"14F14\">KAM TIN/PAT HEUNG");
  printf("<OPTION value=\"15A15\">KENNEDY TOWN/WEST POINT");
  printf("<OPTION value=\"06H06\">KING FU");
  printf("<OPTION value=\"04A04\">KLN. CITY/PRINCE EDWARD E");
  printf("<OPTION value=\"05B05\">KOWLOON BAY");
  printf("<OPTION value=\"04F04\">KOWLOON TONG");
  printf("<OPTION value=\"12D12\">KWAI HING/KWAI FONG");
  printf("<OPTION value=\"12I12\">KWAI SHING");
  printf("<OPTION value=\"07E07\">KWONG YUEN/PICTORIAL GDN.");
  printf("<OPTION value=\"09E09\">KWU TUNG");
  printf("<OPTION value=\"05A05\">KWUN TONG CENTRE");
  printf("<OPTION value=\"05I05\">LAGUNA CITY/KING TIN");
  printf("<OPTION value=\"12E12\">LAI KING/LAI YIU");
  printf("<OPTION value=\"05G05\">LAM TIN");
  printf("<OPTION value=\"07G07\">LEE ON/WU KAI SHA");
  printf("<OPTION value=\"11F11\">LEI MUK SHUE");
  printf("<OPTION value=\"13F13\">LEUNG KING/TIN KING");
  printf("<OPTION value=\"07B07\">LION ROCK TUNNEL ROAD");
  printf("<OPTION value=\"06E06\">LOK FU");
  printf("<OPTION value=\"05M05\">LOK WAH");
  printf("<OPTION value=\"09A09\">LUEN WO HUI");
  printf("<OPTION value=\"07F07\">MA ON SHAN TOWN CENTRE");
  printf("<OPTION value=\"03D03\">MEI FOO");
  printf("<OPTION value=\"01F01\">MONG KOK");
  printf("<OPTION value=\"18A18\">N PT./TIN HAU/FORTRESS HI");
  printf("<OPTION value=\"03B03\">NAM CHEONG");
  printf("<OPTION value=\"06J06\">NGAU CHI WAN/CHOI HUNG");
  printf("<OPTION value=\"05L05\">NGAU TAU KOK");
  printf("<OPTION value=\"02A02\">NORTH LANTAU & TUNG CHUNG");
  printf("<OPTION value=\"15E15\">PEAK");
  printf("<OPTION value=\"10B10\">PIK UK");
  printf("<OPTION value=\"14C14\">PING SHAN");
  printf("<OPTION value=\"17A17\">POK FU LAM/CHI FU");
  printf("<OPTION value=\"01D01\">PRINCE EDWARD WEST");
  printf("<OPTION value=\"18B18\">QUARRY BAY/TAI KOO");
  printf("<OPTION value=\"09L09\">QUEEN'S HILL");
  printf("<OPTION value=\"11E11\">RIVIERA GARDEN");
  printf("<OPTION value=\"11G11\">ROUTE TWISK/CHUEN LUNG");
  printf("<OPTION value=\"10A10\">SAI KUNG CENTRAL");
  printf("<OPTION value=\"15B15\">SAI YING PUN");
  printf("<OPTION value=\"13D13\">SAM SHING/GOLD COAST");
  printf("<OPTION value=\"06D06\">SAN PO KONG/TUNG TAU");
  printf("<OPTION value=\"14E14\">SAN TIN/FAIRVIEW PARK");
  printf("<OPTION value=\"05F05\">SAU MAU PING");
  printf("<OPTION value=\"09J09\">SHA TAU KOK");
  printf("<OPTION value=\"07D07\">SHA TIN TOWN CENTRE");
  printf("<OPTION value=\"03A03\">SHAM SHUI PO");
  printf("<OPTION value=\"14B14\">SHAP PAT HEUNG");
  printf("<OPTION value=\"08F08\">SHAP SZE HEUNG/SAI SHA RD");
  printf("<OPTION value=\"18C18\">SHAU KEI WAN");
  printf("<OPTION value=\"03F03\">SHEK KIP MEI");
  printf("<OPTION value=\"12F12\">SHEK LEI/ON YAM");
  printf("<OPTION value=\"11C11\">SHEK WAI KOK/CHEUNG SHAN");
  printf("<OPTION value=\"09H09\">SHEK WU HUI");
  printf("<OPTION value=\"10F10\">SHEUNG TAK/KWONG MING");
  printf("<OPTION value=\"11H11\">SHING MUN TUNNELS");
  printf("<OPTION value=\"05E05\">SHUN TIN EAST");
  printf("<OPTION value=\"05D05\">SHUN TIN WEST");
  printf("<OPTION value=\"13C13\">SIU HONG/LAM TEI");
  printf("<OPTION value=\"16E16\">SO KON PO");
  printf("<OPTION value=\"17C17\">SOUTH HORIZONS/AP LEI CHA");
  printf("<OPTION value=\"17E17\">STANLEY/SHEK O");
  printf("<OPTION value=\"16A16\">STUBBS ROAD");
  printf("<OPTION value=\"09K09\">TA KWU LING");
  printf("<OPTION value=\"16F16\">TAI HANG");
  printf("<OPTION value=\"13B13\">TAI HING/SHAN KING");
  printf("<OPTION value=\"01C01\">TAI KOK TSUI");
  printf("<OPTION value=\"14G14\">TAI LAM TUNNELS");
  printf("<OPTION value=\"08B08\">TAI PO CTR/FUSHIN/FUHENG");
  printf("<OPTION value=\"08A08\">TAI PO HUI");
  printf("<OPTION value=\"08C08\">TAI PO KAU");
  printf("<OPTION value=\"07C07\">TAI WAI");
  printf("<OPTION value=\"12C12\">TAI WO HAU/KWAI CHUNG EST");
  printf("<OPTION value=\"08D08\">TAI WO/TAIPOTAU/LAM TSUEN");
  printf("<OPTION value=\"09I09\">TIN PING");
  printf("<OPTION value=\"14D14\">TIN SHUI WAI/KINGSWOOD");
  printf("<OPTION value=\"11B11\">TING KAU/SHAM TSENG");
  printf("<OPTION value=\"04C04\">TO KWA WAN/MA TAU WAI");
  printf("<OPTION value=\"10D10\">TSEUNG KWAN O CENTRE");
  printf("<OPTION value=\"01A01\">TSIM SHA TSUI/STAR FERRY");
  printf("<OPTION value=\"12H12\">TSING YI EST/GREENFIELD G");
  printf("<OPTION value=\"09F09\">TSIU KENG");
  printf("<OPTION value=\"01E01\">TST E/HUNG HOM KCR");
  printf("<OPTION value=\"11A11\">TSUEN WAN CENTRE");
  printf("<OPTION value=\"10C10\">TSUI LAM/PO LAM");
  printf("<OPTION value=\"05J05\">TSUI PING");
  printf("<OPTION value=\"06G06\">TSZ WAN SHAN");
  printf("<OPTION value=\"13E13\">TUEN MUN PIER/SUN TM CTR.");
  printf("<OPTION value=\"13A13\">TUEN MUN TOWN CENTRE");
  printf("<OPTION value=\"09C09\">WAH MING/WAH SUM");
  printf("<OPTION value=\"16B16\">WAN CHAI");
  printf("<OPTION value=\"01G01\">WEST KOWLOON/KOWLOON STN.");
  printf("<OPTION value=\"06A06\">WONG TAI SIN");
  printf("<OPTION value=\"05H05\">YAU TONG");
  printf("<OPTION value=\"14A14\">YUEN LONG TOWN ");
  printf("</select>");
  printf("</p>");
  printf("</td>");
  printf("</tr>");
  printf("</table>");
  printf("</td>");
  printf("</tr>");
}

   function GenerateHTMLForm($formValues, $actionScript, $submitLabel) {
      if ($actionScript=="search.php") {
        printf("<FORM METHOD=\"get\" ACTION=\"%s\"><PRE>\n", $actionScript);
        printf("  Route no: <INPUT TYPE=text maxlength=5 NAME=route_no VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["route_no"] : "");
        printf("    Bound : <INPUT TYPE=radio NAME=bound VALUE=1>Forward <INPUT TYPE=radio NAME=bound VALUE=2>Backward
              <BR>\n", ($formValues) ? $formValues["bound"] : "");
        printf("<INPUT TYPE=\"HIDDEN\" name=\"stop_no\" value=\"1\">");
        printf("<INPUT TYPE=\"submit\" VALUE=\"%s\">", $submitLabel);
        printf("</PRE></FORM>");
      } elseif ($actionScript=="add.php") {
          printf("<FORM METHOD=\"get\" ACTION=\"%s\"><PRE>\n", $actionScript);
          printf("  Route no: <INPUT TYPE=text maxlength=5 NAME=route_no VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["route_no"] : "");
          printf("    Bound : <INPUT TYPE=radio NAME=bound VALUE=1>Forward <INPUT TYPE=radio NAME=bound VALUE=2>Backward
              <BR>\n", ($formValues) ? $formValues["bound"] : "");
          printf("Stop District:");
          printf("<select id=\"district\" name=\"district\" onChange=\"populate_data(this.form.stop_area,this.form.district.options[this.form.district.selectedIndex].value,this.form.district.options[this.form.district.selectedIndex].text)\">");
          printf("<OPTION selected value=\"all\">--- All Districts ---");
          printf("<OPTION value=\"15\">CENTRAL & WESTERN");
          printf("<OPTION value=\"18\">EASTERN H.K. ISLAND");
          printf("<OPTION value=\"02\">ISLANDS");
          printf("<OPTION value=\"04\">KOWLOON CITY");
          printf("<OPTION value=\"12\">KWAI TSING");
          printf("<OPTION value=\"05\">KWUN TONG");
          printf("<OPTION value=\"09\">NORTH N.T.");
          printf("<OPTION value=\"10\">SAI KUNG");
          printf("<OPTION value=\"07\">SHA TIN");
          printf("<OPTION value=\"03\">SHAM SHUI PO");
          printf("<OPTION value=\"17\">SOUTHERN H.K. ISLAND");
          printf("<OPTION value=\"08\">TAI PO");
          printf("<OPTION value=\"11\">TSUEN WAN");
          printf("<OPTION value=\"13\">TUEN MUN");
          printf("<OPTION value=\"16\">WAN CHAI");
          printf("<OPTION value=\"06\">WONG TAI SIN");
          printf("<OPTION value=\"01\">YAU TSIM MONG");
          printf("<OPTION value=\"14\">YUEN LONG");

          printf("</select>");
          printf("</p>");
          printf("<p> ");
          printf("Stop Area    :");
          printf("<select id=\"stop_area\" name=\"stop_area\">");
          printf("<OPTION selected value=\"all\">--- All Areas ---");
        printf("<OPTION value=\"17B17\">ABERDEEN/WONG CHUK HANG");
        printf("<OPTION value=\"02B02\">AIRPORT PASSENGER TERMINA");
        printf("<OPTION value=\"02C02\">AIRPORT SUPPORTING AREA");
        printf("<OPTION value=\"11D11\">ALLWAY/BELVEDERE GARDENS");
        printf("<OPTION value=\"16C16\">CAUSEWAY BAY");
        printf("<OPTION value=\"15D15\">CENTRAL/ADMIRALTY");
        printf("<OPTION value=\"18D18\">CHAI WAN/SIU SAI WAN");
        printf("<OPTION value=\"03E03\">CHAK ON/TAI HANG TUNG");
        printf("<OPTION value=\"02D02\">CHEK LAP KOK FERRY PIER");
        printf("<OPTION value=\"12A12\">CHEUNG CHING/CHEUNG HONG");
        printf("<OPTION value=\"12G12\">CHEUNG HANG");
        printf("<OPTION value=\"12B12\">CHEUNG ON/TSING YI AR STN");
        printf("<OPTION value=\"03C03\">CHEUNG SHA WAN");
        printf("<OPTION value=\"06I06\">CHOI WAN");
        printf("<OPTION value=\"09G09\">CHOI YUEN/TAI PING");
        printf("<OPTION value=\"06F06\">CHUK YUEN/TSUI CHUK");
        printf("<OPTION value=\"10G10\">CLEAR WATER BAY/HKUST");
        printf("<OPTION value=\"12J12\">CONTAINER TERMINAL");
        printf("<OPTION value=\"06C06\">DIAMOND HILL");
        printf("<OPTION value=\"17D17\">DP.WATER BAY/REPULSE BAY");
        printf("<OPTION value=\"09B09\">FANLING CENTRE");
        printf("<OPTION value=\"07A07\">FO TAN/CUHK/RACECOURSE");
        printf("<OPTION value=\"06B06\">FUNG TAK/FUNG WONG");
        printf("<OPTION value=\"10E10\">HANG HAU");
        printf("<OPTION value=\"16D16\">HAPPY VALLEY");
        printf("<OPTION value=\"07H07\">HENG ON/KAM FUNG");
        printf("<OPTION value=\"05K05\">HIP HONG");
        printf("<OPTION value=\"15C15\">HKU/MID-LEVELS EAST");
        printf("<OPTION value=\"04B04\">HO MAN TIN");
        printf("<OPTION value=\"04E04\">HUNG HOM/WHAMPOA");
        printf("<OPTION value=\"08E08\">IND.EST./TAI MEI TUK");
        printf("<OPTION value=\"16G16\">JARDINE'S LOOKOUT");
        printf("<OPTION value=\"01B01\">JORDAN/YAU MA TEI");
        printf("<OPTION value=\"09D09\">KA FUK/YAN SHING");
        printf("<OPTION value=\"04D04\">KAI TAK");
        printf("<OPTION value=\"05C05\">KAI YIP/PING SHEK");
        printf("<OPTION value=\"14F14\">KAM TIN/PAT HEUNG");
        printf("<OPTION value=\"15A15\">KENNEDY TOWN/WEST POINT");
        printf("<OPTION value=\"06H06\">KING FU");
        printf("<OPTION value=\"04A04\">KLN. CITY/PRINCE EDWARD E");
        printf("<OPTION value=\"05B05\">KOWLOON BAY");
        printf("<OPTION value=\"04F04\">KOWLOON TONG");
        printf("<OPTION value=\"12D12\">KWAI HING/KWAI FONG");
        printf("<OPTION value=\"12I12\">KWAI SHING");
        printf("<OPTION value=\"07E07\">KWONG YUEN/PICTORIAL GDN.");
        printf("<OPTION value=\"09E09\">KWU TUNG");
        printf("<OPTION value=\"05A05\">KWUN TONG CENTRE");
        printf("<OPTION value=\"05I05\">LAGUNA CITY/KING TIN");
        printf("<OPTION value=\"12E12\">LAI KING/LAI YIU");
        printf("<OPTION value=\"05G05\">LAM TIN");
        printf("<OPTION value=\"07G07\">LEE ON/WU KAI SHA");
        printf("<OPTION value=\"11F11\">LEI MUK SHUE");
        printf("<OPTION value=\"13F13\">LEUNG KING/TIN KING");
        printf("<OPTION value=\"07B07\">LION ROCK TUNNEL ROAD");
        printf("<OPTION value=\"06E06\">LOK FU");
        printf("<OPTION value=\"05M05\">LOK WAH");
        printf("<OPTION value=\"09A09\">LUEN WO HUI");
        printf("<OPTION value=\"07F07\">MA ON SHAN TOWN CENTRE");
        printf("<OPTION value=\"03D03\">MEI FOO");
        printf("<OPTION value=\"01F01\">MONG KOK");
        printf("<OPTION value=\"18A18\">N PT./TIN HAU/FORTRESS HI");
        printf("<OPTION value=\"03B03\">NAM CHEONG");
        printf("<OPTION value=\"06J06\">NGAU CHI WAN/CHOI HUNG");
        printf("<OPTION value=\"05L05\">NGAU TAU KOK");
        printf("<OPTION value=\"02A02\">NORTH LANTAU & TUNG CHUNG");
        printf("<OPTION value=\"15E15\">PEAK");
        printf("<OPTION value=\"10B10\">PIK UK");
        printf("<OPTION value=\"14C14\">PING SHAN");
        printf("<OPTION value=\"17A17\">POK FU LAM/CHI FU");
        printf("<OPTION value=\"01D01\">PRINCE EDWARD WEST");
        printf("<OPTION value=\"18B18\">QUARRY BAY/TAI KOO");
        printf("<OPTION value=\"09L09\">QUEEN'S HILL");
        printf("<OPTION value=\"11E11\">RIVIERA GARDEN");
        printf("<OPTION value=\"11G11\">ROUTE TWISK/CHUEN LUNG");
        printf("<OPTION value=\"10A10\">SAI KUNG CENTRAL");
        printf("<OPTION value=\"15B15\">SAI YING PUN");
        printf("<OPTION value=\"13D13\">SAM SHING/GOLD COAST");
        printf("<OPTION value=\"06D06\">SAN PO KONG/TUNG TAU");
        printf("<OPTION value=\"14E14\">SAN TIN/FAIRVIEW PARK");
        printf("<OPTION value=\"05F05\">SAU MAU PING");
        printf("<OPTION value=\"09J09\">SHA TAU KOK");
        printf("<OPTION value=\"07D07\">SHA TIN TOWN CENTRE");
        printf("<OPTION value=\"03A03\">SHAM SHUI PO");
        printf("<OPTION value=\"14B14\">SHAP PAT HEUNG");
        printf("<OPTION value=\"08F08\">SHAP SZE HEUNG/SAI SHA RD");
        printf("<OPTION value=\"18C18\">SHAU KEI WAN");
        printf("<OPTION value=\"03F03\">SHEK KIP MEI");
        printf("<OPTION value=\"12F12\">SHEK LEI/ON YAM");
        printf("<OPTION value=\"11C11\">SHEK WAI KOK/CHEUNG SHAN");
        printf("<OPTION value=\"09H09\">SHEK WU HUI");
        printf("<OPTION value=\"10F10\">SHEUNG TAK/KWONG MING");
        printf("<OPTION value=\"11H11\">SHING MUN TUNNELS");
        printf("<OPTION value=\"05E05\">SHUN TIN EAST");
        printf("<OPTION value=\"05D05\">SHUN TIN WEST");
        printf("<OPTION value=\"13C13\">SIU HONG/LAM TEI");
        printf("<OPTION value=\"16E16\">SO KON PO");
        printf("<OPTION value=\"17C17\">SOUTH HORIZONS/AP LEI CHA");
        printf("<OPTION value=\"17E17\">STANLEY/SHEK O");
        printf("<OPTION value=\"16A16\">STUBBS ROAD");
        printf("<OPTION value=\"09K09\">TA KWU LING");
        printf("<OPTION value=\"16F16\">TAI HANG");
        printf("<OPTION value=\"13B13\">TAI HING/SHAN KING");
        printf("<OPTION value=\"01C01\">TAI KOK TSUI");
        printf("<OPTION value=\"14G14\">TAI LAM TUNNELS");
        printf("<OPTION value=\"08B08\">TAI PO CTR/FUSHIN/FUHENG");
        printf("<OPTION value=\"08A08\">TAI PO HUI");
        printf("<OPTION value=\"08C08\">TAI PO KAU");
        printf("<OPTION value=\"07C07\">TAI WAI");
        printf("<OPTION value=\"12C12\">TAI WO HAU/KWAI CHUNG EST");
        printf("<OPTION value=\"08D08\">TAI WO/TAIPOTAU/LAM TSUEN");
        printf("<OPTION value=\"09I09\">TIN PING");
        printf("<OPTION value=\"14D14\">TIN SHUI WAI/KINGSWOOD");
        printf("<OPTION value=\"11B11\">TING KAU/SHAM TSENG");
        printf("<OPTION value=\"04C04\">TO KWA WAN/MA TAU WAI");
        printf("<OPTION value=\"10D10\">TSEUNG KWAN O CENTRE");
        printf("<OPTION value=\"01A01\">TSIM SHA TSUI/STAR FERRY");
        printf("<OPTION value=\"12H12\">TSING YI EST/GREENFIELD G");
        printf("<OPTION value=\"09F09\">TSIU KENG");
        printf("<OPTION value=\"01E01\">TST E/HUNG HOM KCR");
        printf("<OPTION value=\"11A11\">TSUEN WAN CENTRE");
        printf("<OPTION value=\"10C10\">TSUI LAM/PO LAM");
        printf("<OPTION value=\"05J05\">TSUI PING");
        printf("<OPTION value=\"06G06\">TSZ WAN SHAN");
        printf("<OPTION value=\"13E13\">TUEN MUN PIER/SUN TM CTR.");
        printf("<OPTION value=\"13A13\">TUEN MUN TOWN CENTRE");
        printf("<OPTION value=\"09C09\">WAH MING/WAH SUM");
        printf("<OPTION value=\"16B16\">WAN CHAI");
        printf("<OPTION value=\"01G01\">WEST KOWLOON/KOWLOON STN.");
        printf("<OPTION value=\"06A06\">WONG TAI SIN");
        printf("<OPTION value=\"05H05\">YAU TONG");
        printf("<OPTION value=\"14A14\">YUEN LONG TOWN ");
        printf("</select><BR><BR>\n");

          printf("Stop Desc : <INPUT TYPE=text maxlength=30 NAME=stop_desc VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["stop_desc"] : "");
          printf(" non fare : <INPUT TYPE=text maxlength=6 NAME=non_fare VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["non_fare"] : "");
          printf(" air fare : <INPUT TYPE=text maxlength=6 NAME=air_fare VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["air_fare"] : "");
          printf("Stop Desc2: <INPUT TYPE=text maxlength=6 NAME=stop_desc2 VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["stop_desc2"] : "");
          printf("Stop Time : <INPUT TYPE=text maxlength=6 NAME=time VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["time"] : "");
          printf("<INPUT TYPE=\"HIDDEN\" name=\"stop_no\" value=\"1\">");
          printf("<INPUT TYPE=\"submit\" VALUE=\"%s\">", $submitLabel);
          printf("</PRE></FORM>");
       }
   }

   function GenerateAddHTMLForm($formValues, $actionScript, $submitLabel) {
      printf("<FORM METHOD=\"get\" ACTION=\"%s\"><PRE>\n", $actionScript);
      printf("  Route no: <INPUT TYPE=text readonly maxlength=5 NAME=route_no VALUE=\"%s\">
              \n", ($formValues) ? $formValues["route_no"] : "");
      printf("    Bound : <INPUT TYPE=text readonly maxlength=1 NAME=bound VALUE=\"%s\">
              \n", ($formValues) ? $formValues["bound"] : "");
      printf("  Stop No : <INPUT TYPE=text readonly maxlength=2 NAME=stop_no VALUE=\"%s\">
              \n", ($formValues) ? $formValues["stop_no"] : "");
          printf("Stop District:");
          printf("<select id=\"district\" name=\"district\" onChange=\"populate_data(this.form.stop_area,this.form.district.options[this.form.district.selectedIndex].value,this.form.district.options[this.form.district.selectedIndex].text)\">");
          printf("<OPTION selected value=\"all\">--- All Districts ---");
          printf("<OPTION value=\"15\">CENTRAL & WESTERN");
          printf("<OPTION value=\"18\">EASTERN H.K. ISLAND");
          printf("<OPTION value=\"02\">ISLANDS");
          printf("<OPTION value=\"04\">KOWLOON CITY");
          printf("<OPTION value=\"12\">KWAI TSING");
          printf("<OPTION value=\"05\">KWUN TONG");
          printf("<OPTION value=\"09\">NORTH N.T.");
          printf("<OPTION value=\"10\">SAI KUNG");
          printf("<OPTION value=\"07\">SHA TIN");
          printf("<OPTION value=\"03\">SHAM SHUI PO");
          printf("<OPTION value=\"17\">SOUTHERN H.K. ISLAND");
          printf("<OPTION value=\"08\">TAI PO");
          printf("<OPTION value=\"11\">TSUEN WAN");
          printf("<OPTION value=\"13\">TUEN MUN");
          printf("<OPTION value=\"16\">WAN CHAI");
          printf("<OPTION value=\"06\">WONG TAI SIN");
          printf("<OPTION value=\"01\">YAU TSIM MONG");
          printf("<OPTION value=\"14\">YUEN LONG");

          printf("</select>");
          printf("</p>");
          printf("<p> ");
          printf("Stop Area    :");
          printf("<select id=\"stop_area\" name=\"stop_area\">");
          printf("<OPTION selected value=\"all\">--- All Areas ---");
        printf("<OPTION value=\"17B17\">ABERDEEN/WONG CHUK HANG");
        printf("<OPTION value=\"02B02\">AIRPORT PASSENGER TERMINA");
        printf("<OPTION value=\"02C02\">AIRPORT SUPPORTING AREA");
        printf("<OPTION value=\"11D11\">ALLWAY/BELVEDERE GARDENS");
        printf("<OPTION value=\"16C16\">CAUSEWAY BAY");
        printf("<OPTION value=\"15D15\">CENTRAL/ADMIRALTY");
        printf("<OPTION value=\"18D18\">CHAI WAN/SIU SAI WAN");
        printf("<OPTION value=\"03E03\">CHAK ON/TAI HANG TUNG");
        printf("<OPTION value=\"02D02\">CHEK LAP KOK FERRY PIER");
        printf("<OPTION value=\"12A12\">CHEUNG CHING/CHEUNG HONG");
        printf("<OPTION value=\"12G12\">CHEUNG HANG");
        printf("<OPTION value=\"12B12\">CHEUNG ON/TSING YI AR STN");
        printf("<OPTION value=\"03C03\">CHEUNG SHA WAN");
        printf("<OPTION value=\"06I06\">CHOI WAN");
        printf("<OPTION value=\"09G09\">CHOI YUEN/TAI PING");
        printf("<OPTION value=\"06F06\">CHUK YUEN/TSUI CHUK");
        printf("<OPTION value=\"10G10\">CLEAR WATER BAY/HKUST");
        printf("<OPTION value=\"12J12\">CONTAINER TERMINAL");
        printf("<OPTION value=\"06C06\">DIAMOND HILL");
        printf("<OPTION value=\"17D17\">DP.WATER BAY/REPULSE BAY");
        printf("<OPTION value=\"09B09\">FANLING CENTRE");
        printf("<OPTION value=\"07A07\">FO TAN/CUHK/RACECOURSE");
        printf("<OPTION value=\"06B06\">FUNG TAK/FUNG WONG");
        printf("<OPTION value=\"10E10\">HANG HAU");
        printf("<OPTION value=\"16D16\">HAPPY VALLEY");
        printf("<OPTION value=\"07H07\">HENG ON/KAM FUNG");
        printf("<OPTION value=\"05K05\">HIP HONG");
        printf("<OPTION value=\"15C15\">HKU/MID-LEVELS EAST");
        printf("<OPTION value=\"04B04\">HO MAN TIN");
        printf("<OPTION value=\"04E04\">HUNG HOM/WHAMPOA");
        printf("<OPTION value=\"08E08\">IND.EST./TAI MEI TUK");
        printf("<OPTION value=\"16G16\">JARDINE'S LOOKOUT");
        printf("<OPTION value=\"01B01\">JORDAN/YAU MA TEI");
        printf("<OPTION value=\"09D09\">KA FUK/YAN SHING");
        printf("<OPTION value=\"04D04\">KAI TAK");
        printf("<OPTION value=\"05C05\">KAI YIP/PING SHEK");
        printf("<OPTION value=\"14F14\">KAM TIN/PAT HEUNG");
        printf("<OPTION value=\"15A15\">KENNEDY TOWN/WEST POINT");
        printf("<OPTION value=\"06H06\">KING FU");
        printf("<OPTION value=\"04A04\">KLN. CITY/PRINCE EDWARD E");
        printf("<OPTION value=\"05B05\">KOWLOON BAY");
        printf("<OPTION value=\"04F04\">KOWLOON TONG");
        printf("<OPTION value=\"12D12\">KWAI HING/KWAI FONG");
        printf("<OPTION value=\"12I12\">KWAI SHING");
        printf("<OPTION value=\"07E07\">KWONG YUEN/PICTORIAL GDN.");
        printf("<OPTION value=\"09E09\">KWU TUNG");
        printf("<OPTION value=\"05A05\">KWUN TONG CENTRE");
        printf("<OPTION value=\"05I05\">LAGUNA CITY/KING TIN");
        printf("<OPTION value=\"12E12\">LAI KING/LAI YIU");
        printf("<OPTION value=\"05G05\">LAM TIN");
        printf("<OPTION value=\"07G07\">LEE ON/WU KAI SHA");
        printf("<OPTION value=\"11F11\">LEI MUK SHUE");
        printf("<OPTION value=\"13F13\">LEUNG KING/TIN KING");
        printf("<OPTION value=\"07B07\">LION ROCK TUNNEL ROAD");
        printf("<OPTION value=\"06E06\">LOK FU");
        printf("<OPTION value=\"05M05\">LOK WAH");
        printf("<OPTION value=\"09A09\">LUEN WO HUI");
        printf("<OPTION value=\"07F07\">MA ON SHAN TOWN CENTRE");
        printf("<OPTION value=\"03D03\">MEI FOO");
        printf("<OPTION value=\"01F01\">MONG KOK");
        printf("<OPTION value=\"18A18\">N PT./TIN HAU/FORTRESS HI");
        printf("<OPTION value=\"03B03\">NAM CHEONG");
        printf("<OPTION value=\"06J06\">NGAU CHI WAN/CHOI HUNG");
        printf("<OPTION value=\"05L05\">NGAU TAU KOK");
        printf("<OPTION value=\"02A02\">NORTH LANTAU & TUNG CHUNG");
        printf("<OPTION value=\"15E15\">PEAK");
        printf("<OPTION value=\"10B10\">PIK UK");
        printf("<OPTION value=\"14C14\">PING SHAN");
        printf("<OPTION value=\"17A17\">POK FU LAM/CHI FU");
        printf("<OPTION value=\"01D01\">PRINCE EDWARD WEST");
        printf("<OPTION value=\"18B18\">QUARRY BAY/TAI KOO");
        printf("<OPTION value=\"09L09\">QUEEN'S HILL");
        printf("<OPTION value=\"11E11\">RIVIERA GARDEN");
        printf("<OPTION value=\"11G11\">ROUTE TWISK/CHUEN LUNG");
        printf("<OPTION value=\"10A10\">SAI KUNG CENTRAL");
        printf("<OPTION value=\"15B15\">SAI YING PUN");
        printf("<OPTION value=\"13D13\">SAM SHING/GOLD COAST");
        printf("<OPTION value=\"06D06\">SAN PO KONG/TUNG TAU");
        printf("<OPTION value=\"14E14\">SAN TIN/FAIRVIEW PARK");
        printf("<OPTION value=\"05F05\">SAU MAU PING");
        printf("<OPTION value=\"09J09\">SHA TAU KOK");
        printf("<OPTION value=\"07D07\">SHA TIN TOWN CENTRE");
        printf("<OPTION value=\"03A03\">SHAM SHUI PO");
        printf("<OPTION value=\"14B14\">SHAP PAT HEUNG");
        printf("<OPTION value=\"08F08\">SHAP SZE HEUNG/SAI SHA RD");
        printf("<OPTION value=\"18C18\">SHAU KEI WAN");
        printf("<OPTION value=\"03F03\">SHEK KIP MEI");
        printf("<OPTION value=\"12F12\">SHEK LEI/ON YAM");
        printf("<OPTION value=\"11C11\">SHEK WAI KOK/CHEUNG SHAN");
        printf("<OPTION value=\"09H09\">SHEK WU HUI");
        printf("<OPTION value=\"10F10\">SHEUNG TAK/KWONG MING");
        printf("<OPTION value=\"11H11\">SHING MUN TUNNELS");
        printf("<OPTION value=\"05E05\">SHUN TIN EAST");
        printf("<OPTION value=\"05D05\">SHUN TIN WEST");
        printf("<OPTION value=\"13C13\">SIU HONG/LAM TEI");
        printf("<OPTION value=\"16E16\">SO KON PO");
        printf("<OPTION value=\"17C17\">SOUTH HORIZONS/AP LEI CHA");
        printf("<OPTION value=\"17E17\">STANLEY/SHEK O");
        printf("<OPTION value=\"16A16\">STUBBS ROAD");
        printf("<OPTION value=\"09K09\">TA KWU LING");
        printf("<OPTION value=\"16F16\">TAI HANG");
        printf("<OPTION value=\"13B13\">TAI HING/SHAN KING");
        printf("<OPTION value=\"01C01\">TAI KOK TSUI");
        printf("<OPTION value=\"14G14\">TAI LAM TUNNELS");
        printf("<OPTION value=\"08B08\">TAI PO CTR/FUSHIN/FUHENG");
        printf("<OPTION value=\"08A08\">TAI PO HUI");
        printf("<OPTION value=\"08C08\">TAI PO KAU");
        printf("<OPTION value=\"07C07\">TAI WAI");
        printf("<OPTION value=\"12C12\">TAI WO HAU/KWAI CHUNG EST");
        printf("<OPTION value=\"08D08\">TAI WO/TAIPOTAU/LAM TSUEN");
        printf("<OPTION value=\"09I09\">TIN PING");
        printf("<OPTION value=\"14D14\">TIN SHUI WAI/KINGSWOOD");
        printf("<OPTION value=\"11B11\">TING KAU/SHAM TSENG");
        printf("<OPTION value=\"04C04\">TO KWA WAN/MA TAU WAI");
        printf("<OPTION value=\"10D10\">TSEUNG KWAN O CENTRE");
        printf("<OPTION value=\"01A01\">TSIM SHA TSUI/STAR FERRY");
        printf("<OPTION value=\"12H12\">TSING YI EST/GREENFIELD G");
        printf("<OPTION value=\"09F09\">TSIU KENG");
        printf("<OPTION value=\"01E01\">TST E/HUNG HOM KCR");
        printf("<OPTION value=\"11A11\">TSUEN WAN CENTRE");
        printf("<OPTION value=\"10C10\">TSUI LAM/PO LAM");
        printf("<OPTION value=\"05J05\">TSUI PING");
        printf("<OPTION value=\"06G06\">TSZ WAN SHAN");
        printf("<OPTION value=\"13E13\">TUEN MUN PIER/SUN TM CTR.");
        printf("<OPTION value=\"13A13\">TUEN MUN TOWN CENTRE");
        printf("<OPTION value=\"09C09\">WAH MING/WAH SUM");
        printf("<OPTION value=\"16B16\">WAN CHAI");
        printf("<OPTION value=\"01G01\">WEST KOWLOON/KOWLOON STN.");
        printf("<OPTION value=\"06A06\">WONG TAI SIN");
        printf("<OPTION value=\"05H05\">YAU TONG");
        printf("<OPTION value=\"14A14\">YUEN LONG TOWN ");
        printf("</select><BR><BR>\n");
      printf(" Stop Desc: <INPUT TYPE=text maxlength=30 NAME=stop_desc VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["stop_desc"] : "");
      printf(" non fare : <INPUT TYPE=text maxlength=6 NAME=non_fare VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["non_fare"] : "");
      printf("  air fare: <INPUT TYPE=text maxlength=6 NAME=air_fare VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["air_fare"] : "");
      printf("Stop Desc2: <INPUT TYPE=text maxlength=6 NAME=stop_desc2 VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["stop_desc2"] : "");
      printf("Stop Time : <INPUT TYPE=text maxlength=6 NAME=time VALUE=\"%s\">
              <BR>\n", ($formValues) ? $formValues["time"] : "");
      printf("<INPUT TYPE=\"submit\" VALUE=\"%s\">", $submitLabel);
      printf("</PRE></FORM>");
   }


