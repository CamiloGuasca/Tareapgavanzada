/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author camilog
 */
public class Conexion {
    Connection con;
    public Connection Conexion(){
        String url = "jdbc:mysql://localhost:3306/bd_ventas";
        String user = "root";
        String pass = "!Vid4(-)3rM0s";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection(url,user,pass);
        }catch (Exception ex){
            System.out.println("%%%%% No se pudo conectar %%%%% -->"+ex);
        }
        return con;
    }
}
