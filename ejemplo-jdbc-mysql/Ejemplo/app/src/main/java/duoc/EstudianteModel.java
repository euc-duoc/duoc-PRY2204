package duoc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class EstudianteModel {
    private String error = null;

    public String getError() {
        return error;
    }
    
    public Estudiante convertirDesde(String[] datos) {
        ArrayList<String> datosInvalidos = new ArrayList<>();
        Estudiante e = new Estudiante();
        
        if(datos.length < 4) {
            error = "No se han proporcionado todos los datos necesarios";
            return null;
        }
        
        try {
            e.setRut(Integer.parseInt(datos[0]));
        } 
        catch (NumberFormatException ex) {
            error = "RUT debe ser numérico.";
            return null;
        }
        
        try {
            e.setEdad(Integer.parseInt(datos[3]));
        } 
        catch (NumberFormatException ex) {
            error = "Edad debe ser numérica.";
            return null;
        }
        
        e.setNombre(datos[1]);
        e.setApellido(datos[2]);
        e.setLocalidad(datos[4]);
        
        return e;
    }
    
    public Estudiante[] obtenerEstudiantes() {
        error = null;
        Connection conn = null;
        Estudiante[] res = null;
        
        try {            
            conn = DB.getInstance().getConnection();
            ArrayList<Estudiante> lRes = new ArrayList<>();
            CallableStatement cs = conn.prepareCall("{call OBTENER_ESTUDIANTES()}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            
            while(rs.next()){
                Estudiante e = new Estudiante();

                e.setRut(rs.getInt("rut"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setEdad(rs.getInt("edad"));
                e.setLocalidad(rs.getString("localidad")); 

                lRes.add(e);
            }
            
            res = lRes.toArray(new Estudiante[0]);
            conn.close();
        }
        catch(SQLException ex) {
            error = "Error al obtener estudiantes:\n" + ex.toString();
        }
        
        if(conn != null)
            try { conn.close(); } catch(Exception ex) {};

        return res;
    }
    
    public boolean agregarEstudiante(Estudiante e) {
        error = null;
        Connection conn = null;
        boolean res = false;
        
        try {
            conn = DB.getInstance().getConnection();
            CallableStatement cs = conn.prepareCall("{?=call CREAR_ESTUDIANTE(?,?,?,?,?)}");
            cs.setInt(2, e.getRut());
            cs.setString(3, e.getNombre());
            cs.setString(4, e.getApellido());
            cs.setInt(5, e.getEdad());
            cs.setString(6, e.getLocalidad() == null ? "NULL" : e.getLocalidad()); 
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.executeUpdate();
            
            res = true;
            conn.close();
        }
        catch(SQLException ex) {
            error = "Error al agregar estudiante:\n" + ex.toString();
        }
        
        if(conn != null)
            try { conn.close(); } catch(Exception ex) {};

        return res;
    }
    
    public boolean modificarEstudiante(Estudiante e) {
        error = null;
        Connection conn = null;
        boolean res = false;
        
        try {
            conn = DB.getInstance().getConnection();
            CallableStatement cs = conn.prepareCall("{call MODIFICAR_ESTUDIANTE(?,?,?,?,?)}");
            cs.setInt(1, e.getRut());
            cs.setString(2, e.getNombre());
            cs.setString(3, e.getApellido());
            cs.setInt(4, e.getEdad());
            cs.setString(5, e.getLocalidad() == null ? "NULL" : e.getLocalidad()); 
            cs.executeUpdate();
            
            res = true;
            conn.close();
        }
        catch(SQLException ex) {
            error = "Error al modificar estudiante:\n" + ex.toString();
        }
        
        if(conn != null)
            try { conn.close(); } catch(Exception ex) {};

        return res;
    }
    
    public boolean eliminarEstudiante(Estudiante e) {
        error = null;
        Connection conn = null;
        boolean res = false;
        
        try {
            conn = DB.getInstance().getConnection();
            CallableStatement cs = conn.prepareCall("{call ELIMINAR_ESTUDIANTE(?)}");
            cs.setInt(1, e.getRut());            
            cs.execute();
            
            res = true;
            conn.close();
        }
        catch(SQLException ex) {
            error = "Error al eliminar estudiante:\n" + ex.toString();
        }
        
        if(conn != null)
            try { conn.close(); } catch(Exception ex) {};
            
        return res;
    }
}
