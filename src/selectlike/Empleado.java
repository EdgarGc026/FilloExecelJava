package selectlike;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Empleado {

    public static void main(String[] args) {

        try {

            //Creando la conexion al archivo de Excel
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");

            //Creando la consulta
            String strQuery = "Select * from Empleados where Correo like '@gmail.com%' ";
            Recordset recordset = connection.executeQuery(strQuery);

            while (recordset.next()) {
                System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido") + "|---|"
                        + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
            }

            //Cierras la conexion y cierras la consulta
            recordset.close();
            connection.close();

        } catch (FilloException e) {
            e.printStackTrace();

        }

    }

}
