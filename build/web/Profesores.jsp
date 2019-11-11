
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controlador" %>
<%@page import="model.Profesor" %>

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>profesores</title>
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
        document.getElementById("savechangesBtn").style.visibility = "hidden";
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
                
    <h2 class="modal-title">Profesores</h2>
    <br>
    <br>
  
    <%
            HttpSession miSession = request.getSession();
            Controlador cn = new Controlador();
            Profesor p = new Profesor("","","","","","");
            ArrayList<Profesor> a = cn.consultarProfesor(p);
            if (a.size()>0){
     %>                    
            
            <!--<form name ="formCursos" method="post" action="servletCursos">-->
                <table  id="cursosTable" class="table-hover">
                    <thead> 
                        <tr>
                            <th>Cédula</th>
                            <th>Nombre</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th>Estado</th>
                            <th class="text-center">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            for (int i=0; i<a.size(); i++){
                                Profesor pr = a.get(i);
                        %>
                            <tr>
                                <td> <%=pr.getId()%> </td>
                                <td> <%=pr.getNombre()%> </td>
                                <td> <%=pr.getApellido1()%> </td>
                                <td> <%=pr.getApellido2()%> </td>
                                <td> <%=pr.getCorreo()%> </td>
                                <td> <%=pr.getTelefono()%> </td>
                                <td> <%=pr.getEstado()==0?"Activo":"Inactivo"%> </td>
                                <td class="text-center"><button class="btn btn-info btn-xs" onclick="chargeTextFields()" id="editBtn" ><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-danger btn-xs" onclick="changeState(1)" id="inactiveBtn" ><span class="glyphicon glyphicon-remove"></span>Inactive</button>  <button class="btn btn-success btn-xs" onclick="changeState(0)" id="activeBtn"><span class="glyphicon glyphicon-ok"></span>Active</button></td>
                            </tr>
                          <%}%>
                    </tbody>
                </table>
            <%}%>
        <!--</form>-->
            <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
                <br>
                <form class="form-inline" method="post">
                    <label id="cedulaLabel" for="id">Cédula:</label>
                    <input type="text" id="cedula" placeholder="Digite la cédula" name="cedula">
                    <label>Nombre:</label>
                    <input type="text" id="nombre" placeholder="Digite el nombre" name="nombre">
                    <label>Primer Apellido:</label>
                    <input type="text" id="apellido1" placeholder="Digite el apellido" name="apellido1">
                    <label>Segundo Apellido:</label>
                    <input type="text" id="apellido2" placeholder="Digite el apellido" name="apellido2">
                    <label>Correo:</label>
                    <input type="text" id="correo" placeholder="Digite el correo" name="correo">
                    <label>Teléfono:</label>
                    <input type="text" id="telefono" placeholder="Digite el correo" name="telefono">
                    <button id="addBtn" onclick="updateAndAdd(3)">Agregar</button>
                    <button id="savechangesBtn" onclick="updateAndAdd(2)">Guardar Cambios</button>
                </form>
                
                <script>
                
    
                $(document).ready(function(){
                    $("#cursosTable").DataTable();
                });
                
                var table_companies = $('#cursosTable').dataTable({
                "lengthMenu": [[5, 10, -1], [5, 10, "All"]]});
                
                
                function changeState(job) {
                    
                    $("#cursosTable").on('click','tr',function() {
                      var id = $(this).find("td:first-child").text();
                        $.ajax({
                            url: 'servletProfesores',
                            method: 'POST',
                            data: {id:id, job:job },
                            success: function(result) {
                                location.reload();
                            },
                            error : function(jqXHR, exception){
                                console.log('Error occured!!');
                            }
                        });
                    });
            }
            
            function updateAndAdd(job){
                
                $.ajax({
                    url: 'servletProfesores',
                    method: 'POST',
                    data: {job:job,cedula:$("#cedula").val(),nombre:$("#nombre").val(),apellido1:$("#apellido1").val(),apellido2:$("#apellido2").val(), correo:$("#correo").val(), telefono:$("#telefono").val()},
                    success: function(result) {
                        location.reload();
                    },
                    error : function(jqXHR, exception){
                        console.log('Error occured!!');
                    }
                });
            }
            
            function chargeTextFields(){
                document.getElementById("savechangesBtn").style.visibility = "visible";
                document.getElementById("addBtn").style.visibility = "hidden";
                document.getElementById("cedulaLabel").style.visibility = "hidden";
                document.getElementById("cedula").style.visibility = "hidden";
                
                $("#cursosTable").on('click','tr',function() {
                    var $row = $(this).closest("tr"),       // Finds the closest row <tr> 
                    $tds = $row.find("td");                 // Finds all children <td> elements
                    $("#cedula").val($tds[0].innerHTML);
                    $("#nombre").val($tds[1].innerHTML);
                    $("#apellido1").val($tds[2].innerHTML);
                    $("#apellido2").val($tds[3].innerHTML);
                    $("#correo").val($tds[4].innerHTML);
                    $("#telefono").val($tds[5].innerHTML);
                    
                }); 
            }
            
            
            
            </script>
                
</body>
</html>

