<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {

  // Get form data
  $name = $_POST["name"];
  $email = $_POST["email"];
  $phone = $_POST["phone"];
  $age = $_POST["age"];
  $destination = $_POST["destination"];
  $departureDate = $_POST["departureDate"];
  $returnDate = $_POST["returnDate"];

  // Regular Expressions for form validation
  $nameRegex = "/^[A-Za-z\s]+$/";
  $emailRegex = "/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/";
  $phoneRegex = "/^\d{10}$/";
  $ageRegex = "/^\d+$/";

  // Validate form data
  $errors = [];

  if (empty($name)) {
    $errors[] = "Name is required.";
  } elseif (!preg_match($nameRegex, $name)) {
    $errors[] = "Enter valid Name";
  }

  if (empty($age)) {
    $errors[] = "Age is required.";
  } elseif (!preg_match($ageRegex, $age)) {
    $errors[] = "Enet valid Age.";
  }

  if (empty($email)) {
    $errors[] = "Email is required.";
  } elseif (!preg_match($emailRegex, $email)) {
    $errors[] = "Enter valid mail ID.";
  }

  if (empty($phone)) {
    $errors[] = "Phone is required.";
  } elseif (!preg_match($phoneRegex, $phone)) {
    $errors[] = "Enter valid Phone Number.";
  }

  if (empty($destination)) {
    $errors[] = "Destination is required.";
  }

  if (empty($departureDate)) {
    $errors[] = "Departure Date is required.";
  }

  if (empty($returnDate)) {
    $errors[] = "Return Date is required.";
  }

  if (empty($errors)) {
    echo "Booking is successful!";
  } else {
    // Display validation errors
    foreach ($errors as $error) {
      echo $error . "<br>";
    }
  }
}
?>
