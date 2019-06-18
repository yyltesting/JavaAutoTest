package test;

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

public class ReadwpsExl {
	//定义文件输入流
		FileInputStream fs;
		//定义poi文件系统
		POIFSFileSystem ps;
		//定义工作簿
		HSSFWorkbook wb;
		//定义sheet页
		HSSFSheet st;
		//定义row
		HSSFRow rows;
		//定义cell
		HSSFCell cell;
		//定义字符串
		String value;
		
		public String readCell(String sheetName,int hang,int danyuange){
			List<List<String>> list=new ArrayList<>();
			try {
				//实例化文件
				fs=new FileInputStream("D:\\book1.xls");
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
//				System.out.print(value+" ");
				}
				list.add(listrow);
//				System.out.println("");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list.get(hang).get(danyuange);
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadwpsExl e=new ReadwpsExl();
		System.out.println(e.readCell("sheet2", 2, 2));

	}

}
