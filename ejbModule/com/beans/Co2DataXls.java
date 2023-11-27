package com.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entities.Co2Emission;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.servlet.ServletContext;

@Singleton
@Startup
public class Co2DataXls {
	
	public static void main(String[] args) {
		

	     List<Co2Emission> countriesData = new ArrayList<>();
	        List<String> years = new ArrayList<>();
	        try {
	            FileInputStream file = new FileInputStream(new File("/attests/co2-emissions-data.xlsx"));
	            Workbook workbook = new XSSFWorkbook(file);
	            Sheet sheet = workbook.getSheetAt(0);

	            // Read years from the first row
	            Row firstRow = sheet.getRow(0);
	            for (int i = 1; i < firstRow.getLastCellNum(); i++) {
	                Cell cell = firstRow.getCell(i);
	                years.add(cell.toString());
	            }

	            // Read country data from subsequent rows
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                String countryName = row.getCell(0).toString();
	                for (int j = 1; j < row.getLastCellNum(); j++) {
	                    Cell cell = row.getCell(j);
		                countriesData.add(new Co2Emission(years.get(j - 1), countryName, Double.parseDouble(cell.toString()) ,false));
	                }
	            }


	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
	}

	    
		       
		    


}
