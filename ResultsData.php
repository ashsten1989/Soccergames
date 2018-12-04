
<?php
    $con = mysqli_connect("localhost", "id7231002_benist617", "cC112233", "id7231002_mydatabase");
 

	$query = "SELECT * FROM games ";
	$result = mysqli_query($con , $query);

	$response = array();
    
    while($row = mysqli_fetch_assoc($result))  
        {  
		array_push($response, [
			'teamA'   => $row['teamA'],
			'teamB' => $row['teamB'],
			'goalsA'   => $row['goalsA'],
			'goalsB' => $row['goalsB'],
			'Winner' => $row['Winner']
			
         ]);
	
 
			
        }
        
		echo json_encode(array('datafield' => $response));

?>

 




