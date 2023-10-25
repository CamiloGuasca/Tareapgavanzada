<%-- 
    Document   : Empleado
    Created on : Oct 18, 2023, 8:57:18 PM
    Author     : camilog
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Empleado" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Empleado</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="post">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txtTelefono" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txtUsuario" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">   
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">   
                    </form>
                </div> 
            </div>    
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Dni</th>
                            <th>Nombres</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>User</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
                           for(Empleado em : empleados) {
                        %>
                            <tr>
                                <td><%=em.getId()%></td>
                                <td><%=em.getDni()%></td>
                                <td><%=em.getNom()%></td>
                                <td><%=em.getTel()%></td>
                                <td><%=em.getEstado()%></td>
                                <td><%=em.getUser()%></td>
                                <td>
                                    <a href="Controlador?menu=Empleado&accion=Editar&id=<%=em.getId()%>" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Empleado&accion=Delete&id=<%=em.getId()%>" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>    
            </div>    
        </div>   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
    </body>
</html>
