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
			//�����ļ�������
		public static 	FileInputStream fs;
			//����poi�ļ�ϵͳ
		public static 	POIFSFileSystem ps;
			//���幤����
		public static 	HSSFWorkbook wb;
			//����sheetҳ
		public static 	HSSFSheet st;
			//����row
		public static 	HSSFRow rows;
			//����cell
		public static 	HSSFCell cell;
			//�����ַ���
		public static 	String value;
			
			public static String readCell(String sheetName,int hang,int danyuange){
				List<List<String>> list=new ArrayList<>();
				try {
					//ʵ�����ļ�
					fs=new FileInputStream("D:\\java+selenium\\�����Զ�������2.xls");
					//ʵ����poi
					ps=new POIFSFileSystem(fs);
					//ʵ����������
					wb=new HSSFWorkbook(ps);
					//ʵ����ҳ
					st=wb.getSheet(sheetName);
					//ʵ������
					for(int j=0;j<=st.getLastRowNum();j++){
					rows=st.getRow(j);
					//ʵ������Ԫ��(��)
					List<String> listrow=new ArrayList<>();
					for(int i=0;i<=rows.getLastCellNum();i++){
						cell=rows.getCell(i);
					if(cell==null){
						continue;
					}
					cell.setCellType(CellType.STRING);
					//��ȡ����
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
