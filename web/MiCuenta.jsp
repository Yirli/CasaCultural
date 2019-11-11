
<%@page import="controller.UsuarioActual"%>
<%@page import="model.Usuario"%>
<%@page import="model.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controlador" %>
<%@page import="model.Profesor" %>

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mi Cuenta</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/catalogs.css">
<link href="assets/css/login.css" rel="stylesheet">
<link href="assets/css/forms.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/css/welcome.js"></script>


<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100&display=swap" rel="stylesheet">


    <script>
   $(document).ready(function(){
        $('#nav-placeholder').load('navbar.jsp');
   });
    </script>

</head>
<body>

    
    <div id="nav-placeholder">
    </div>
    <br>
    <br>
    <br>
    <br>
                
    <h2 class="modal-title">Mi Cuenta</h2>
    <br>
  
    <%
           // HttpSession miSession = request.getSession();
            Controlador cn = new Controlador();
            UsuarioActual usrConectado = new UsuarioActual();
            Usuario us = cn.consultarUnUsuario(usrConectado.getInstance().getId());
     %>                    

                <div class="form-group">
                    <label>Nombre:</label>
                    <label id="nombre" name="nombre" class="size"> <%= us.getName()%> </label>
                </div>
                <div class="form-group">
                    <label>Primer Apellido:</label>
                    <label id="apellido1" name="apellido1" class="size"> <%=us.getApellido1()%> </label>
                </div>
                <div class="form-group">
                    <label>Segundo Apellido:</label>
                    <label id="apellido2" name="apellido2" class="size"> <%=us.getApellido2()%> </label>
                </div>
                <div class="form-group">
                    <label>Correo:</label>
                    <label id="correo" name="correo" class="size"> <%=us.getEmail()%> </label>
                </div>
                <div class="form-group">
                    <label>Teléfono:</label>
                    <label id="telefono" name="telefono" class="size"> <%=us.getPhone()%> </label>
                </div>
                <div class="form-group">
                    <label>Username:</label>
                    <label id="username" name="username" class="size"> <%=us.getUsername()%> </label>
                </div>
                <div class="form-group">
                    <label>Rol:</label>
                    <label id="rol" name="rol" class="size"> <%=us.getRol().getDescription()%> </label>
                </div>

                    <br>


    
                
</body>
</html>

