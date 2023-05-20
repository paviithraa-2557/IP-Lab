<!DOCTYPE html>
<html>
<head>
    <title>Book Tickets</title>
</head>

<body>
    <?php
    session_start();

    $source = $_POST['source'];
    $destination = $_POST['destination'];
    $tickets = intval($_POST['tickets']);

    $con = mysqli_connect("localhost:3360", "root", "", "test");
    if (!$con) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $stmt = "SELECT * FROM flights WHERE source = '$source' AND destination = '$destination'";
    $res = mysqli_query($con, $stmt);
    $row = mysqli_fetch_array($res);

    echo '<center><h1>Flight Details</h1></center>';

    if ($row) {
        $count = intval($row['tickets']);
        $src = $row['source'];
        $dest = $row['destination'];

        if ($tickets > $count) {
            echo "<script>window.alert('Sorry!! No tickets available');</script>";
        } else {
            $count = $count - $tickets;
            $stmt2 = "UPDATE flights SET tickets = '$count' WHERE source = '$src' AND destination = '$dest'";
            $res2 = mysqli_query($con, $stmt2);

            if ($res2) {
                echo "<script>window.alert('Your booking is successful!!');
                window.location.href='main.php';</script>";
            }
        }

        mysqli_free_result($res);
        mysqli_close($con);
    } else {
        echo "<script>window.alert('Sorry no flights available!!');</script>";
    }
    ?>
</body>
</html>
