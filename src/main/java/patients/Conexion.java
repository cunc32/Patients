/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author AORUS
 */
public class Conexion {

    public static Connection getConexion() {

        Connection conectar = null;
        String usuario = "sa";
        String contra = "Publicsql20";

        try {
            String cadena = "jdbc:sqlserver://olimpo.dscloud.biz:1433;databaseName=CMM;encrypt=false";
            conectar = DriverManager.getConnection(cadena, usuario, contra);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido algun error inesperadamente esperado\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return conectar;

    }
    
    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static boolean Execute(String statement) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            boolean respuesta = declara.execute(statement);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static void EliminarPaquete(int id) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call DelPaquete(?)}");
        entrada.setInt(1, id);
        entrada.execute();
    }
    
    public static void AgregarPaquete(int id_paq, int id_prod, String tipo, String ruta, int peso, String desc, String dec_Aduana) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaPaquete(?,?,?,?,?,?,?)}");
        entrada.setInt(1, id_paq);
        entrada.setInt(2, id_paq);
        entrada.setString(3, tipo);
        entrada.setString(4, ruta);
        entrada.setInt(5, peso);
        entrada.setString(6, desc);
        entrada.setString(7, dec_Aduana);
        entrada.execute();
    }
    
    public static void EliminarCliente(int id) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call DelCliente(?)}");
        entrada.setInt(1, id);
        entrada.execute();
    }
     /*
    public static void AgregarCliente(int id_cliente, int id_paq, ) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaCliente(?,?,?,?,?,?,?)}");
        entrada.setInt(1, id_paq);
        entrada.setInt(2, id_paq);
        entrada.setString(3, tipo);
        entrada.setString(4, ruta);
        entrada.setInt(5, peso);
        entrada.setString(6, desc);
        entrada.setString(7, dec_Aduana);
        entrada.execute();
    } */
    
    public static void EliminarTransporte(int id) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call DelTransporte(?)}");
        entrada.setInt(1, id);
        entrada.execute();
    }
    
    public static void EliminarAlmacen(int id) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call DelAlmacen(?)}");
        entrada.setInt(1, id);
        entrada.execute();
    }
    
    public static void Query(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            declara.executeQuery(consulta);
        } catch (SQLException e) {
        }
    }

}
