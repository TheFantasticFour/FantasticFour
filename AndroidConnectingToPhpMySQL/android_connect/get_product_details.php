<?php

header('Content-type: application/json');
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
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



// check for post data
if (isset($_GET["pid"])) {
    $pid = $_GET['pid'];

    // get a product from products table
    $result = mysql_query("SELECT *FROM products WHERE pid = $pid",$con);
	 mysql_close($con);	 
	 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $product = array();
            $product["pid"] = $result["pid"];
            $product["name"] = $result["name"];
            $product["price"] = $result["price"];
            $product["description"] = $result["description"];
            $product["created_at"] = $result["created_at"];
            $product["updated_at"] = $result["updated_at"];
            // success
            $response["success"] = 1;

            // user node
            $response["product"] = array();

            array_push($response["product"], $product);

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";

        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}

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