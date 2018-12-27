package com.fluex404.apachepoiexcel;

import com.fluex404.apachepoiexcel.dao.SiswaDao;
import com.fluex404.apachepoiexcel.model.Siswa;
import com.fluex404.apachepoiexcel.plugin.MyPlugin;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


@SpringBootApplication
public class ApachepoiexcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApachepoiexcelApplication.class, args);

		try{

			/* Create and Insert */
			FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/fluex404/apachepoiexcel/store/siswa-data.xlsx"));
			HSSFWorkbook workbook = new HSSFWorkbook();
			List<Siswa> siswas = new SiswaDao().findall();
			HSSFSheet sheet = workbook.createSheet("Data Siswa");
			String[] columns = {"ID", "NAMA", "KELAS", "JURUSAN"};

			/* Header of Table */
			HSSFRow headerRow = sheet.createRow(0);
			for(int i=0;i<columns.length;i++) {
				HSSFCell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);

				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
                cell.getCellStyle().setRightBorderColor(IndexedColors.RED.getIndex());

                cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
                cell.getCellStyle().setLeftBorderColor(IndexedColors.RED.getIndex());

                cell.getCellStyle().setBorderTop(BorderStyle.THIN);
                cell.getCellStyle().setTopBorderColor(IndexedColors.RED.getIndex());

                cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
                cell.getCellStyle().setBottomBorderColor(IndexedColors.RED.getIndex());
			}

			/* Body of Table */
			for(int i=0;i < siswas.size();i++) {
			    HSSFRow row = sheet.createRow(i+1);
			    row.createCell(0).setCellValue(siswas.get(i).getId());
                row.createCell(1).setCellValue(siswas.get(i).getName());
                row.createCell(2).setCellValue(siswas.get(i).getKelas());
                row.createCell(3).setCellValue(siswas.get(i).getJurusan());
			}


			workbook.write(out);
			workbook.close();
//
//

//            /* Read of excel data */
//            FileInputStream in = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/fluex404/apachepoiexcel/store/siswa-data.xlsx"));
//            HSSFWorkbook workbook = new HSSFWorkbook(in);
//
//            System.out.println(workbook.getSheetAt(0)+" Terdeteksi !");
//            HSSFSheet sheet = workbook.getSheetAt(0);
//
//            for(int i=0;i<(new MyPlugin().Rowlength(sheet.rowIterator()));i++) {
//                if(i==0) {
//                    continue;
//                }
//
//                //get data
//                int id = (int)sheet.getRow(i).getCell(0).getNumericCellValue();
//                String nama = sheet.getRow(i).getCell(1).getStringCellValue();
//                String kelas = sheet.getRow(i).getCell(2).getStringCellValue();
//                String jurusan = sheet.getRow(i).getCell(3).getStringCellValue();
//
//                System.out.println("===========================");
//                System.out.println(id+" "+sheet.getRow(i).getCell(0).getCellType());
//                System.out.println(nama+" "+sheet.getRow(i).getCell(1).getCellType());
//                System.out.println(kelas+" "+sheet.getRow(i).getCell(2).getCellType());
//                System.out.println(jurusan+" "+sheet.getRow(i).getCell(3).getCellType());
//            }

            /* Make again */
//            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/fluex404/apachepoiexcel/store/belajar-style.xlsx"));
//            HSSFWorkbook workbook = new HSSFWorkbook();
//
//            HSSFSheet sheet = workbook.createSheet("Style Data");
//            HSSFRow row = sheet.createRow(1);
//            row.setHeight((short)800);
//            HSSFCell cell = row.createCell(1);
//            cell.setCellValue("test of merging");
//
//
//            //MEARGIN CELLS
//            //this statement for merging cells
//            sheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
//
//            //Make Style owner
//            HSSFCellStyle style = workbook.createCellStyle();
//            style.setAlignment(HorizontalAlignment.CENTER);
//            style.setVerticalAlignment(VerticalAlignment.CENTER);
//
//            cell.setCellStyle(style);
//
//            workbook.write(out);
//            workbook.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}

	}


}

