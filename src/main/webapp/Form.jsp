<!DOCTYPE html>
<html>
<head>
    <title>Flight Ticket Booking Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            background-image: url('https://images.unsplash.com/photo-1489720073458-5cc3c0f230d6');
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .booking-form-box {
            background: rgba(255, 255, 255, 0.8);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.3);
            max-width: 500px;
            width: 100%;
        }

        .booking-form {
            margin-top: 20px;
        }

        .radio-btn {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .radio-btn input[type="radio"] {
            display: none;
        }

        .radio-btn input[type="radio"] + span {
            padding: 10px 20px;
            margin: 0 10px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
        }

        .radio-btn input[type="radio"]:checked + span {
            background-color: #0056b3;
        }

        .booking-form label {
            margin-bottom: 10px;
            display: block;
        }

        .booking-form input[type="text"],
        .booking-form input[type="date"],
        .booking-form input[type="number"],
        .booking-form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .booking-form .input-grp {
            margin-bottom: 20px;
        }

        .booking-form .flight {
            width: 100%;
        }

        .btnn {
            color: #fff;
            text-decoration: none;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
<div class="booking-form-box">
    <div class="radio-btn">
        <input type="radio" class="btn" name="check" checked="checked" >
        <span>Roundtrip</span>
        <input type="radio" class="btn" name="check"><span>One Way</span>
        <input type="radio" class="btn" name="check"><span>Multi-city</span>
    </div>

    <div class="booking-form">
        <label>Flying From</label>
        <input type="text" class="form-control" placeholder="City of Airport">
        <label>Flying To</label>
        <input type="text" class="form-control" placeholder="City of Airport">
        <div class="input-grp">
            <label>Departing</label>
            <input type="date" class="form-control select-date">
        </div>
        <div class="input-grp">
            <label>Returning</label>
            <input type="date" class="form-control select-date">
        </div>
        <div class="input-grp">
            <label>Adults</label>
            <input type="number" class="form-control" value="1">
        </div>

        <div class="input-grp">
            <label>Children</label>
            <input type="number" class="form-control" value="0">
        </div>

        <div class="input-grp">
            <label>Travel class</label>
            <select class="custom-select">
                <option value="1">Economy class</option>
                <option value="2">Business class</option>
                <option value="2">Executive class</option>
            </select>
        </div>
        <div class="input-grp">
            <button type="button" class="btn btn-primary flight"><a href="detail.html" class="btnn">Book Flights</a></button>
        </div>
    </div>
</div>
</body>
</html>
