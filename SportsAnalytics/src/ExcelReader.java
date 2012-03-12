

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelReader {

	private Tournament t;
	private String inputFile;

	public ExcelReader(Tournament t){
		this.t = t;
	}
	
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void read() throws IOException  {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			Team[] teamArr = new Team[64];
			
			int j=0;
			//System.out.println("Rows: " + sheet.getRows());
			//System.out.println(sheet.getCell(0,3).getContents());
			
			for (int i =2; i< sheet.getRows(); i++){
				//teamArr[i-2] = new Team(sheet.getCell(j,i).getContents(), null, Integer.parseInt(sheet.getCell(j+1,i).getContents()), Integer.parseInt(sheet.getCell(j+2,i).getContents()), Integer.parseInt(sheet.getCell(j+3,i).getContents()), Integer.parseInt(sheet.getCell(j+4,i).getContents()));
				j=0;
			}
			/*
			int i=0;
			while (teamArr[i+1]!=null && i<62){
				System.out.println(teamArr[i].toString());
				i++;
			}
			System.out.println(teamArr[teamArr.length-1].toString());
			*/
			t.setTeamArray(teamArr);

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	public Tournament getT() {
		return t;
	}

	public void setT(Tournament t) {
		this.t = t;
	}



}


