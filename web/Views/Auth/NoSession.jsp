<%-- 
    Document   : NotAuthorized
    Created on : May 1, 2015, 2:24:58 PM
    Author     : JH5024430
--%>

<%@page import="com.syntelinc.BOK.ATM.auth.Authentication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>No user session!</h1>
        <form>
            <input type="submit" value="Back" formaction="SignoutAct"/>
        </form>
    </body>
</html>
