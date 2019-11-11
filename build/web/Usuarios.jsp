
<%@page import="model.Rol"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controlador" %>
<%@page import="model.Profesor" %>

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuarios</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/catalogs.css">
<link href="assets/css/login.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/css/welcome.js"></script>

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"><link>

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
                
    <h2 class="modal-title">Usuarios</h2>
    <br>
    <br>
  
    <%
            HttpSession miSession = request.getSession();
            Controlador cn = new Controlador();
            Rol r = new Rol();
            r.setDescription("");
            Usuario u = new Usuario(r,"","","","","","","");
            ArrayList<Usuario> a = cn.consultarUsuario(u);
            if (a.size()>0){
     %>                    
            
            <!--<form name ="formCursos" method="post" action="servletCursos">-->
                <table  id="cursosTable" class="table-hover">
                    <thead> 
                        <tr>
                            <th>Nombre</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Username</th>
                            <th>Estado</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th>Rol</th>
                            <th class="text-center">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            for (int i=0; i<a.size(); i++){
                                Usuario us = a.get(i);
                        %>
                            <tr>
                                <td> <%=us.getName()%> </td>
                                <td> <%=us.getApellido1()%> </td>
                                <td> <%=us.getApellido2()%> </td>
                                <td> <%=us.getUsername()%> </td>
                                <td> <%=us.getEstado()%> </td>
                                <td> <%=us.getEmail()%> </td>
                                <td> <%=us.getPhone()%> </td>
                                <td> <%=us.getRol().getDescription()%> </td>
                                <td class="text-center"><button class="btn btn-info btn-xs" onclick="chargeTextFields()" id="editBtn" ><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-danger btn-xs" onclick="changeState(1)" id="inactiveBtn" ><span class="glyphicon glyphicon-remove"></span>Inactive</button>  <button class="btn btn-success btn-xs" onclick="changeState(0)" id="activeBtn"><span class="glyphicon glyphicon-ok"></span>Active</button></td>
                            </tr>
                          <%}%>
                    </tbody>
                </table>
            <%}%>
        <!--</form>-->
            <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
             <script>
                
    
                $(document).ready(function(){
                    $("#cursosTable").DataTable();
                });
                
                var table_companies = $('#cursosTable').dataTable({
                "lengthMenu": [[5, 10, -1], [5, 10, "All"]]});
            </script>
        </body>
    </html>

