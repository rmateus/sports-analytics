

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelReader {

	private BracketGUI t;
	private File inputFile;

	public ExcelReader(BracketGUI bracketGUI){
		this.t = bracketGUI;
	}
	
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public Team[] read() throws IOException  {
		//File inputWorkbook = new File(inputFile);
		File inputWorkbook = inputFile;
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			Team[] teamArr = new Team[64];

			int j=0;
			int i;
			//Global.season = 2;
			if (Global.season == 2012){
				for (i=67; i< 131; i++){
					teamArr[i-67] = new Team(sheet.getCell(j,i).getContents(), Integer.parseInt(sheet.getCell(j+1,i).getContents()),
							Double.parseDouble(sheet.getCell(j+2,i).getContents()), Double.parseDouble(sheet.getCell(j+3,i).getContents()),
							Double.parseDouble(sheet.getCell(j+4,i).getContents()), Double.parseDouble(sheet.getCell(j+5,i).getContents()),
							Double.parseDouble(sheet.getCell(j+6,i).getContents()), Double.parseDouble(sheet.getCell(j+7,i).getContents()),
							Double.parseDouble(sheet.getCell(j+8,i).getContents()), Double.parseDouble(sheet.getCell(j+9,i).getContents()),
							Double.parseDouble(sheet.getCell(j+10,i).getContents()), Integer.parseInt(sheet.getCell(j+11,i).getContents()));
					j=0;
				}
			}
			else {
				for (i=2; i< 66; i++){
					teamArr[i-2] = new Team(sheet.getCell(j,i).getContents(), Integer.parseInt(sheet.getCell(j+1,i).getContents()),
							Double.parseDouble(sheet.getCell(j+2,i).getContents()), Double.parseDouble(sheet.getCell(j+3,i).getContents()),
							Double.parseDouble(sheet.getCell(j+4,i).getContents()), Double.parseDouble(sheet.getCell(j+5,i).getContents()),
							Double.parseDouble(sheet.getCell(j+6,i).getContents()), Double.parseDouble(sheet.getCell(j+7,i).getContents()),
							Double.parseDouble(sheet.getCell(j+8,i).getContents()), Double.parseDouble(sheet.getCell(j+9,i).getContents()),
							Double.parseDouble(sheet.getCell(j+10,i).getContents()), Integer.parseInt(sheet.getCell(j+11,i).getContents()));
					j=0;
				}
			}
			return teamArr;
			/*
			int i=0;
			while (teamArr[i+1]!=null && i<62){
				System.out.println(teamArr[i].toString());
				i++;
			}
			System.out.println(teamArr[teamArr.length-1].toString());
			 */
			//t.setTeamArray(teamArr);

		} catch (BiffException e) {
			e.printStackTrace();
		}
		return null;
	}

}


