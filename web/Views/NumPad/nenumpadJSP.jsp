<%-- 
    Document   : nenumpadJSP
    Created on : May 4, 2015, 2:16:46 PM
    Author     : EH5024424
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="emptyCode();">

        <script type="text/javascript">
            function addCode(key) {
                var code = document.forms[0].code;
                if (code.value.length < 5) {
                    code.value = code.value + key;
                }
                if (code.value.length === 5) {
                    document.getElementById("message").style.display = "block";
                    setTimeout(submitForm, 1000);
                }
            }

            function submitForm() {
                document.forms[0].submit();
            }

            function emptyCode() {
                document.forms[0].code.value = "";
            }

            function nextPage() {
                window.location.replace("http://localhost:8084/ATM/index.html");
            }


        </script>


        <form action="index.html" method="get">
            <table id="keypad" cellpadding="5" cellspacing="3">
                <tr>
                    <td onclick="addCode('*');">1</td>
                    <td onclick="addCode('*');">2</td>
                    <td onclick="addCode('*');">3</td>
                </tr>
                <tr>
                    <td onclick="addCode('*');">4</td>
                    <td onclick="addCode('*');">5</td>
                    <td onclick="addCode('*');">6</td>
                </tr>
                <tr>
                    <td onclick="addCode('*');">7</td>
                    <td onclick="addCode('*');">8</td>
                    <td onclick="addCode('*');">9</td>
                </tr>
                <tr>
                    <td onclick="emptyCode()">Cancel</td>
                    <td onclick="addCode('*');">0</td>
                    <td onclick="nextPage()">OK</td>
                </tr>
            </table>
            <input type="text" name="code" value="" maxlength="4" class="display" readonly="readonly" />
            <p id="message">ACCESSING...</p>
        </form>
    </body>

</html>
