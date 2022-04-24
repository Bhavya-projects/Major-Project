<?php
$a=$_REQUEST["name"];
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");
$result_query=mysql_query("select semester from add_class where teacher='$a'") or die("query error");

while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}

echo(json_encode($res));



?>