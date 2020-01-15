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
	
	public static String ReadCell(String sheetname,int i ,int j){
		try {
			//ʵ�����ļ�
			fs=new FileInputStream("E:\\213Ppm�Զ�����������\\�Զ�����������.xls");
			//ʵ����poi
			ps=new POIFSFileSystem(fs);
			//ʵ����������
			wb=new HSSFWorkbook(ps);
			//ʵ����ҳ
			st=wb.getSheet(sheetname);
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadExl cExl = new ReadExl();
		System.out.println(ReadExl.ReadCell("bodyParam", 1, 2));
//		Map<String, String> baseParam = new HashMap<String, String>();
	}

}
