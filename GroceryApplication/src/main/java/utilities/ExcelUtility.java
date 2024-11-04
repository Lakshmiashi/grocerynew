package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {
	
	
	static FileInputStream f;
	 static XSSFWorkbook w;
	 static XSSFSheet s; 
	 
	 public static  String getStringData(int row, int coloumn) throws IOException 
	 {
		 f=new FileInputStream("C:\\Users\\ASUS\\xlread\\salary.xlsx"); 
		 w = new XSSFWorkbook(f); 
		 s = w.getSheet("Sheet1"); 
		 XSSFRow r = s.getRow(row); 
		 XSSFCell c = r.getCell(coloumn);
		 return c.getStringCellValue(); 
	 }
	 
	 public static String getIntegerData(int a, int b) throws IOException // method to read integer data from excel
	 {
		 f = new FileInputStream("C:\\Users\\ASUS\\xlread\\salary.xlsx"); 
		 w = new XSSFWorkbook(f);
		 s = w.getSheet("Sheet1"); 
		 XSSFRow r = s.getRow(a); 
		 XSSFCell c = r.getCell(b);
		 int x = (int) c.getNumericCellValue(); //typecasting String to int.
		 return String.valueOf(x);
		 

	 }
}
