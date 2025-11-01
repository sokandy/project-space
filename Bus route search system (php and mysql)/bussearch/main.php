<?php

   // main.php

   require("common.php");


   if (!$choice) {
      GenerateHTMLHeader("Please click following buttons for maintain bus route");
      GenerateFrontPage();
      GoToClient();
   } else if ($choice == "Search Route") {
      GenerateHTMLHeader("Input search value: (Route No & Bound is need)");
      GenerateHTMLForm(0, "search.php", "Start Search");
   } else if ($choice == "Add Route") {
      GenerateHTMLHeader("Input new value: (Route No,Bound and Stop_area is need)");
      GenerateHTMLForm(0, "add.php", "Confirm Add");
   }

?>