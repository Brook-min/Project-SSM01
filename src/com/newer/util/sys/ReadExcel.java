package com.newer.util.sys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.newer.pojo.sys.Keepon;

public class ReadExcel {

    // 总行数
    private int totalRows = 0;
    // 总条数
    private int totalCells = 0;
    // 错误信息接收器
    private String errorMsg;

    // 构造方法
    public ReadExcel() {
    }

    // 获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    // 获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    // 获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     *
     * @param fielName
     * @return
     */
    public List<Keepon> getExcelInfo(CommonsMultipartFile Mfile, HttpSession session) {

        // 1.获取文件的实际名称
        String originalFilename = Mfile.getOriginalFilename();

        String PreName = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        String path = session.getServletContext().getRealPath("/upload");
        // 文件夹
        File file = new File(path);
        // 创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists())
            file.mkdirs();
        // 新建一个文件
        File file1 = new File(path + "/" + PreName + new Date().getTime() + ".xlsx");
        // 将上传的文件写入新建的文件中
        try {
            Mfile.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 初始化客户信息的集合
        List<Keepon> keeponList = new ArrayList<Keepon>();
        // 初始化输入流
        InputStream is = null;
        try {
            // 验证文件名是否合格
            if (!validateExcel(originalFilename)) {
                return null;
            }
            // 根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(originalFilename)) {
                isExcel2003 = false;
            }
            // 根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            // 根据excel里面的内容读取客户信息
            keeponList = getExcelInfo(is, isExcel2003, session);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return keeponList;
    }

    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public List<Keepon> getExcelInfo(InputStream is, boolean isExcel2003, HttpSession session) throws ParseException {
        List<Keepon> empList = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            // 当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            // 读取Excel里面客户的信息
            empList = readExcelValue(wb, session);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empList;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     * @throws ParseException
     */
    private List<Keepon> readExcelValue(Workbook wb, HttpSession session) throws ParseException {
        Keepon keepon = null;
        List<Keepon> keeponList = new ArrayList<Keepon>();
        XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(0);
        System.out.println("导入的记录行数：" + sheet.getLastRowNum());
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                continue;
            }
            keepon = new Keepon();
            XSSFCell cell = null;
            for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                String value = null;
                cell = row.getCell(columnIndex);
                if (cell != null) {
                    // 注意：一定要设成这个，否则可能会出现乱码
                    // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                if (date != null) {
                                    value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                } else {
                                    value = null;
                                }
                            } else {
                                value = new DecimalFormat("0").format(cell.getNumericCellValue());
                            }
                            break;
                        case XSSFCell.CELL_TYPE_FORMULA:
                            // 导入时如果为公式生成的数据则无值
                            if (!cell.getStringCellValue().equals("")) {
                                value = cell.getStringCellValue();
                            } else {
                                value = cell.getNumericCellValue() + "";
                            }
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            break;
                        case XSSFCell.CELL_TYPE_ERROR:
                            value = null;
                            break;
                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            value = (cell.getBooleanCellValue() == true ? "Y" : "N");
                            break;
                        default:
                            value = null;
                    }
                }
                if (columnIndex == 0 && value.trim().equals("")) {
                    break;
                }

                // excel表格中字段顺序为:用户名,密码,电话和地址,为方便起见假设字段一一对应
                if (columnIndex == 0) {
                    keepon.setStudentname(value);// 学员姓名
                } else if (columnIndex == 1) {
                    keepon.setSex(value); // 性别
                } else if (columnIndex == 2) {
                    keepon.setAge(Integer.parseInt(value));// 年龄
                } else if (columnIndex == 3) {
                    keepon.setTelephone(value);// 联系电话
                } else if (columnIndex == 4) {
                    keepon.setInfosource(value);// 信息来源
                } else if (columnIndex == 5) {
                    keepon.setMarketer(value);// 市场专员
                } else if (columnIndex == 6) {
                    keepon.setEducation(value);// 学历
                } else if (columnIndex == 7) {
                    keepon.setSchool(value);// 学校
                } else if (columnIndex == 8) {
                    keepon.setArea(value);// 所在区域
                } else if (columnIndex == 9) {
                    keepon.setAssociates(value); // 关联
                } else if (columnIndex == 10) {
                    keepon.setRelationship(value);// 关系
                } else if (columnIndex == 11) {
                    keepon.setQq(value);// qq号码
                } else if (columnIndex == 12) {
                    keepon.setConsultationperson(value);// 咨询师
                } else if (columnIndex == 13) {
                    keepon.setConsultationprocess(value);// 咨询进度
                } else if (columnIndex == 14) {
                    keepon.setConsultationtype(value);// 咨询分类
                } else if (columnIndex == 15) {
                    keepon.setSystem(value);// 课程体系
                } else if (columnIndex == 16) {
                    keepon.setDescription(value);// 备注
                }
            }
            UserSession user = (UserSession) session.getAttribute("userSession");
            keepon.setKeeponperson(user.getRealname());
            keepon.setKeepontime(new Date());
            keepon.setSchoolarea("牛耳校区");
            keeponList.add(keepon);
        }
        return keeponList;
    }

}
