package com.tingge.day3;


import com.tingge.Until.caseUntil;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelUntilv0 {
    /**
     *@Description
     *@Param [excelPath, startRow 传的行号而非索引, endRow, startCell 传的列号而非索引, endCell]
     *@Return java.lang.Object[][]
     */
    public static Object[][] datas(String excelPath,int startRow,int endRow,int startCell,int endCell){

        //获取workbook对象
        Object[][] datas = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            //获取sheet 对象
            Sheet sheet = workbook.getSheet("sheet1");
            // 获取行
            datas = new Object[endRow - startRow +1 ][endCell-startCell+1];
            for (int i = startRow; i <=endRow ; i++) {
                // 传的行号需要减1，传索引不需要
                Row row = sheet.getRow(i-1);
                for (int j = startCell; j <=endCell ; j++) {
                    // 获取列  Row.MissingCellPolicy.CREATE_NULL_AS_BLANK  解决xsl 空值为null.
                    // 传的列号需要减1，传索引不需要
                    Cell cell = row.getCell(j-1);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    datas[i-startRow][j-startCell] =value;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }
    /**
     *@Description
     *@Param [excelPath, rows 行号，cells列号  ]
     *@Return java.lang.Object[][]
     */
    public static Object[][] datas(String excelPath,String ShteetName,int [] rows,int [] cells){

        //获取workbook对象
        Object[][] datas = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            //获取sheet 对象
            Sheet sheet = workbook.getSheet(ShteetName);
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



    // sheetName 表单名
    public static void load(String excelPath,String sheeName) {
        //创建WorkBook对象
        Class<Case>  clazz = Case.class;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            Sheet sheet = workbook.getSheet(sheeName);
            //获取第一行
            Row titleRow = sheet.getRow(0);
            //获取最后一列的列号 返回的是int
            int lastCellNum = titleRow.getLastCellNum();
            String [] filed = new String[lastCellNum];
            for (int i = 0; i < lastCellNum; i++) {
                //根据索引获取对应的列
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                //获取列的类型为字符串
                cell.setCellType(CellType.STRING);
                //获取列的值
                String title = cell.getStringCellValue();
                title = title.substring(0,title.indexOf("("));
                filed[i] = title;

            }
            int lastRowNumIndex = sheet.getLastRowNum();
            //循环处理每一个数据
            for (int i = 1; i <= lastRowNumIndex; i++) {
                Case cs = (Case) clazz.newInstance();
                //拿到第一行数据
                Row dataRow = sheet.getRow(i);
                if (dataRow == null||isEmptyRow(dataRow)){
                    continue;
                }
                //拿到此行的每一列
                for (int j = 0; j < lastCellNum; j++) {

                    Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    //获取要反射的方法名
                    String methodName = "set" + filed[j];
                    //获取要反射的方法对象
                    Method method = clazz.getMethod(methodName, String.class);
                    method.invoke(cs,value);
                }
//                System.out.println(cs);
                //
                caseUntil.cases.add(cs);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取sheet对象
        //获取行
        //获取列
    }

    private static boolean isEmptyRow(Row dataRow){
        int lastCellNum = dataRow.getLastCellNum();
        for (int j = 0; j < lastCellNum; j++) {
            Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue();
            if (value!=null&&value.trim().length()>0){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        load("src/main/resources/casesV1.xlsx","login");
        int [] rows = {2,3,4,5,6,7,8,9,10};
        int [] cells = {1,4};
        Object[][] datas1 = datas("src/main/resources/casesV1.xlsx","login",rows,cells);
        for (Object[] values : datas1) {
            for (Object value : values) {
                System.out.print("【"+value+"】");
            }
            System.out.println();
        }
    }




}
