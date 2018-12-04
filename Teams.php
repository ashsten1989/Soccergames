
<?php
    $connct = mysqli_connect("localhost", "id7231002_benist617", "cC112233", "id7231002_mydatabase");
 
    $teamA = $_POST["teamA"];
    $teamB = $_POST["teamB"];
    $goalsA = $_POST["goalsA"];
    $goalsB = $_POST["goalsB"];
    $Winner = $_POST["Winner"];
     
	 $statement = mysqli_prepare($connct, "INSERT INTO games(teamA,teamB,goalsA,goalsB,Winner) VALUES (?,?,?,?,?)");
	 mysqli_stmt_bind_param($statement, "ssiis", $teamA,$teamB,$goalsA,$goalsB,$Winner);
	 mysqli_stmt_execute($statement);
     mysqli_stmt_close($statement);    
	
	  $statement = array();
	   
	   
	
?>




