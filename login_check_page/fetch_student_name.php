<?php
$a=$_REQUEST["semester"];
$b=$_REQUEST["course_name"];
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");
$result_query=mysql_query("select student_name from student_details where semester='$a' and class='$b'") or die("query error");

while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}

echo(json_encode($res));



?>