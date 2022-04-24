<?php
$a=$_REQUEST["t_name"];
$b=$_REQUEST["ratings"];
$c=$_REQUEST["comment"];
$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into insertfeedback(teacher_name,ratings,comment,date) values('$a','$b','$c',now())") or die("query error");
$res=array("status"=>"success");
 $res1=json_encode($res);   
   echo($res1);


?>