package htht.system.ocean.conpany.project;
 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import htht.system.ocean.util.FileUtil;
import htht.system.ocean.util.JSONUtils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * excel表格转成json
 * @ClassName: Excel2JSONHelper  
 * @Description:TODO(这里用一句话描述这个类的作用)  
 * @author LiYonghui
 * @date 2017年1月6日 下午4:42:43
 */
public class Excel2JSONHelper {
  //常亮，用作第一种模板类型，如下图
  private static final int HEADER_VALUE_TYPE_Z=1;
  //第二种模板类型，如下图
  private static final int HEADER_VALUE_TYPE_S=2;
  @Autowired
  public  MongoTemplate mongoTemplate;
  public static void main(String[] args) {




  }



 
  /**
   *
   * 获取一个实例
   */
  public static Excel2JSONHelper getExcel2JSONHelper(){
    return new Excel2JSONHelper();
  }
 
  /**
   * 文件过滤
   * @Title: fileNameFileter  
   * @Description: TODO(这里用一句话描述这个方法的作用)  
   * @param:  
   * @author LiYonghui  
   * @date 2017年1月6日 下午4:45:42
   * @return: void   
   * @throws
   */
  private boolean fileNameFileter(File file){
    boolean endsWith = false;
    if(file != null){
      String fileName = file.getName();
      endsWith = fileName.endsWith(".xls") || fileName.endsWith(".xlsx");
    }
    return endsWith;
  }
 
  /**
   * 获取表头行
   * @Title: getHeaderRow  
   * @Description: TODO(这里用一句话描述这个方法的作用)  
   * @param: @param sheet
   * @param: @param index
   * @param: @return 
   * @author LiYonghui  
   * @date 2017年1月6日 下午5:05:24
   * @return: Row   
   * @throws
   */
  private Row getHeaderRow(Sheet sheet, int index){
    Row headerRow = null;
    if(sheet!=null){
      headerRow = sheet.getRow(index);
    }
    return headerRow;
  }
 
  /**
   * 获取表格中单元格的value
   * @Title: getCellValue  
   * @Description: TODO(这里用一句话描述这个方法的作用)  
   * @param: @param row
   * @param: @param cellIndex
   * @param: @param formula
   * @param: @return 
   * @author LiYonghui  
   * @date 2017年1月6日 下午5:40:28
   * @return: Object   
   * @throws
   */
  private Object getCellValue(Row row,int cellIndex,FormulaEvaluator formula){
    Cell cell = row.getCell(cellIndex);
    if(cell != null){
      switch (cell.getCellType()) {
      //String类型
      case Cell.CELL_TYPE_STRING:
        return cell.getRichStringCellValue().getString();
 
       //number类型
      case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
          return cell.getDateCellValue().getTime();
        } else {
          return cell.getNumericCellValue();
        }
      //boolean类型
      case Cell.CELL_TYPE_BOOLEAN:
        return cell.getBooleanCellValue();
      //公式  
      case Cell.CELL_TYPE_FORMULA:
        return formula.evaluate(cell).getNumberValue();
      default:
        return null;
      }
    }
    return null;
  }
 
  /**
   * 获取表头value
   * @Title: getHeaderCellValue  
   * @Description: TODO(这里用一句话描述这个方法的作用)  
   * @param: @param headerRow
   * @param: @param cellIndex 英文表头所在的行，从0开始计算哦
   * @param: @param type 表头的类型第一种 姓名（name）英文于实体类或者数据库中的变量一致
   * @param: @return 
   * @author LiYonghui  
   * @date 2017年1月6日 下午6:12:21
   * @return: String   
   * @throws
   */
  private String getHeaderCellValue(Row headerRow,int cellIndex,int type){
    Cell cell = headerRow.getCell(cellIndex);
    String headerValue = null;
    if(cell != null){
      //第一种模板类型
      if(type == HEADER_VALUE_TYPE_Z){
        headerValue = cell.getRichStringCellValue().getString();
        int l_bracket = headerValue.indexOf("（");
        int r_bracket = headerValue.indexOf("）");
        if(l_bracket == -1){
          l_bracket = headerValue.indexOf("(");
        }
        if(r_bracket == -1){
          r_bracket = headerValue.indexOf(")");
        }
        headerValue = headerValue.substring(l_bracket+1, r_bracket);
      }else if(type == HEADER_VALUE_TYPE_S){
      //第二种模板类型
        headerValue = cell.getRichStringCellValue().getString();
      }
    }
    return headerValue;
  }
 
  /**
   * 读取excel表格
   * @Title: readExcle
   * @Description: TODO(这里用一句话描述这个方法的作用)
   * @param: @param file
   * @param: @param headerIndex
   * @param: @param headType 表头的类型第一种 姓名（name）英文于实体类或者数据库中的变量一致
   * @author LiYonghui
   * @date 2017年1月6日 下午6:13:27
   * @return: void
   * @throws
   */
  public JSONArray readExcle(File file,int headerIndex,int headType){
    List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
    if(!fileNameFileter(file)){
      return null;
    }else{
      try {
        //加载excel表格
        WorkbookFactory wbFactory = new WorkbookFactory();
        Workbook wb = wbFactory.create(file);
        //读取第一个sheet页
        Sheet sheet = wb.getSheetAt(0);
        //读取表头行
        Row headerRow = getHeaderRow(sheet, headerIndex);
        //读取数据
        FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
        for(int r = headerIndex+1; r<= sheet.getLastRowNum();r++){
          Row dataRow = sheet.getRow(r);
          Map<String, Object> map = new HashMap<String, Object>();
          for(int h = 0; h<dataRow.getLastCellNum();h++){
            //表头为key
            String key1 = getHeaderCellValue(headerRow,h,headType);

            String reg = "[^\u4e00-\u9fa5]";
         String   key= key1.replaceAll(reg, "");
            //数据为value
            Object value = getCellValue(dataRow, h, formula);
            if(!key.equals("") && !key.equals("null") && key != null ){
              map.put(key, value);
            }
          }
          lists.add(map);
        }

      } catch (Exception e) {

        System.out.println("加载"+file.getPath()+"失败");
        e.printStackTrace();
      }
    }
    JSONArray jsonArray = (JSONArray) JSON.toJSON(lists);
    return jsonArray;
  }
}