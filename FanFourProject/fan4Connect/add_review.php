<?php

header('Content-type: application/json');
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['pizzaType']) && isset($_POST['pizzaRating']) && isset($_POST['comment'])) {	    
    $pizzaType= $_POST['pizzaType'];
    $pizzaRating = $_POST['pizzaRating'];
    $comment = $_POST['comment'];

	 
    // include db connect class
    //require_once __DIR__ . '/db_connect.php';
	 //require_once('http://www.users.csbsju.edu/~pghardy/android_connect/db_connect.php');

	 //print("HERE?");

    // connecting to db
    //$db = new DB_CONNECT;
	 //*************************
	 // import database connection variables
        //require_once __DIR__ . '/db_config.php';
        //require_once('http://www.users.csbsju.edu/~pghardy/android_connect/db_config.php');
        // Connecting to mysql database
        $con = mysql_connect('devsrv.cs.csbsju.edu', 'fantastic4', 'androidfan4') or die(mysql_error());
        // Selecing database
        $db = mysql_select_db('AndroidOrders',$con) or die(mysql_error()) or die(mysql_error());
        //mysql_close();

	 
	 //*************************    
 
 	 $pizzaType= $_POST['pizzaType'];
    $pizzaRating = $_POST['pizzaRating'];
    $comment = $_POST['comment'];
    
    // mysql inserting a new row
    //$query = "INSERT INTO products(name, price, description) VALUES(" . $name . ", " . $price . ", " . $description . ")";
    $result = mysql_query("INSERT INTO reviewTable(pizzaType, comment, rating) VALUES('$pizzaType', '$comment', '$pizzaRating')",$con);
	    
    //$result = mysql_query($query, $link_identifier = null););
 	 mysql_close($con);
	 
	 //echo $result; 
	 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Product successfully created.";

        // echoing JSON response
        //echo "WHAT?1";
        echo json_encode($response);
        //echo "WHAT?2";
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
        
        // echoing JSON response
		  //echo "WHAT?3";
        echo json_encode($response);
        //echo "WHAT?4";
    }
} else {
	 //echo "ELSEELSE";
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
    //echo "WHAT?";
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