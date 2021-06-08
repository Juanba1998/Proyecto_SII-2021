package es.uma.informatica.ejb.tarea2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import es.uma.informatica.jpa.tarea1.Expediente;
import es.uma.informatica.jpa.tarea1.Matricula;

@Stateless
public class ExcelEJB implements GestionExcel {
	
	
	private  XSSFSheet sheet;
	
	@PersistenceContext(name="trabajo")
	private  EntityManager em;

	private  String nombreAux;
	private  Alumno al;
	private  Matricula matr;
	private  Expediente exp;
	
	public ExcelEJB() {
		super();
	}

	@Override
	public  void insertExcelData(String excelPath, String sheetName) throws MatriculaExistenteException, AlumnoExistenteException, ExpedientesExistenteException {
		
		try (XSSFWorkbook wB =  new XSSFWorkbook(excelPath)){
			sheet = wB.getSheet(sheetName);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Iterator<Row> rowIt = sheet.iterator();
		
		int aux = 3;
		for(int i=0; i<=aux;i++) rowIt.next();
		
		while(rowIt.hasNext()) {
			
			int nColum = 0;
			Row row = rowIt.next();
			
			if(!isRowEmpty(row)) {
				
				al = new Alumno();
				exp = new Expediente();
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
		
		Matricula mtrExist = em.find(Matricula.class, new Matricula.MatriculaID(matr2.getCursoAcademico(),exp.getNumExpediente()));
		
		if(mtrExist != null)
			throw new MatriculaExistenteException();
		
		em.persist(matr2);	
	}

	private  void insertExpediente(Expediente exp2) throws ExpedientesExistenteException {
		
		Expediente alExist = em.find(Expediente.class, exp2.getNumExpediente());
		
		if(alExist != null)
			throw new ExpedientesExistenteException();
		
		em.persist(exp2);
		
	}

	private  void insertAlumno(Alumno al2) {
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
				al.setDni(cell.toString());
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
				al.setNombreCompleto(nombreAux);
				break;
			
			case 4:
				System.out.println("Nº EXPEDIENTE: "+ cell.toString());
				exp.setNumExpediente(Integer.valueOf(cell.toString()));
				break;
			
			case 5:
				System.out.println("Nº ARCHIVO: "+ cell.toString());
				Integer value;
			
				try {
					value = Integer.valueOf(cell.toString());
					matr.setNumArchivo(value);
				} catch (NumberFormatException e) {
					e.getMessage();
				}
			
				break;
			
			case 6:
				System.out.println("EMAIL_INSTITUCIONAL: "+ cell.toString());
				al.setEmailInstitucional(cell.toString());
				break;
			
			case 7:
				System.out.println("EMAIL_PERSONAL: "+ cell.toString());
				al.setEmailPersonal(cell.toString());
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
					matr.setFechaMatricula(cell.toString());
					//Curso Academico
					matr.setCursoAcademico(cursoAcademico(cell.toString()));
				
				} catch (Exception e) {
					System.out.println("Error en la fecha de matricula" + cell.toString());
				}
			
				break;
			
			case 15:
				System.out.println("TURNO_PREFERENTE: "+ cell.toString());
				matr.setTurnoPreferente(cell.toString());
				break;
			
			case 16:
				System.out.println("GRUPOS_ASIGNADOS: "+ cell.toString());
			
				List<String> aux = new ArrayList<>();
				for (String asg : cell.toString().split(",")) {
					aux.add(asg);
				}
			
				al.setGruposAsignados(aux);
				break;
			
			case 17:
				System.out.println("NOTA_MEDIA: "+ cell.toString());
				exp.setNotaMediaProvisional(Double.valueOf(cell.toString()));
				break;
			
			case 18:
				System.out.println("CREDITOS_SUPERADOS: "+ cell.toString());
				exp.setCreditosSuperados(Double.valueOf(cell.toString()));
				break;
			
			case 19:
				System.out.println("CREDITOS_FB: "+ cell.toString());
				exp.setCreditosFB(Double.valueOf(cell.toString()));
				break;
			
			case 20:
				System.out.println("CREDITOS_OB: "+ cell.toString());
				exp.setCreditosOB(Double.valueOf(cell.toString()));
				break;
			
			case 21:
				System.out.println("CREDITOS_OP: "+ cell.toString());
				exp.setCreditosOP(Double.valueOf(cell.toString()));
				break;
			
			case 22:
				System.out.println("CREDITOS_CF: "+ cell.toString());
				exp.setCreditosCF(Double.valueOf(cell.toString()));
				break;
			
			case 23:
				System.out.println("CREDITOS_PE: "+ cell.toString());
				//Integer.valueOf(cell.toString());
				exp.setCreditosPE(Double.valueOf(cell.toString()));
				break;
			
			case 24:
				System.out.println("CREDITOS_TF: "+ cell.toString());
				exp.setCreditosTF(Double.valueOf(cell.toString()));
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
