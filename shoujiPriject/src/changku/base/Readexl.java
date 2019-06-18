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
			
			public static String readCell(String sheetName,int hang,int danyuange){
				List<List<String>> list=new ArrayList<>();
				try {
					//实例化文件
					fs=new FileInputStream("D:\\java+selenium\\南网自动化用例2.xls");
					//实例化poi
					ps=new POIFSFileSystem(fs);
					//实例化工作簿
					wb=new HSSFWorkbook(ps);
					//实例化页
					st=wb.getSheet(sheetName);
					//实例化行
					for(int j=0;j<=st.getLastRowNum();j++){
					rows=st.getRow(j);
					//实例化单元格(列)
					List<String> listrow=new ArrayList<>();
					for(int i=0;i<=rows.getLastCellNum();i++){
						cell=rows.getCell(i);
					if(cell==null){
						continue;
					}
					cell.setCellType(CellType.STRING);
					//获取内容
					value=cell.getStringCellValue();
					listrow.add(value);
//					System.out.print(value+" ");
					}
					list.add(listrow);
//					System.out.println("");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(list.get(hang).get(danyuange).equals(null)) {
					return "";
				}else {
					return list.get(hang).get(danyuange);
				}
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Readexl e=new Readexl();
		System.out.println(e.readCell("Sheet3", 5, 5));
		


	}

}
