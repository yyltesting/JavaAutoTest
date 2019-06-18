package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exlx {
	//定义文件输入流
		FileInputStream fs;
		//定义poi文件系统
//		POIFSFileSystem ps;
		//定义工作簿
		XSSFWorkbook wb;
		//定义sheet页
		XSSFSheet st;
		//定义row
		XSSFRow rows;
		//定义cell
		XSSFCell cell;
		//定义字符串
		String value;
		
		public String readCell(String exlname,int i ,int j){
			try {
				//实例化文件
				fs=new FileInputStream("D:\\我的东西\\等价类实践.xlsx");
				//实例化工作簿
				wb=new XSSFWorkbook(fs);
				//实例化页
				st=wb.getSheet(exlname);
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
		Exlx e=new Exlx();
		System.out.println(e.readCell("sheet1", 0, 3));

	}

}
