<%-- 
    Document   : WithdrawalSuccess
    Created on : Apr 24, 2015, 10:18:16 AM
    Author     : EH5024424
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ATMStyle1.css">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <header><h1>Success</h1></header>
        <div>
            Your withdrawal completed successfully.<br>
            <%
                SessionMap sm = (SessionMap)ActionContext.getContext().getSession();
                Double bal = (Double)sm.get("balance");
                DecimalFormat format = new DecimalFormat("$#,##0.00;-$#,##0.00");
                String curr = format.format(bal);
            %>
            Your new account balance is <%= curr %>.<br>
            Would you like to perform another transaction?<br>
            <form method="link">
                <input type="submit" value="Yes" formaction="/ATM/Views/MainMenu.jsp"/>
                <input type="submit" value="No" formaction="SignoutAct"/>
            </form>
        </div>
    </body>
    <footer></footer>
</html>
