<?php
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");

$result_query1=@mysql_query("select distinct teacher_name from teachers_details") or die("query error");
while($row1=mysql_fetch_assoc($result_query1))
{
	$res[]=$row1;
}

echo(json_encode($res));


/*while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}

echo(json_encode($res));*/



?>