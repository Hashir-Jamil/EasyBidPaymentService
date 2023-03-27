Please enter your credit card details below:

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<style>
    form{
        background-color: lavenderblush;
        width: 500px;
        height: 500px;
        border-style: double;
        border-color: blue;
        padding: 10px;
    }
</style>

<div>
    <form action="/creditCard" method="post">
        <div>Card Holder Name: <input type="text" name="cardName" value=""> </div>
        <div>Credit Card Number: <input type="text" name="cardnumber" value=""> </div>
        <div>CVC: <input type="text" name="cvc" value=""> </div>
        <div>Address: <input type="text" name="address" value=""> </div>
        <div>Phone Number: <input type="text" name="phoneNumber" value=""> </div>
        <div><input type="submit" value="Submit"> </div>
        <div><input type="button" value="Back"> </div>
    </form>
</div>