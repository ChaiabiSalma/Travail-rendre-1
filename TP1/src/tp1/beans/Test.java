/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.beans;

import java.sql.*;
public class Test {
    public static void save(Site s){
    String user="root";
    String password="1234";
    String url="jdbc:mysql://localhost/db";
    Connection cn = null;
    Statement str = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection(url, user, password);
        str = cn.createStatement();
        String req = "insert into site values(null,'" + s.getNom() + "')";
        str.executeUpdate(req);
    }catch(SQLException e){
        System.out.println("Erreur SQL");
    }catch (ClassNotFoundException ex){
        System.out.println("Impossible de charger le driver");
    }finally{
       try{
          str.close();
          cn.close();
       }catch(SQLException ex){
           System.out.println("Impossible de libérer les ressources");
       }
    }
   }
    public static void load() {
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost/db";
        Connection cn = null;
        Statement str = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            str = cn.createStatement();
            String req = "select * from site";
            rs = str.executeQuery(req);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } finally {
            try {
                str.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }
    public static void delete() {
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost/db";
        Connection cn = null;
        Statement str = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            str = cn.createStatement();
            String req = "delete from site";
            int rs = str.executeUpdate(req);
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } finally {
            try {
                str.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }
    public static void main(String[] args) {
         save(new Site("SAFI"));
         save(new Site("MARRAKECH"));
         save(new Site ("EL JADIDA"));
         //delete();
         load();
    }
}
