package changku.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;

import test.ReadwpsExl;

public class Readexl {
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

public static String readCell(String sheetname,int i ,int j){
try {
	//实例化文件
	fs=new FileInputStream("D:\\尹彦力仓库\\book1.xls");
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Readexl e=new Readexl();
//		System.out.println(e.readCell("Sheet3", 5, 5));
		


	}

}
