<?php


$a=$_REQUEST["uname"];
$b=$_REQUEST["password"];
$c=$_REQUEST["name"];

$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

$result_query=@mysql_query("select * from login_check where user_id='$a' and user_password='$b' and name='$c'") or die("query error");


if(mysql_num_rows($result_query)>0) 
{
    $row=mysql_fetch_array($result_query);
	$x=$row["user_type"];
    $y=$row["name"];

   $res=array("status"=>"success","utype"=>"$x","name"=>"$y");
   $res1=json_encode($res);   
   echo($res1);
}
else
{
   $res=array("status"=>"fail","utype"=>"null","name"=>"null");
   $res1=json_encode($res);   
   echo($res1);
}

/*$msg = file_get_contents('php://input');


$ar=json_decode($msg);
/*
$user=$ar->{'uname'};
$pass=$ar->{'password'};



include("myclass.php");
$user=new myclass();
$user->uname=$ar['uname'];
$user->password=$ar['password'];


$res=array("status"=>"","utype"=>"");





$con=@mysql_connect("localhost","root","") or die("connection error");

mysql_select_db("minor_project",$con) or die("database error");

$result_query=@mysql_query("select * from login_check where user_id='".$user->uname."'") or die("query error");
if(mysql_num_rows($result_query)==0)
{
	//echo("Wrong User Name");
}
else
{
	$row=mysql_fetch_array($result_query);
	if($row["user_password"]==$pass)
	{
		 if($row["user_type"]=="Admin")
		 {
               $res["status"]="success";
			   $res["utype"]="Admin";	

		 }
		else if($row["user_type"]=="Student")
		{
			   $res["status"]="success";
			   $res["utype"]="Student";	

	    }
		else if($row["user_type"]=="Teacher")
		{
			   $res["status"]="success";
			   $res["utype"]="Teacher";	

	    }
	}
	else
	{
		//echo("Wrong Password");
	}
}


$resjson=json_encode($res);
echo($resjson);


/*
if($user=="emp" && $pass=="e1")
{
   $res["status"]="success";
   $res["utype"]="employee";	
}


else if($user=="stud" && $pass=="s1")
{
   $res["status"]="success";
   $res["utype"]="student";	
}
else if($user=="admin" && $pass=="a1")
{
   $res["status"]="success";
   $res["utype"]="Administrator";	
}
else 
{
   $res["status"]="fail";
   $res["utype"]="fail";	
}


//$res=array("status"=>"pk","utype"=>"jain");
$resjson=json_encode($res);
echo($resjson);


//echo("hello");
*/
?>