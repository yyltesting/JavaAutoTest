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
	//�����ļ�������
		FileInputStream fs;
		//����poi�ļ�ϵͳ
//		POIFSFileSystem ps;
		//���幤����
		XSSFWorkbook wb;
		//����sheetҳ
		XSSFSheet st;
		//����row
		XSSFRow rows;
		//����cell
		XSSFCell cell;
		//�����ַ���
		String value;
		
		public String readCell(String exlname,int i ,int j){
			try {
				//ʵ�����ļ�
				fs=new FileInputStream("D:\\�ҵĶ���\\�ȼ���ʵ��.xlsx");
				//ʵ����������
				wb=new XSSFWorkbook(fs);
				//ʵ����ҳ
				st=wb.getSheet(exlname);
				//ʵ������
				rows=st.getRow(i);
				//ʵ������Ԫ��(��)
				cell=rows.getCell(j);
				if(cell==null){
					return "";
				}else{
				cell.setCellType(CellType.STRING);
				//��ȡ����
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
