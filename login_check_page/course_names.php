<?php
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");
$result_query=mysql_query("select distinct course_name from add_class") or die("query error");

while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}

echo(json_encode($res));



?>