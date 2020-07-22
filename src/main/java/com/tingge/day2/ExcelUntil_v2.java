package com.tingge.day2;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelUntil_v2 {

    /**
     *@Description
     *@Param [excelPath, row 行号，列号  ]
     *@Return java.lang.Object[][]
     */
    public static Object[][] datas(String excelPath,int [] rows,int [] cells){

        //获取workbook对象
        Object[][] datas = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            //获取sheet 对象
            Sheet sheet = workbook.getSheet("sheet1");
            // 定义保存的数组
            datas = new Object[rows.length][cells.length];
            //通过循环获取每一行
            for (int i = 0; i <rows.length ; i++) {
                // 根据行索引取出第一行
                Row row = sheet.getRow(rows[i]-1);
                for (int j = 0; j <cells.length ; j++) {
                    // 获取列  Row.MissingCellPolicy.CREATE_NULL_AS_BLANK  解决xsl 空值为null.
                    // 传的列号需要减1，传索引不需要
                    Cell cell = row.getCell(cells[j]-1);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    datas[i][j] =value;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static void main(String[] args) {
        int [] rows = {2,3,4,5};
        int [] cells = {6,7};
        Object[][] datas1 = datas("src/main/resources/cases.xls",rows,cells);
        for (Object[] values : datas1) {
            for (Object value : values) {
                System.out.print("【"+value+"】");
            }
            System.out.println();
        }
    }
}


