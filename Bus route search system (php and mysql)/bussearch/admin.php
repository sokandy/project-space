<?php

require("adfunctions.php");


if (($form_user_id != 'admin') ||
    (!authenticateUser($form_user_id, $form_password))) {
   header("Location:http://$HTTP_HOST/$DOCROOT/admin_error.htm");
   exit();
} else{
   setcookie("cookie_user", $form_user_id);
   setcookie("cookie_passwd", $form_password);
   header("Location:http://$HTTP_HOST/$DOCROOT/main.php"); 
}
?>
