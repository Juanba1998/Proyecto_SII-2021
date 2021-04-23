package es.uma.informatica.ejb.tarea2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
 
/** 
 * Utility class, where we will create methods for training read and write excel files,
 * with <a href="https://poi.apache.org/">Apache POI</a>, we use 
 * <a href="https://poi.apache.org/spreadsheet/">POI-XSSF and POI-XSSF - Java API To Access Microsoft</a>
 * XSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file.
 * 
 * Clase de utilidades, donde crearemos métodos
 * para el aprendizaje de la lectura y escritura de ficheros excel con 
 * <a href="https://poi.apache.org/">Apache POI</a>, usaremos
 * <a href="https://poi.apache.org/spreadsheet/">POI-XSSF and POI-XSSF - Java API To Access Microsoft</a>
 * XSSF es el proyecto POI de implementación total en Java para ficheros Excel '97(-2007).
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class JavaPoiUtils {
    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, in this example we print the content in the console.
     * Explicación del método con el que leemos el fichero excel que pasamos como
     * parámetro si existe, en este ejemplo mostramos el contenido por la consola.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     * JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
     * javaPoiUtils.readExcelFile(new File("/home/xules/codigoxules/apachepoi/PaisesIdiomasMonedas.xls"));    
     * </pre>
     *
     * @param excelFile <code>String</code> 
     *      excel File we are going to read. 
     *      Fichero excel que vamos a leer. 
     */
    public void readExcelFile(File excelFile){
        InputStream excelStream = null;
       // private static final Logger LOG = Logger.getLogger(JavaPoiUtils.class.getCanonicalName());
        try {
            excelStream = new FileInputStream(excelFile);
            
            try (// High level representation of a workbook.
			            // Representación del más alto nivel de la hoja excel.
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excelStream)) {
				// We chose the sheet is passed as parameter. 
				// Elegimos la hoja que se pasa por parámetro.
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
				// Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
				XSSFRow xssfRow;
				// Initialize the object to read the value of the cell 
				// Inicializo el objeto que leerá el valor de la celda
				//XSSFCell cell;                        
				// I get the number of rows occupied on the sheet
				// Obtengo el número de filas ocupadas en la hoja
				int rows = xssfSheet.getLastRowNum();
				// I get the number of columns occupied on the sheet
				// Obtengo el número de columnas ocupadas en la hoja
				//int cols = 0;            
				// A string used to store the reading cell
				// Cadena que usamos para almacenar la lectura de la celda
				String cellValue;  
				// For this example we'll loop through the rows getting the data we want
				// Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
				for (int r = 0; r < rows; r++) {
				    xssfRow = xssfSheet.getRow(r);
				    if (xssfRow == null){
				        break;
				    }else{
				        System.out.print("Row: " + r + " -> ");
				        for (int c = 0; c < (/*cols =*/ xssfRow.getLastCellNum()); c++) {
				            /* 
				                We have those cell types (tenemos estos tipos de celda): 
				                    CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
				            */
				            cellValue = xssfRow.getCell(c) == null?"":
				                    (xssfRow.getCell(c).getCellType() == 1/*CellType.STRING*/)?xssfRow.getCell(c).getStringCellValue():
				                    (xssfRow.getCell(c).getCellType() == 0 /*CellType.NUMERIC*/)?"" + xssfRow.getCell(c).getNumericCellValue():
				                    (xssfRow.getCell(c).getCellType() == 4 /*CellType.BOOLEAN*/)?"" + xssfRow.getCell(c).getBooleanCellValue():
				                    (xssfRow.getCell(c).getCellType() == 3 /*CellType.BLANK*/)?"BLANK":
				                    (xssfRow.getCell(c).getCellType() == 5 /*CellType.ERROR*/)?"ERROR":"";    

				            System.out.print("[Column " + c + ": " + cellValue + "] ");
				        }
				        System.out.println();
				    }
				}
			}            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }
    /**     
     * Main method for the tests for the methods of the class <strong>Java
     * read excel</strong> and <strong>Java create excel</strong> 
     * with <a href="https://poi.apache.org/">Apache POI</a>. 
     * <br />
     * Método main para las pruebas para los método de la clase,
     * pruebas de <strong>Java leer excel</strong> y  <strong>Java crear excel</strong>
     * con <a href="https://poi.apache.org/">Apache POI</a>.     
     * @param args 
     */
    public static void main(String[] args){
        JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
        javaPoiUtils.readExcelFile(new File("/home/alumno/eclipse-workspace/trabajo/Proyecto_SII-2021/DatosAlumnadoFAKE.xlsx"));        
    }    
}
