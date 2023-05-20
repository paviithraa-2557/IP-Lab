<!DOCTYPE html>
<html>
<head>
    <title>Flight Booking</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <?php
    session_start();
    // Database connection
    $con = mysqli_connect("localhost:3360","root","","test");
    $stmt = "select * from flights"; 
    $res = mysqli_query($con,$stmt); 

    echo '<h1>Flight Details</h1>'.'<table><tr>
    <th>Flight Number</th>
    <th>From</th>
    <th>To</th>
    <th>Tickets available</th>
    </tr>';

    if($res){
        while($row = mysqli_fetch_array($res))
        {
            echo        
            '<tr>'.
            '<td rowspan="1">'.$row["flightid"].'</td>'.
            '<td rowspan="1">'.$row["source"].'</td>'.
            '<td rowspan="1">'.$row["destination"].'</td>'.
            '<td rowspan="1">'.$row["tickets"].'</td>'.
            '</tr><br/>';
        }
        echo'</table>';

        mysqli_free_result($res);
        mysqli_close($con);
    }
    else{
        echo("<SCRIPT>window.alert('No tickets available');</SCRIPT>");
    }   
?>

<div>
    <h2> Enter Booking Information</h2>
    <form action="book.php" method="POST">

          <label for="source">From: </label>
            <select name="source" required>
                <option value="">Choose an option</option>
                <option value="London">London</option>
                <option value="Paris">Paris</option>
                <option value="New York">New York</option>
            </select><br>

            <label for="destination">Select Destination:</label>
            <select name="destination" required>
                <option value="">Choose an option</option>
                <option value="London">London</option>
                <option value="Paris">Paris</option>
                <option value="New York">New York</option>
            </select><br>

        <label for="tickets">Enter tickets: </label>
        <input type="number" name="tickets" min="1" max="5" required><br>
        <input type="submit">
    </form>
</div>
</body>
</html>