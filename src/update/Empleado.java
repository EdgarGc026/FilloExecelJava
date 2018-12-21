package update;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class Empleado {

    public static void main(String[] args) {

        try {

            //Crear la conexion al archivo excel
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");
            
            //Creamos nuestro query
            String strQuery = "UPDATE Empleados set Empresa = 'Ebay' where Nombre = 'Edgar' ";
            connection.executeUpdate(strQuery);
            
            
            //Cerramos la conexion
            connection.close();
            

        } catch (FilloException e) {
            e.printStackTrace();
            System.out.println("Algo paso y no se que fue");
        }

    }
}
