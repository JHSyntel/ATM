<%-- 
    Document   : FastCase
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
    </head>
    <body>
        <div>PIN Entry and Fast Cash</div>
        <div>Please Enter Your Pin:</div>                
        <input type="text" required/>
        
        <div>Select a Fast Cash Amount or select Other Transactions</div>
        <s:form>
        <table>
            <tr>
                <td>
                    <s:submit value="$   20" formaction="fast20"/>
                </td>
                <td>
                    <s:submit value="$   40" formaction="fast40"/>
                </td>
                <td>
                    <s:submit value="$   60" formaction="fast60"/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:submit value="$   80" formaction="fast80"/>
                </td>
                <td>
                    <s:submit value="$ 100" formaction="fast100"/>
                </td>
                <td>
                    <s:submit value="$ 200" formaction="fast200"/>
                </td>
            </tr>
            
        </table>
        </s:form>           
        
        <s:form method="link">
        <table>
            <tr>
                <td>
                    <s:submit value="Other Transactions" formaction=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:submit value="Cancel" formaction="../../index.jsp"/>
                </td>
            </tr>
        </table>
        </s:form>
        
    </body>
</html>
