package es.uma.informatica.ejb.tarea2;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import es.uma.informatica.ejb.excepciones.AlumnoExistenteExpection;
import es.uma.informatica.ejb.excepciones.ExpedientesExistenteExpection;
import es.uma.informatica.ejb.excepciones.MatriculaExistenteExpection;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Matricula;


/**
 * Session Bean implementation class ExcelEJB
 */
@Stateless
public class ExcelEJB implements GestionExcel {
	
	private String excelPath = "/home/alumno/Escritorio/SII/Proyecto_SII-2021/DatosAlumnadoFAKE.xlsx";
	private XSSFWorkbook wB;
	private XSSFSheet sheet;
	SimpleDateFormat frm;
	private EntityManager em;

	
	
	private String nombreAux;
	private Alumno al;
	private Matricula matr;
	private Expedientes exp;
	
	public ExcelEJB() {
		try {
			wB =  new XSSFWorkbook(excelPath);
			sheet = wB.getSheet("Hoja1");
			frm = new SimpleDateFormat("dd/mm/yyyy HH:mm");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Object getCellData() {
		
		DataFormatter fm = new DataFormatter();
		Object value = fm.formatCellValue(sheet.getRow(1).getCell(0));
		return value;
	}
	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	
	public void insertExcelData() throws MatriculaExistenteExpection, AlumnoExistenteExpection, ExpedientesExistenteExpection {
		
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
				insertMatricula(matr);
				
				System.out.println("***************");
			}
			
			
		}
		

	}
	
	private void insertMatricula(Matricula matr2) throws MatriculaExistenteExpection {
		Matricula mtrExist = em.find(Matricula.class, new Matricula.MatriculaId(matr2.getCurso_academico(),exp.getNum_Expediente()));
		if(mtrExist != null) {
			throw new MatriculaExistenteExpection();
		}
		em.persist(matr2);
		
	}

	private void insertExpediente(Expedientes exp2) throws ExpedientesExistenteExpection {
		Expedientes alExist = em.find(Expedientes.class, exp2.getNum_Expediente());
		if(alExist != null) {
			throw new ExpedientesExistenteExpection();
		}
		em.persist(exp2);
		
	}

	private void insertAlumno(Alumno al2) throws AlumnoExistenteExpection {
		Alumno alExist = em.find(Alumno.class, al2.getID());
		if(alExist != null) {
			throw new AlumnoExistenteExpection();
		}
		em.persist(al2);
		
		
	}

	private static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
	
	private void setCellData(Cell cell, int nColum) {
		
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
			matr.setNum_Archivo(Integer.valueOf(cell.toString()));
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
			al.setTelefono(Integer.valueOf(cell.toString()));
			break;
		case 9:
			System.out.println("MOVIL: "+ cell.toString());
			al.setMovil(Integer.valueOf(cell.toString()));
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
				System.out.println("ERROR");
			}
			
			break;
		case 15:
			System.out.println("TURNO_PREFERENTE: "+ cell.toString());
			matr.setTurno_Preferente(cell.toString());
			break;
		case 16:
			System.out.println("GRUPOS_ASIGNADOS: "+ cell.toString());
			//TODO
			break;
		case 17:
			System.out.println("NOTA_MEDIA: "+ cell.toString());
			exp.setNota_Media_Provisional(cell.getNumericCellValue());
			break;
		case 18:
			System.out.println("CREDITOS_SUPERADOS: "+ cell.toString());
			exp.setCreditos_superados(Integer.valueOf(cell.toString()));
			break;
		case 19:
			System.out.println("CREDITOS_FB: "+ cell.toString());
			exp.setCreditos_FB(Integer.valueOf(cell.toString()));
			break;
			
		case 20:
			System.out.println("CREDITOS_OB: "+ cell.toString());
			exp.setCreditos_OB(Integer.valueOf(cell.toString()));
			break;
		case 21:
			System.out.println("CREDITOS_OP: "+ cell.toString());
			exp.setCreditos_OP(Integer.valueOf(cell.toString()));
			break;
		case 22:
			System.out.println("CREDITOS_CF: "+ cell.toString());
			exp.setCreditos_CF(Integer.valueOf(cell.toString()));
			break;
		case 23:
			System.out.println("CREDITOS_PE: "+ cell.toString());
			exp.setCreditos_PE(Integer.valueOf(cell.toString()));
			break;
		case 24:
			System.out.println("CREDITOS_TF: "+ cell.toString());
			exp.setCreditos_TF(Integer.valueOf(cell.toString()));
			break;		
				

		default:
			System.out.println("Error"+ cell.toString());
			break;
		}
		
	}
	
	private String cursoAcademico(String fechaMatri) {
		
		int aux = Integer.parseInt(fechaMatri.split(" ")[0].split("/")[2]);
		
		return aux + "/" + (aux+1) ;
	}

	
 
}




