<?php

header('Content-type: application/json');
/*
* Following code will list all the products
*/

// array for JSON response
$response = array();
// include db connect class
//require_once __DIR__ . '/db_connect.php';

// connecting to db
//$db = new DB_CONNECT();

//********************
$con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die(mysql_error());
$db = mysql_select_db('AndroidOrders',$con) or die(mysql_error()) or die(mysql_error());



//********************

// get all products from products table
$result = mysql_query("SELECT *FROM reviewTable",$con) or die(mysql_error());
//mysql_close($con);



// check for empty result
if (mysql_num_rows($result) > 0) {
   // looping through all results
   // products node
   $response["reviews"] = array();
    
   while ($row = mysql_fetch_array($result)) {
      // temp user array
      $review = array();
      $review["pizzaType"] = $row["pizzaType"];
      $review["comment"] = $row["comment"];
	   $review["rating"] = $row["rating"];
		$review["timestamp"] = $row["timestamp"];

      // push single product into final response array
      array_push($response["reviews"], $review);
   }
   // success
   $response["success"] = 1;

   // echoing JSON response
   echo json_encode($response);
} else {
   // no products found
   $response["success"] = 0;
   $response["message"] = "No products found";

   // echo no users JSON
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
