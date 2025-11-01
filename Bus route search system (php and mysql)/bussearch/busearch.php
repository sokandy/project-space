<?php

// bussearch.php

require("common.php");
include('busconfig.php');

GenHeader();

Genresult();

Gensearcheader();

Gensearchwhere("txt2","#B50018","from");
Gensearchwhere("txt3","#F7DE9C","to");

Gensearchfooter();











