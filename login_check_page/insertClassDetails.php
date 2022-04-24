<?php
$a=$_REQUEST["course_name"];
$b=$_REQUEST["semester"];
$c=$_REQUEST["teacher"];
$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into add_class(course_name,semester,teacher) values('$a','$b','$c')") or die("query error");
$res=array("status"=>"success");
 $res1=json_encode($res);   
   echo($res1);


?>