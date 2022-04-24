<?php
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");
$result_query=mysql_query("select distinct teacher_name from teachers_details") or die("query error");
/*
if(mysql_num_rows($result_query)>0) 
{
	$noofrows=@mysql_num_rows($result_query);

	for($i=1;$i<=$noofrows;$i++)
    {
    $row=mysql_fetch_arr($result_query);

	//$x=$row["teacher_name"];
    //$res=array("teacher_names"=>"$x");
	$res1[]=$row;
    //$res2=json_encode($res1);   
    //echo($res2);
	echo(json_encode($res1));
	}
}
*/
while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}
//print_r($res);
//print("<br>");
echo(json_encode($res));



?>