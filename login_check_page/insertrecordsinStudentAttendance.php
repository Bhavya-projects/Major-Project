<?php
$a=$_REQUEST["fromdate"];
$b=$_REQUEST["todate"];
$c=$_REQUEST["s_name"];

$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

$result_query1=@mysql_query("select * from student_attendance where
date between '$a' and '$b' and s_name='$c'") or die("query error1");
$x=mysql_num_rows($result_query1);

$result_query2=@mysql_query("select * from student_attendance where date between '$a' and '$b' and s_name='$c' and attendance='present'") or die("query error2");
$y=mysql_num_rows($result_query2);

$res=array("total_classes"=>"$x","attend_classes"=>"$y");
   $res1=json_encode($res);   
   echo($res1);


?>
