
package delete;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class Empleado {
    public static void main(String[] args){
        try {
            
            //Creacion de la conexion del archivo Excel
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");
            
            //Eliminamos poniendo una condicion
            String strQuery = " DELETE from Empleados where Nombre ='Yhair' ";
            connection.executeUpdate(strQuery);
            
            //Cerramos la conexion
            connection.close();
            
        } catch (FilloException e) {
            e.printStackTrace();
        }
    }
}
