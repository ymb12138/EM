package com.muyi.util;


import com.muyi.pojo.Event;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2020/10/22 0022.
 */
public class util  {


    public static void WriteExcel(List<Event> list) {
            String[] s = {"编号","内容","级别","创建时间","截止时间"};
           File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
           String desktopPath = desktopDir.getPath();
        String path = desktopPath.replace("\\", "/");

        String excelPath = path+"/待办事项.xls";
            Workbook workbook = null;
            try {
                  // XSSFWorkbook used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
                 workbook = new HSSFWorkbook();// XSSFWorkbook();//WorkbookFactory.create(inputStream);
               } catch (Exception e) {
                 System.out.println("创建Excel失败: ");
                 e.printStackTrace();
               }
           if (workbook != null) {
               Sheet sheet = workbook.createSheet("测试数据");
                //设置列宽
               sheet.setColumnWidth(0, 10*256);
               sheet.setColumnWidth(1, 30*256);
               sheet.setColumnWidth(2, 8*256);
               sheet.setColumnWidth(3, 17*256);
               sheet.setColumnWidth(4, 17*256);
                Row row0 = sheet.createRow(0);
                for (int i = 0; i < 5; i++) {
                    Cell cell = row0.createCell(i);
                    cell.setCellValue(s[i]);
                }
                for (int rowNum = 1;rowNum <= list.size();rowNum++) {
                    System.out.println(list.size());
                    Row row = sheet.createRow(rowNum);
                    row.createCell(0).setCellValue(list.get(rowNum-1).getId().toString());
                    row.createCell(1).setCellValue(list.get(rowNum-1).getEvent());
                    row.createCell(2).setCellValue(list.get(rowNum-1).getLevelStr());
                    row.createCell(3).setCellValue(list.get(rowNum-1).getStartDateStr());
                    row.createCell(4).setCellValue(list.get(rowNum-1).getEndDateStr());
                }
               try {
                   FileOutputStream outputStream = new FileOutputStream(excelPath);
                   workbook.write(outputStream);
                   outputStream.flush();
                   outputStream.close();
               } catch (Exception e) {
                   System.out .println("写入Excel失败: ");
                   e.printStackTrace();
               }


           }
        }

        @Test
    public void tt(){
            File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
            String desktopPath = desktopDir.getAbsolutePath();
            System.out.print(desktopPath);
        }
}
