<?php

header('Content-type: application/json');
/*
 * Following code will get single order
 * An order is identified by Confirmation ID (confID)
 */
 
// array for JSON response
$response = array();

// Connecting to mysql database
$con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die('Error in get_order.php connection' . mysql_error());
// Selecting database
$db = mysql_select_db('AndroidOrders',$con) or die('Error in get_order.php database' . mysql_error());

// check for post data
if (isset($_GET['confID'])) {
    $confID = $_GET['confID'];
		
	
    // get an order from testOrder table
    $result = mysql_query("SELECT * FROM testOrder WHERE `confID` = \"$confID\"",$con);	
    	 
	 mysql_close($con);	 
	 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $orderr = array();
            $orderr['confID'] = $result['confID'];
            $orderr['phoneNumber'] = $result['phoneNumber'];
				$orderr['street'] = $result['street'];
				$orderr['city'] = $result['city'];
				$orderr['state'] = $result['state'];
				$orderr['zipCode'] = $result['zipCode'];
				$orderr['email'] = $result['email'];
				$orderr['paymentType'] = $result['paymentType'];
				$orderr['creditCard'] = $result['creditCard'];
				$orderr['discountCode'] = $result['discountCode'];
				$orderr['myOrder'] = $result['myOrder'];
				$orderr['timestamp'] = $result['timestamp'];
           
            // success
            $response['success'] = 1;

            // user node
            $response['orderr'] = array();

            array_push($response['orderr'], $orderr);

            // echoing JSON response
            echo json_encode($response);
        } 
        else {
            // no product found
            $response['success'] = 0;
            $response['message'] = 'empty response in get_order.php';

            // echo no users JSON
            echo json_encode($response);
        }
    } 
    else {
        // no product found
        $response['success'] = 0;
        $response['message'] = 'No order match found in get_order.php';

        // echo no users JSON
        echo json_encode($response);
    }
} 
else {
    // confirmation ID is not set
    $response['success'] = 0;
    $response['message'] = 'No confirmation ID in get_order.php';

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