<%-- 
    Document   : DepositSuccess
    Created on : Apr 24, 2015, 10:06:38 AM
    Author     : EH5024424
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank of Kyle ATM</title>
    </head>
    <body>
        <h1>Success</h1>
        <div>
            Your deposit completed successfully.<br>
            <%
                SessionMap sm = (SessionMap)ActionContext.getContext().getSession();
                Double bal = (Double)sm.get("balance");
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String curr = formatter.format(bal);
            %>
            Your new account balance is <%= curr %>.<br>
            Would you like to perform another transaction?<br>
            Yes(main menu)/No(quit)
        </div>
    </body>
</html>
