
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controlador" %>
<%@page import="model.PeriodoLectivo" %>

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
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
        $('#nav-placeholder').load('navbar.html');
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
                
    <h2 class="modal-title">Periodos Lectivos</h2>
    <br>
    <br>
  
    <%
            HttpSession miSession = request.getSession();
            Controlador cn = new Controlador();
            PeriodoLectivo p = new PeriodoLectivo("","","","","");
            if (cn.consultarPeriodoLectivo(p).size()>0){
     %>                    
            
            <!--<form name ="formCursos" method="post" action="servletCursos">-->
                <table  id="cursosTable" class="table-hover">
                    <thead> 
                        <tr>
                            <th>Id</th>
                            <th>Fecha Publicación</th>
                            <th>Inicio de Matrícula</th>
                            <th>Fin de Matrícula</th>
                            <th>Inicio Período</th>
                            <th>Fin Período</th>
                            <th>Estado</th>
                            <th>Modalidad</th>
                            <th class="text-center">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<PeriodoLectivo> a = cn.consultarPeriodoLectivo(p);
                            for (int i=0; i<a.size(); i++){
                                PeriodoLectivo pr = a.get(i);
                        %>
                            <tr>
                                <td> <%=pr.getId()%> </td>
                                <td> <%=pr.getFechaPublicacion()%> </td>
                                <td> <%=pr.getFechaMatriculaInicio()%> </td>
                                <td> <%=pr.getFechaMatriculaFinal()%> </td>
                                <td> <%=pr.getFechaInicio()%> </td>
                                <td> <%=pr.getFechaFinal()%> </td>
                                <td> <%=pr.getEstado()==0?"Activo":"Inactivo"%> </td>
                                <td> <%=pr.getModalidad()%> </td>
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
                    <label>Publicación:</label>
                    <input type="date" id="publicacion" name="publicacion">
                    <label>Inicio Matrícula:</label>
                    <input type="date" id="matriculaInicio" name="matriculaInicio">
                    <label>Fin Matrícula:</label>
                    <input type="date" id="matriculaFin" name="matriculaFin">
                    <label>Inicio Período:</label>
                    <input type="date" id="inicioP" name="inicioP">
                    <label>Fin Período:</label>
                    <input type="date" id="finP" name="finP">
                    <select id="modalidadCombo">
                        <%
                            
                            ArrayList<String> a = cn.consultarModalidad();
                            for (int i=0; i<a.size(); i++){
                                
                        %>
                        <option value=<%=a.get(i)%> ><%=a.get(i)%></option>
                        <%}%>
                    </select> 
                    <br>
                    <button id="addBtn" onclick="updateAndAdd(3)">Agregar</button>
                    <button id="savechangesBtn" onclick="updateAndAdd(2)">Guardar Cambios</button>
                </form>
                <script>
                var idPeriodoLectivo = -1;
    
                $(document).ready(function(){
                    $("#cursosTable").DataTable();
                });
                
                var table_companies = $('#cursosTable').dataTable({
                "lengthMenu": [[5, 10, -1], [5, 10, "All"]]});
                
                
                function changeState(job) {
                    
                    $("#cursosTable").on('click','tr',function() {
                      var id = $(this).find("td:first-child").text();
                        $.ajax({
                            url: 'servletPeriodoLectivo',
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
                
                var e = document.getElementById("modalidadCombo");
                var modalidad = e.options[e.selectedIndex].value;
                
                $.ajax({
                    url: 'servletPeriodoLectivo',
                    method: 'POST',
                    data: {job:job,idPeriodoLectivo: idPeriodoLectivo,publicacion:$("#publicacion").val(),matriculaInicio:$("#matriculaInicio").val(),matriculaFin:$("#matriculaFin").val(),inicioP:$("#inicioP").val(), finP:$("#finP").val(),modalidad:modalidad},
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
                
                $("#cursosTable").on('click','tr',function() {
                    var $row = $(this).closest("tr"),       // Finds the closest row <tr> 
                    $tds = $row.find("td");
                    idPeriodoLectivo = $tds[0].innerHTML.trim();
                    $("#publicacion").val($tds[1].innerHTML.trim());
                    $("#matriculaInicio").val($tds[2].innerHTML.trim());
                    $("#matriculaFin").val($tds[3].innerHTML.trim());
                    $("#inicioP").val($tds[4].innerHTML.trim());
                    $("#finP").val($tds[5].innerHTML.trim());
                    
                }); 
            }
            
            
            
            </script>
                
</body>
</html>

