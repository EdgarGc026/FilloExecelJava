package select;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.List;


public class Empleados {

    public static void main(String[] args) {

        try {
            //Mandamos a llamar el constructor del JAR
            Fillo fillo = new Fillo();
            //Creas la conexion y agregas la ruta donde esta almacenado el archivo
            Connection connection = fillo.getConnection("C:/Users/sam/Documents/hobbies.xlsx");
            //Haces tu consulta en la hoja de excel
            String strQuery = " Select * from  Empleados ";
            Recordset recordset = connection.executeQuery(strQuery);
            
            //TODO: Se crea un ArrayList para manipular los archivos
            List<String> datos = new ArrayList<>();
            

            //Muestra los campos que deseas obtener
            while (recordset.next()) {
                System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido")+ "|---|" + recordset.getField("Correo")
                + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
                
                datos.add(recordset.getField("Empresa"));
            }
            
            //TODO: Leer los datos desde tu ArrayList
            System.out.println("La primera empresa que tiene tu arreglo es : "+ datos.get(0) );
            
            
            //TODO: Saber cuantos resultados son:
            System.out.println("Se encontraron " + recordset.getCount() + " fields");
                
            
            //TODO:Obten uno en particular
                /**
                 * moveLast() Obtiene el ultimo
                 * moveFirs() Obtiene el primero y lo muestra
                 * movePrevious() Obtiene uno antes del que pidas
                 * moveNext() Obtiene el siguiente de donde estes
                 * getFieldNames Array con el cual puedes obtener las filas y columnas de tu objeto
                 * size() Tamanio de para las columnas y filas
                 * get() Obtienes el numero del campo que deseas buscar
                 */
            recordset.moveLast();
             System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido")+ "|---|" + recordset.getField("Correo")
                + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
            
             
             //TODO: Obten uno antes que el otro
             recordset.movePrevious();
             System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido")+ "|---|" + recordset.getField("Correo")
                + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
             
             //TODO: Obten el primero
             recordset.moveFirst();
             System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido")+ "|---|" + recordset.getField("Correo")
                + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
             
             //TODO: Obten el segundo
             recordset.moveNext();
             System.out.println(recordset.getField("Nombre") + "|---|" + recordset.getField("Apellido")+ "|---|" + recordset.getField("Correo")
                + "|---|" + recordset.getField("Correo") + "|---|" + recordset.getField("Empleo") + "|---|" + recordset.getField("Empresa"));
             
             //TODO: Total de tus columnas
             int ColumnasTotal = recordset.getFieldNames().size();
             System.out.println("Tienes " + ColumnasTotal + " columnas" );
             
             //TODO: Obten el nombre de las columnas
             String NombreColumna = recordset.getFieldNames().get(0);
             System.out.println("La primera columna es: " + NombreColumna );
             
            //Cierras la conexion y cierras la consulta
            recordset.close();
            connection.close();

            //Si hay algun problema con el codigo, aqui veras el porque
        } catch (FilloException e) {
            e.printStackTrace();
        }
    }

}
