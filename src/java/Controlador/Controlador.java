     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author camilog
 */
public class Controlador extends HttpServlet {

    int ide;
    Empleado  em = new  Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cli = new Cliente();
    ClienteDAO clidao = new ClienteDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch (accion){
                    case "Listar":
                        List lista = edao.Listar();
                        request.setAttribute("empleados", lista);
                        break;          
                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTelefono");
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        
                        Empleado e = edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTelefono");
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }            
            if(menu.equals("Clientes")){
                switch (accion){
                    case "Listar":
                        List lista1 = clidao.Listar();
                        List<Cliente>lis = new ArrayList<>();
                        lis = lista1;
                        request.setAttribute("clientes", lista1);
                        break;          
                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String dir = request.getParameter("txtDireccion");
                        String est = request.getParameter("txtEstado");
                        cli.setDni(dni);
                        cli.setNombres(nom);
                        cli.setDireccion(dir);
                        cli.setEstado(est);
                        clidao.agregar(cli);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));                       
                        Cliente c = clidao.listarId(ide);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String dir1 = request.getParameter("txtDireccion");
                        String est1 = request.getParameter("txtEstado");
                        cli.setIdCliente(ide);
                        cli.setDni(dni1);
                        cli.setNombres(nom1);
                        cli.setDireccion(dir1);
                        cli.setEstado(est1);
                        clidao.actualizar(cli);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        clidao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if(menu.equals("NuevaVenta")){
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
