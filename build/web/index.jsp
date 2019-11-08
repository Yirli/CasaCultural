<%-- 
    Document   : login
    Created on : Oct 30, 2019, 5:38:37 PM
    Author     : yir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link href="assets/css/login.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

                <%-- esto es una declaración de JSP --%>
                

        
                <%-- scriplet de JSP, para poner puro codigo Java --%>
                <% 
                    String mensaje;
                    HttpSession miSession = request.getSession();
                    mensaje="<p>"+(String) miSession.getAttribute("mensaje")+"</p>";
                    //miSession.invalidate();
                    
                %>
                
    
    <div id="page-container">
        <div class="modal-dialog modal-login">
            <%=mensaje%>
            <div class="modal-content">
                
                <div class="modal-header">              
                    <h4 class="modal-title">Iniciar Sesión</h4>
                </div>
                <div class="modal-body">
                    <form name="formLogin" method="post" action="servletLogin">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control" name="username" placeholder="Username" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" value="Login" class="btn btn-primary btn-block btn-lg" name="loginBtn">Ingresar</button>
                        </div>
                        <p class="hint-text"><a href="#">¿Olvidó contraseña?</a></p>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="footer">
            <img id="logotec"src="assets/img/logotec.png">
        </div>
    </div>

    
</body>
</html>                            