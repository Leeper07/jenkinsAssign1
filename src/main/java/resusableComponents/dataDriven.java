package resusableComponents;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	//Method
	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> alist=new ArrayList<String>();
		//FileInputStream argument
		FileInputStream file=new FileInputStream("C:\\Users\\sdetjavamind05\\OneDrive\\testData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workBook=new XSSFWorkbook(file);
		
		int sheets=workBook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workBook.getSheetName(i).equalsIgnoreCase("datatest")) {
				XSSFSheet sheet=workBook.getSheetAt(i);
				//Identify the testcases column by scanning the entire 1st row
				Iterator<Row> rows= sheet.iterator();
				
				Row firstRow=rows.next();
				
				Iterator<Cell> cell= firstRow.cellIterator();
				int k=0;
				int column=0;
				while(cell.hasNext()) {
					Cell value= cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("test cases"))
					{
						//Desired Column
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				//Once column is identified then scan entire column to identify the row
				while(rows.hasNext()) {
					Row r=rows.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("searchstring"))
					{
						//After you grab the testcase row pull all the data of that row and feed into test
						Iterator<Cell> innerCell= r.cellIterator();
						while(innerCell.hasNext()) {
							Cell c=innerCell.next();
							if(c.getCellTypeEnum()==CellType.STRING) {
							alist.add(c.getStringCellValue());
						}else {
							alist.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
						}	
					}
				}
			}
		}
		return alist;
	}

}
