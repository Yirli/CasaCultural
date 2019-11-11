
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
<title>Registrar Usuario</title>
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
                
    <h2 class="modal-title">Registrar Usuarios</h2>
    <br>
  
    <%
            HttpSession miSession = request.getSession();
            Controlador cn = new Controlador();
          
     %>                    

                <form>
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" id="nombre" placeholder="Digite el nombre" name="nombre" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Primer Apellido:</label>
                    <input type="text" id="apellido1" placeholder="Digite el apellido" name="apellido1" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Segundo Apellido:</label>
                    <input type="text" id="apellido2" placeholder="Digite el apellido" name="apellido2" class="form-control size">
                </div>
                <div class="form-group">
                    <label id="cedulaLabel" for="id">Cédula:</label>
                    <input type="text" id="cedula" placeholder="Digite la cédula" name="cedula" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Correo:</label>
                    <input type="text" id="correo" placeholder="Digite el correo" name="correo" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Teléfono:</label>
                    <input type="text" id="telefono" placeholder="Digite el teléfono" name="telefono" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" id="username" placeholder="Digite el username" name="username" class="form-control size">
                </div>
                <div class="form-group">
                    <label>Contraseña:</label>
                    <input type="password" id="password" placeholder="Digite la contraseña" name="password" class="form-control size">
                </div>
                <label>Rol:</label>
                <select id="RolCombo" class="form-control size">
                        <%
                            ArrayList<Rol> a = cn.consultarRoles();
                            ;
                            for (int i=0; i<a.size(); i++){
                                System.out.println("consultar"+cn.consultarRoles().get(i).getDescription());
                               
                        %>
                        <option value=<%=i%> ><%=a.get(i).getDescription()%></option>
                        <%}%>
                    </select> 
                    <br>
                    <button id="registerBtn" onclick="addUser()">Registrar</button>
              </form>

                <script>
                function addUser(){

                    var e = document.getElementById("RolCombo");
                    var rol = e.options[e.selectedIndex].value;
                    console.log(rol);

                    $.ajax({
                        url: 'servletRegistrarUsuarios',
                        method: 'POST',
                        data: {rol:rol,nombre:$("#nombre").val(),apellido1:$("#apellido1").val(),apellido2:$("#apellido2").val(),correo:$("#correo").val(), telefono:$("#telefono").val(),cedula:$("#cedula").val(),username:$("#username").val(),password:$("#password").val()},
                        success: function(result) {
                            //location.reload();
                        },
                        error : function(jqXHR, exception){
                            console.log('Error occured!!');
                        }
                    });
                }
                
                
                
                </script>
                
</body>
</html>

