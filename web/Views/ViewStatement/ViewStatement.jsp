<!-- 
    Document   : ViewStatement
    Created on : Apr 30, 2015, 11:58:37 AM
    Author     : NN5024428
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM</title>
    </head>
    <body>
        <header><h1>Statement Details:</h1></header>
            <table id="ministatment">
                <thead>
                <td>
                    Balance
                </td>
                <td>
                    Date
                </td>
                <td>
                    Credit
                </td>
                <td>
                    Debit
                </td>
                </thead>
                <s:iterator>
                    <tr>
                        <td>
                            <s:property value="%{balance}"></s:property>
                        </td>
                        <td>
                            <s:property value="%{time}"></s:property>
                        </td>
                        <td>
                            <s:property value="%{creditamt}"></s:property>
                        </td>
                        <td>
                            <s:property value="%{debitamt}"></s:property>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        <s:form method="link">
            <s:submit formaction="/ATM/Views/MainMenu.jsp" value="Main Menu"/>
        </s:form>
    </body>
    <footer></footer>
</html>
