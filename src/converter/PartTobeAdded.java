package converter;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTobeAdded {
	public String line2String(String line, Properties prop){
//		prop 里的键是正则，值是时间
		Set<String> regexes = prop.stringPropertyNames();
		Iterator<String> iter = regexes.iterator(); 
		Pattern p;
		Matcher m;
		StringBuilder sb = null;
		while(iter.hasNext()){
			String name = iter.next();
			p = Pattern.compile(name);
			m = p.matcher(line);
			if(m.matches()){
				sb = new StringBuilder(line);
				String stringPart = "{RealtimeProperty::ProcessTime => "+
				prop.get(name)+";}";
				sb.insert(line.length()-1,stringPart);
				
				return new String(sb);
			}
			
		}
		return line;
	}
}
