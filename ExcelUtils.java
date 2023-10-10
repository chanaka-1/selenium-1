package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static HashMap<String, String> getexceldata(final String path, final String sheetname, final String rowid) {
		HashMap<String, String> DataMap = new HashMap<String, String>();
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		int iRowcounnt, icolumncount;

		try {
			fis = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			icolumncount = sheet.getRow(0).getLastCellNum();
			iRowcounnt = sheet.getLastRowNum();
			Row Headerrow = null;
			Headerrow = sheet.getRow(0);
			Row row = null;
			String celldata;

			for (int i = 1; i <= iRowcounnt; i++) {
				if (rowid.equalsIgnoreCase(sheet.getRow(i).getCell(0).getStringCellValue())) {
					row = sheet.getRow(i);
					for (int j = 1; j < icolumncount; j++) {
						celldata = "";
						if (row.getCell(j) != null) {
							switch (row.getCell(j).getCellType().name().toUpperCase()) {
							case "STRING":
								celldata = row.getCell(j).getStringCellValue();
								break;
							case "NUMERIC":
								celldata = String.valueOf(row.getCell(j).getNumericCellValue());
								break;
							case "BOOLEAN":
								celldata = String.valueOf(row.getCell(j).getBooleanCellValue());
								break;
							case "NONE":
								celldata = "";
								break;
							}
						}
						DataMap.put(Headerrow.getCell(j).getStringCellValue(), celldata);
						System.out.println("from Map:" + Headerrow.getCell(j).getStringCellValue() + ":"
								+ DataMap.get(Headerrow.getCell(j).getStringCellValue()) + "'");
					}
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					workbook.close();
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return DataMap;
	}

}
