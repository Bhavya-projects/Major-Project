<?php
$a=$_REQUEST["sname"];
$b=$_REQUEST["suname"];
$c=$_REQUEST["spassword"];
$d=$_REQUEST["course_name"];
$e=$_REQUEST["sphone"];
$f=$_REQUEST["semail"];
$g=$_REQUEST["sem"];


$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into student_details(student_name,user_name,password,class,phone,student_email_id,semester) values('$a','$b','$c','$d','$e','$f','$g')") or die("query error");
$res=array("status"=>"success");
 $res1=json_encode($res);   
   echo($res1);
   $result_query=@mysql_query("select * from student_details where user_name='$b' and password='$c'") or die("query error");
if(mysql_num_rows($result_query)>0) 
{
    $row=mysql_fetch_array($result_query);
	$x=$row["student_name"];
    $y=$row["user_name"];
    $z=$row["password"];
	mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into login_check(name,user_id,user_password,user_type) values('$x','$y','$z','student')") or die("query error");


}



?>