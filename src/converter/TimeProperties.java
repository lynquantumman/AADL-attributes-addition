package converter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TimeProperties {
	public Properties get(){
		Properties prop = new Properties();//���Լ��϶���      
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("N:/615/real_time.properties");
			prop.load(fis);//�������ļ���װ�ص�Properties������    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�����ļ���      
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
