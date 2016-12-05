package converter;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line2CertainString {
	
	public String line2String(String line){
		
		Properties prop =  new ReliabilityProperties().get();
		Set<String> names = prop.stringPropertyNames();
		int total  = names.size();
		Pattern[] pArray = new Pattern[total];
		
		Matcher[] mArray = new Matcher[total];
		Iterator<String> iter = names.iterator();
		String name = "";
		int i = 0;
		for(i = 0;i<total;i++){
			name = iter.next();
			pArray[i] = Pattern.compile(".*implementation.*"+name+"[0-9]?");
//			System.out.println(name+i);
			mArray[i] = pArray[i].matcher(line);
			if(mArray[i].matches()){
//				System.out.println(name+"===="+prop.get(name));
				
				return name;
			}
		}

		return "";
		
	}
}
