package es.uma.informatica.ejb.tarea2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import es.uma.informatica.ejb.excepciones.AlumnoExistenteException;
import es.uma.informatica.ejb.excepciones.ExpedientesExistenteException;
import es.uma.informatica.ejb.excepciones.MatriculaExistenteException;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Matricula;


/**
 * Session Bean implementation class ExcelEJB
 */
@Stateless
public class ExcelEJB implements GestionExcel {
	private static final Logger LOG = Logger.getLogger(ExcelEJB.class.getCanonicalName());
	
	private  XSSFWorkbook wB;
	private  XSSFSheet sheet;
	
	@PersistenceContext(name="trabajo")
	private  EntityManager em;

	
	
	private  String nombreAux;
	private  Alumno al;
	private  Matricula matr;
	private  Expedientes exp;
	
	
	

	
	public  void insertExcelData(String excelPath,String sheetName) throws MatriculaExistenteException, AlumnoExistenteException, ExpedientesExistenteException {
		try {
		wB =  new XSSFWorkbook(excelPath);
		sheet = wB.getSheet(sheetName);
		}catch (Exception e) {
			// TODO: handle exception
		}
		Iterator<Row> rowIt = sheet.iterator();
		
		int aux = 3;
		for(int i=0; i<=aux;i++)rowIt.next();
		
		while(rowIt.hasNext()) {
			
			int nColum = 0;
			
			Row row = rowIt.next();
			
			if(!isRowEmpty(row)) {
				
				al = new Alumno();
				exp = new Expedientes();
				matr = new Matricula();
				
				Iterator<Cell> cellIt = row.cellIterator();
				
				while(cellIt.hasNext()) {
					Cell cell = cellIt.next();
					
					
					setCellData(cell, nColum);
					
					nColum++;
					
					
					
				}
				
				insertAlumno(al);
				insertExpediente(exp);
				
				matr.setExpediente(exp);
				insertMatricula(matr);
				
				System.out.println("***************");
			}
			
			
		}
		

	}
	
	private  void insertMatricula(Matricula matr2) throws MatriculaExistenteException {
		
		Matricula mtrExist = em.find(Matricula.class, new Matricula.MatriculaId(matr2.getCurso_academico(),exp.getNum_Expediente()));
		if(mtrExist != null) {
			throw new MatriculaExistenteException();
		}
		em.persist(matr2);
		
	}

	private  void insertExpediente(Expedientes exp2) throws ExpedientesExistenteException {
		Expedientes alExist = em.find(Expedientes.class, exp2.getNum_Expediente());
		if(alExist != null) {
			throw new ExpedientesExistenteException();
		}
		em.persist(exp2);
		
	}

	private  void insertAlumno(Alumno al2) throws AlumnoExistenteException {
		//Como tiene como PK ID el cual es un valor autogenerado al2.getID() devuelve null
		//Alumno alExist = em.find(Alumno.class, al2.getID());
		//if(alExist != null) {
			//throw new AlumnoExistenteException();
		//}
		em.persist(al2);
		
		
	}

	private  boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
	
