     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Configuracion.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import sun.security.jgss.GSSUtil;

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
    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    VentaDAO  vdao = new VentaDAO();
    
    Venta  v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    
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
                switch (accion){
                    case "Listar":
                        List lista = prodao.Listar();
                        request.setAttribute("productos", lista);
                        break;          
                    case "Agregar":
                        String nom = request.getParameter("txtNombres");
                        String pre = request.getParameter("txtPrecio");
                        String stk = request.getParameter("txtStock");
                        String est = request.getParameter("txtEstado"); 
                        pro.setNombres(nom);
                        pro.setPrecio(Double.parseDouble(pre));
                        pro.setStock(Integer.parseInt(stk));
                        pro.setEstado(est);
                        prodao.agregar(pro);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));                       
                        Producto p = prodao.listarId(ide);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String nom1 = request.getParameter("txtNombres");
                        String pre1 = request.getParameter("txtPrecio");
                        String stk1 = request.getParameter("txtStock");
                        String est1 = request.getParameter("txtEstado");
                        pro.setIdProducto(ide);
                        pro.setNombres(nom1);
                        pro.setPrecio(Double.parseDouble(pre1));
                        pro.setStock(Integer.parseInt(stk1));
                        pro.setEstado(est1);
                        prodao.actualizar(pro);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        prodao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if(menu.equals("NuevaVenta")){
                switch(accion){
                    case "BuscarCliente":
                        String dni = request.getParameter("codigocliente");
                        cli.setDni(dni);
                        cli = clidao.buscar(dni);
                        request.setAttribute("cliente", cli);
                        break;
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("codigoproducto"));
                        pro = prodao.listarId(id);
                        request.setAttribute("cliente", cli);
                        request.setAttribute("producto", prodao.listarId(id));
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalPagar);
                        break;
                    case "Agregar":
                        totalPagar = 0.0;
                        item = item+1;
                        cod = pro.getIdProducto();
                        descripcion = request.getParameter("nomproducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio*cant;
                        v  = new Venta();
                        v.setItem(item);
                        v.setId(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int c = 0 ; c < lista.size() ; c++) {
                            totalPagar = totalPagar + lista.get(c).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                        break;
                    default:
                        numeroserie = vdao.GenerarSerie();
                        if(numeroserie == null){
                            numeroserie = "0000001";
                            request.setAttribute("nserie", numeroserie);
                        }else{
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                         request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
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
