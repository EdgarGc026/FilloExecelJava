
package insert;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class Empleado {
    public static void main(String [] args){
        try {
            
            //Creacion de la conexion del archivo Excel
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");
            
            String strQuery = " INSERT into Empleados(Nombre, Apellido, Correo, Empleo, Empresa) VALUES ('Yhair','Rodriguez','kanon96@gmail.com','Mantenimiento','Google') ";
            connection.executeUpdate(strQuery);
            
            //Cerramos la conexion
            connection.close();
            
        } catch (FilloException e) {
            e.printStackTrace();
        }
    }
}