	private  void setCellData(Cell cell, int nColum) {
		
		switch (nColum) {
		
		case 0:
			System.out.println("DOCUMENTO: "+ cell.toString());
			
			al.setDNI(cell.toString());
			
			break;
		case 1:
			System.out.println("NOMBRE: "+ cell.toString());
			
			nombreAux=cell.toString();
			
			break;
			
		case 2:
			System.out.println("1º APELLIDO: "+ cell.toString());
			
			nombreAux+=" " + cell.toString();
			
			break;
		case 3:
			System.out.println("2º APELLIDO: "+ cell.toString());
			
			nombreAux+=" "+cell.toString();
			
			al.setNombre_completo(nombreAux);
			
			break;
			
		case 4:
			
			System.out.println("Nº EXPEDIENTE: "+ cell.toString());
			exp.setNum_Expediente(Integer.valueOf(cell.toString()));
			
			break;
		case 5:
			
			System.out.println("Nº ARCHIVO: "+ cell.toString());
			Integer value;
			try {
				value = Integer.valueOf(cell.toString());
				matr.setNum_Archivo(value);
			} catch (NumberFormatException e) {
				e.getMessage();
			}
			
			
			break;
			
		case 6:
			
			System.out.println("EMAIL_INSTITUCIONAL: "+ cell.toString());
			al.setEmail_Institucional(cell.toString());
			
			break;
			
		case 7:
			
			System.out.println("EMAIL_PERSONAL: "+ cell.toString());
			al.setEmail_Personal(cell.toString());
			
			break;
			
		case 8:
			
			System.out.println("TELEFONO: "+ cell.toString());
			al.setTelefono((cell.toString()));
			
			break;
			
		case 9:
			
			System.out.println("MOVIL: "+ cell.toString());
			al.setMovil((cell.toString()));
			
			break;
			
		case 10:
			
			System.out.println("DIRECCION_NOTIFICACION: "+ cell.toString());
			al.setDireccion(cell.toString());
			
			break;
			
		case 11:
			
			System.out.println("LOCALIDAD_NOTIFICACION: "+ cell.toString());
			al.setLocalidad(cell.toString());
			
			break;
			
		case 12:
			
			System.out.println("PROVINCIA_NOTIFICACION: "+ cell.toString());
			al.setProvincia(cell.toString());
			
			break;
		
		case 13:
			
			System.out.println("CP_NOTIFICACION: "+ cell.toString());
			al.setCodigoPostal(Integer.valueOf(cell.toString()));
			
			break;
			
		case 14:
			System.out.println("FECHA_MATRICULA: "+ cell.toString());
			
			try {
				
				matr.setFecha_de_matricula(cell.toString());
				//Curso Academico
				matr.setCurso_academico(cursoAcademico(cell.toString()));
				
			} catch (Exception e) {
				System.out.println("Error en la fecha de matricula" + cell.toString());
			}
			
			break;
			
		case 15:
			
			System.out.println("TURNO_PREFERENTE: "+ cell.toString());
			matr.setTurno_Preferente(cell.toString());
			
			break;
			
		case 16:
			
			System.out.println("GRUPOS_ASIGNADOS: "+ cell.toString());
			
			List<String> aux = new ArrayList<String>();
			for (String asg : cell.toString().split(",")) {
				aux.add(asg);
			}
			
			al.setGrupos_asignados(aux);
			
			break;
			
		case 17:
			
			System.out.println("NOTA_MEDIA: "+ cell.toString());
			exp.setNota_Media_Provisional(Double.valueOf(cell.toString()));
			
			break;
			
		case 18:
			
			System.out.println("CREDITOS_SUPERADOS: "+ cell.toString());
			exp.setCreditos_superados(Double.valueOf(cell.toString()));
			
			break;
			
		case 19:
			
			System.out.println("CREDITOS_FB: "+ cell.toString());
			exp.setCreditos_FB(Double.valueOf(cell.toString()));
			
			break;
			
		case 20:
			
			System.out.println("CREDITOS_OB: "+ cell.toString());
			exp.setCreditos_OB(Double.valueOf(cell.toString()));
			
			break;
			
		case 21:
			
			System.out.println("CREDITOS_OP: "+ cell.toString());
			exp.setCreditos_OP(Double.valueOf(cell.toString()));
			
			break;
			
		case 22:
			
			System.out.println("CREDITOS_CF: "+ cell.toString());
			exp.setCreditos_CF(Double.valueOf(cell.toString()));
			
			break;
			
		case 23:
			
			System.out.println("CREDITOS_PE: "+ cell.toString());Integer.valueOf(cell.toString());
			exp.setCreditos_PE(Double.valueOf(cell.toString()));
			
			break;
			
		case 24:
			
			System.out.println("CREDITOS_TF: "+ cell.toString());
			exp.setCreditos_TF(Double.valueOf(cell.toString()));
			
			break;		
				

		default:
			System.out.println("Error"+ cell.toString());
			break;
		}
		
	}
	
	private  String cursoAcademico(String fechaMatri) {
		
		int aux = Integer.parseInt(fechaMatri.split(" ")[0].split("/")[2]);
		
		return aux + "/" + (aux+1) ;
	}

	
 
}
