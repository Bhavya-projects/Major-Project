<?php
$a=$_REQUEST["t_name"];
$b=$_REQUEST["fromdate"];
$c=$_REQUEST["todate"];
$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

$result_query=@mysql_query("select ratings from insertfeedback where teacher_name='$a' and date BETWEEN '$b' AND '$c'") or die("query error");
$noofrows=mysql_num_rows($result_query);
   $sum=0;
   $start=0;


for($i=$start;$i<$noofrows;$i++)
{
	$row=@mysql_fetch_row($result_query);
	//$sum=$sum+$row[$i];
	$sum+=$row[$i++];
	$start++;
	
}
echo($sum);

	$rating=$sum/$noofrows;

$res=array("status"=>"$rating");
 $res1=json_encode($res);   
   echo($res1);


?>