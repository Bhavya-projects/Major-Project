<?php
$a=$_REQUEST["sname"];
$con=@mysql_connect("localhost","root","") or die("connection error");

@mysql_select_db("minor_project",$con) or die("database error");
$result_query=mysql_query("select class,semester from student_details where student_name='$a'") or die("query error1");
if(mysql_num_rows($result_query)>0) 
{
    $row=mysql_fetch_array($result_query);
	$x=$row["class"];
    $y=$row["semester"];
	mysql_select_db("minor_project",$con) or die("database error");

$result_query1=@mysql_query("select teacher from add_class where semester='$y' and course_name='$x'") or die("query error");
while($row1=mysql_fetch_assoc($result_query1))
{
	$res[]=$row1;
}

echo(json_encode($res));

}

/*while($row=mysql_fetch_assoc($result_query))
{
	$res[]=$row;
}

echo(json_encode($res));*/



?>