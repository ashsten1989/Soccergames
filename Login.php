<?php
    $con = mysqli_connect("localhost", "id7231002_benist617", "cC112233", "id7231002_mydatabase");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $username, $password, $age, $team, $rule, $hours, $field );
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true; 
        $response["field"] = $field;
		$response["team"] = $team;
        $response["rule"] = $rule;
		$response["hours"] = $hours;
        $response["age"] = $age;
        $response["username"] = $username;
        $response["password"] = $password;
    }
    
    echo json_encode($response);
?>