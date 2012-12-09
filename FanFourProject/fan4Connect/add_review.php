<?php

header('Content-type: application/json');
/*
 * Following code will create a new review row
 */

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['pizzaType']) && isset($_POST['pizzaRating']) && isset($_POST['comment'])) {	    
    
	// Connecting to mysql database
   $con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die('Error in add_review.php connection' . mysql_error());
   // Selecting database
   $db = mysql_select_db('AndroidOrders',$con) or die('Error in add_review.php database' . mysql_error());

	$pizzaType= $_POST['pizzaType'];
   $pizzaRating = $_POST['pizzaRating'];
   $comment = $_POST['comment'];
    
   // mysql inserting a new row for the new review
   $result = mysql_query("INSERT INTO reviewTable(pizzaType, comment, rating) VALUES('$pizzaType', '$comment', '$pizzaRating')",$con);
	   
 	mysql_close($con);
	
	//echo $result; 
	 
   // check if row inserted or not
   if ($result) {
   	// successfully inserted into database
      $response["success"] = 1;
      $response["message"] = 'Review successfully created.';

      echo json_encode($response);
	} 
	else {
   	// failed to insert a new review row
      $response["success"] = 0;
      $response["message"] = 'An error occurred in the add_review.php query.';

      echo json_encode($response);
	}
} 
else {
   // at least one of the necessary fields is missing
   $response["success"] = 0;
   $response["message"] = 'Required field(s) is missing in add_review.php';

   // echoing JSON response
   echo json_encode($response);
}

//downloaded json_encode function
function json_encode($data) {
		switch ($type = gettype($data)) {
            case 'NULL':
                return 'null';
            case 'boolean':
                return ($data ? 'true' : 'false');
            case 'integer':
            case 'double':
            case 'float':
                return $data;
            case 'string':
                return "'" . addslashes($data) . "'";
            case 'object':
                $data = get_object_vars($data);
            case 'array':
                $output_index_count = 0;
                $output_indexed = array();
                $output_associative = array();
                foreach ($data as $key => $value) {
                    $output_indexed[] = json_encode($value);
                    $output_associative[] = json_encode($key) . ':' . json_encode($value);
                    if ($output_index_count !== NULL && $output_index_count++ !== $key) {
                        $output_index_count = NULL;
                    }
                }
                if ($output_index_count !== NULL) {
                    return '[' . implode(',', $output_indexed) . ']';
                } else {
                    return '{' . implode(',', $output_associative) . '}';
                }
            default:
                return ''; // Not supported
        }
    }
?>