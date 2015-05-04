<%-- 
    Document   : Statement
    Created on : Apr 30, 2015, 9:44:54 AM
    Author     : NN5024428
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM</title>
    </head>
    <body>
        <header><h1>Mini Statement</h1></header>
        <p> Please Select a date range:</p>
        <form>
            
        
        <p>FROM:</p>
        <input type="date" lable="FromDate" required/>
        <p>TO:</p>
        <input type="date" lable="ToDate" required/>
        <s:submit value="Get Details" formaction="checkdate"/>
        </form>
    </body>
    <footer></footer>
</html>
