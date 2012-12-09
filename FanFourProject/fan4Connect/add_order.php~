<?php

header('Content-type: application/json');
/*
 * Following code will create a new order row in the AndroidOrders database
 */

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['confID']) && isset($_POST['phoneNumber']) && isset($_POST['street']) && 
	 isset($_POST['city']) && isset($_POST['state']) && isset($_POST['zipCode']) && 
	 isset($_POST['email']) && isset($_POST['paymentType']) && isset($_POST['creditCard']) && 
	 isset($_POST['discountCode']) && isset($_POST['myOrder'])) {

    // Connecting to mysql database
    $con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die('Error in add_order.php connection' . mysql_error());
    // Selecting database
    $db = mysql_select_db('AndroidOrders',$con) or die('Error in add_order.php database' . mysql_error());	
 
	 $confID = $_POST['confID'];
    $phoneNumber = $_POST['phoneNumber'];
    $street = $_POST['street'];
    $city = $_POST['city'];
    $state = $_POST['state'];
    $zipCode = $_POST['zipCode'];
    $email = $_POST['email'];
    $paymentType = $_POST['paymentType'];
    $creditCard = $_POST['creditCard'];
    $discountCode = $_POST['discountCode'];
    $myOrder = $_POST['myOrder'];
	 
    // mysql inserting a new row for the new order
    $result = mysql_query("INSERT INTO testOrder(confID, phoneNumber, street, city, state, zipCode, email, paymentType, creditCard, discountCode, myOrder) VALUES('$confID', '$phoneNumber', '$street', '$city', '$state', '$zipCode', '$email', '$paymentType', '$creditCard', '$discountCode', '$myOrder')",$con);
	    
 	 mysql_close($con);
	 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = 'Order successfully created.';

        echo json_encode($response);
    } 
    else {
        // failed to insert a new order row
        $response["success"] = 0;
        $response["message"] = 'An error occurred in the add_order.php query.';

        echo json_encode($response);
    }
} 
else {
    // at least one of the necessary fields is missing
    $response["success"] = 0;
    $response["message"] = 'Required field(s) is missing in add_order.php';

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