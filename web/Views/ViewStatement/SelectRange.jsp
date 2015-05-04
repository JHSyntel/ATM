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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM</title>
    </head>
    <body>
        <h1>Mini Statement</h1>
        <p> Please Select a date range:</p>
        <form>
            
        
        <p>FROM:</p>
        <input type="date" lable="FromDate" required/>
        <p>TO:</p>
        <input type="date" lable="ToDate" required/>
        <s:submit value="Get Details" formaction="checkdate"/>
        </form>
    </body>
</html>
