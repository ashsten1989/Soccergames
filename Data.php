
<?php
    $con = mysqli_connect("localhost", "id7231002_benist617", "cC112233", "id7231002_mydatabase");
 
     $username = $_POST["field"];

	$query = "SELECT username,hours FROM user WHERE field = '{$_POST['field']}' ";
	$result = mysqli_query($con , $query);

	$response = array();
    
    while($row = mysqli_fetch_assoc($result))  
        {  
		array_push($response, [
			'username'   => $row['username'],
			'hours' => $row['hours']
         ]);
	
 
			
        }
        
		echo json_encode(array('datafield' => $response));

?>

 




