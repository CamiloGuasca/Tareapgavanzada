<%-- 
    Document   : Clientes
    Created on : Oct 20, 2023, 11:56:15 AM
    Author     : camilog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Cliente" %>
<%@ page import="Modelo.Empleado" %>
<%
    HttpSession sesion = (HttpSession)request.getSession();
    Empleado emp = (Empleado)sesion.getAttribute("usuario");
    if (emp == null) {
        response.sendRedirect("index.jsp");
    }else{
            
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="post">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${cliente.getNombres()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
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
                            <th>Dirección</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); // Obtén la lista de empleados del ámbito de la solicitud
                           for(Cliente cl : clientes){
                        %>
                            <tr>
                                <td><%=cl.getIdCliente()%></td>
                                <td><%=cl.getDni()%></td>
                                <td><%=cl.getNombres()%></td>
                                <td><%=cl.getDireccion()%></td>
                                <td><%=cl.getEstado()%></td>
                                <td>
                                    <a href="Controlador?menu=Clientes&accion=Editar&id=<%=cl.getIdCliente()%>" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Clientes&accion=Delete&id=<%=cl.getIdCliente()%>" class="btn btn-danger">Eliminar</a>
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
<%}%>