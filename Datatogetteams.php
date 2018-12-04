
<?php
    $con = mysqli_connect("localhost", "id7231002_benist617", "cC112233", "id7231002_mydatabase");
 

	$query = "SELECT team FROM user  ";
	$result = mysqli_query($con , $query);

	$response = array();
 
    
    while($row = mysqli_fetch_array($result)){
         echo $row['team'].",";
    }   
?>


 