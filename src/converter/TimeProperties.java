package converter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TimeProperties {
	public Properties get(){
		Properties prop = new Properties();//属性集合对象      
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("N:/615/real_time.properties");
			prop.load(fis);//将属性文件流装载到Properties对象中    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//属性文件流      
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
