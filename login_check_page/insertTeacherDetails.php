<?php
$a=$_REQUEST["tname"];
$b=$_REQUEST["tuname"];
$c=$_REQUEST["tpassword"];
$d=$_REQUEST["tmno"];
$e=$_REQUEST["temail"];
$f=$_REQUEST["thq"];
$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into teachers_details(teacher_name,user_name,password,teacher_mobileno,teacher_emailid,teacher_highestqualification) values('$a','$b','$c','$d','$e','$f')") or die("query error");
$res=array("status"=>"success");
 $res1=json_encode($res);   
   echo($res1);
$result_query=@mysql_query("select * from teachers_details where user_name='$b' and password='$c'") or die("query error");
if(mysql_num_rows($result_query)>0) 
{
    $row=mysql_fetch_array($result_query);
	$x=$row["teacher_name"];
    $y=$row["user_name"];
    $z=$row["password"];
	mysql_select_db("minor_project",$con) or die("database error");

@mysql_query("insert into login_check(name,user_id,user_password,user_type) values('$x','$y','$z','teacher')") or die("query error");


}


?>