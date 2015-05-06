<%-- 
    Document   : FastCash
    Created on : Apr 28, 2015, 2:52:52 PM
    Author     : NN5024428
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM</title>
        <link rel="stylesheet" type="text/css" href="/ATM/Views/ATMStyle1.css">
    </head>
    <body>
        <h1>Select a Fast Cash Amount or select Other Transactions</h1>
        <s:form action="getAmount">
            <table>
                <tr>
                    <td>
                        <s:submit value="$   20" name="amount"/>
                    </td>
                    <td>
                        <s:submit value="$   40" name="amount"/>
                    </td>
                    <td>
                        <s:submit value="$   60" name="amount"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:submit value="$   80" name="amount"/>
                    </td>
                    <td>
                        <s:submit value="$ 100" name="amount"/>
                    </td>
                    <td>
                        <s:submit value="$ 200" name="amount"/>
                    </td>
                </tr>

            </table>
        </s:form>           

        <s:form method="link">
            <table>
                <tr>
                    <td>
                        <s:submit value="Other Transactions" formaction="../../Views/WithdrawSelected"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:submit value="Cancel" formaction="../../Views/MainMenu.jsp"/>
                    </td>
                </tr>
            </table>
        </s:form>

    </body>
</html>
