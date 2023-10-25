/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilog
 */
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
     
    public Empleado validar(String user, String dni){
        Empleado  em = new Empleado();
        String sql = "SELECT * FROM empleado where User=? and Dni=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString( 1, user);
            ps.setString( 2, dni);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        }catch (Exception e){
            System.out.println("||||||| Error en la busqueda ||||||| -->"+e.getMessage());
        }
        return em;
    }
    
    //Operaciones CRUD
    
    public List Listar(){
        String sql = "SELECT * FROM empleado";
        List<Empleado>lista = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        }catch (Exception ex){
            System.out.println("°°°Error al consultar empleado (EmpleadoDAO) °°°°° "+ex);
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql = "INSERT INTO empleado(Dni, Nombres, Telefono, Estado, User) VALUES (?,?,?,?,?) ";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("°°°Error al insertar el empleado °°°°° "+ex);
        }   
        return r;
    }
    public Empleado listarId(int id){
        Empleado emp = new  Empleado();
        String sql = "SELECT * FROM empleado WHERE IdEmpleado = "+id;
        try{
            con = cn.Conexion();
            ps  = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        }catch(Exception ex){
            System.out.println("°°°Error al consultar el empleado °°°°° "+ex);            
        }
        return emp;
    }
    public int actualizar(Empleado em){
        String sql = "UPDATE empleado SET Dni = ?, Nombres = ?, Telefono = ?, Estado = ?, User = ? WHERE idEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("°°°Error al insertar el empleado °°°°° "+ex);
        }   
        return r;
    }
    public void delete(int id){
        String sql = "DELETE FROM empleado WHERE IdEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("°°°Error al eliminar el empleado °°°°° "+ex);
        }
    }
}
