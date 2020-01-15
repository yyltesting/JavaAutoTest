package PpmUiTest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;


public class ReadExl {
				//定义文件输入流
			public static 	FileInputStream fs;
				//定义poi文件系统
			public static 	POIFSFileSystem ps;
				//定义工作簿
			public static 	HSSFWorkbook wb;
				//定义sheet页
			public static 	HSSFSheet st;
				//定义row
			public static 	HSSFRow rows;
				//定义cell
			public static 	HSSFCell cell;
				//定义字符串
			public static 	String value;
	
	public static String ReadCell(String sheetname,int i ,int j){
		try {
			//实例化文件
			fs=new FileInputStream("E:\\213Ppm自动化测试用例\\自动化测试用例.xls");
			//实例化poi
			ps=new POIFSFileSystem(fs);
			//实例化工作簿
			wb=new HSSFWorkbook(ps);
			//实例化页
			st=wb.getSheet(sheetname);
			//实例化行
			rows=st.getRow(i);
			//实例化单元格(列)
			cell=rows.getCell(j);
			if(cell==null){
				return "";
			}else{
			cell.setCellType(CellType.STRING);
			//获取内容
			value=cell.getStringCellValue();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadExl cExl = new ReadExl();
		System.out.println(ReadExl.ReadCell("bodyParam", 1, 2));
//		Map<String, String> baseParam = new HashMap<String, String>();
	}

}
