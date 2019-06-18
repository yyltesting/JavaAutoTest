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
	//�����ļ�������
		FileInputStream fs;
		//����poi�ļ�ϵͳ
		POIFSFileSystem ps;
		//���幤����
		HSSFWorkbook wb;
		//����sheetҳ
		HSSFSheet st;
		//����row
		HSSFRow rows;
		//����cell
		HSSFCell cell;
		//�����ַ���
		String value;
		
		public String readCell(String sheetName,int hang,int danyuange){
			List<List<String>> list=new ArrayList<>();
			try {
				//ʵ�����ļ�
				fs=new FileInputStream("D:\\book1.xls");
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
