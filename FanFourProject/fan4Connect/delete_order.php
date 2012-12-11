<?php

header('Content-type: application/json');

/*
* Following code will delete an order from table
* An order is identified by confirmation ID (confID)
*/

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['confID'])) {
	$confID = $_POST['confID'];

   // Connecting to mysql database
	$con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die('Error in delete_order.php connection' . mysql_error());
   // Selecting database
	$db = mysql_select_db('AndroidOrders',$con) or die('Error in delete_order.php database' . mysql_error());
   
   // mysql deleting a row
	$result = mysql_query("DELETE FROM testOrder WHERE `confID` = \"$confID\"",$con);
    
   
	// check if row deleted or not
	if (mysql_affected_rows() > 0) {
		// successfully deleted
		$response['success'] = 1;
		$response['message'] = 'Order successfully deleted';

		// echoing JSON response
		echo json_encode($response);
	} 
	else {
		// no product found
		$response['success'] = 0;
		$response['message'] = 'No order found';

		// echo no users JSON
		echo json_encode($response);
	}
} 
else {
	// required field is missing
	$response['success'] = 0;
	$response['message'] = 'Confirmation ID is missing';

	// echoing JSON response
	echo json_encode($response);
}
mysql_close($con);

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