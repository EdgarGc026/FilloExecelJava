/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectwhere;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/**
 *
 * @author sam
 */
public class Empleado {

    public static void main(String[] args) {
        try {
            //Mandamos a llamar el constructor del JAR
            Fillo fillo = new Fillo();
            //Creas la conexion y agregas la ruta donde esta almacenado el archivo
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");

            //Query condicion WHERE
            /* String strQuery = "Select * from Empleados where Empresa = 'Amazon' ";
            Recordset recordset = connection.executeQuery(strQuery);
             */
            //Persistencia de archivos y buenas practicas
            Recordset recordset = connection.executeQuery("Select * from Empleados").where("Empresa = 'Amazon'");

            while (recordset.next()) {
                System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido") + "|---|"
                        + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
            }

            System.out.println("****************************************************************************************");

            //TODO: Multiples condiciones WHERE
            /*String strQuery = "Select * from Empleados where Nombre = 'Edgar' and Apellido = 'Gonzalez' ";
            recordset = connection.executeQuery(strQuery);]*/
            recordset = connection.executeQuery("Select * from Empleados ").where("Nombre = 'Edgar'").where("Empresa = 'Amazon' ");
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
