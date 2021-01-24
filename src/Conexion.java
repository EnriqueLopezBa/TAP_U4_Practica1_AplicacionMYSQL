


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Enrique
 */
public class Conexion {
        Connection con;
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC","root","toor");
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null,"Error, "+ex.getMessage());
        }
    return con;
    }

    
    public ResultSet Consulta(String consulta){
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
                    rs = ps.executeQuery();
        } catch (SQLException ex) {
            showMessageDialog(null,"Error, "+ex.getMessage());
        }
return rs;
    }
}
