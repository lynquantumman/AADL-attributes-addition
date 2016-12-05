package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyTimeAddition {
	public void addPropertyTime(){
		FileReader fin = null;
		FileWriter fout = null;
		BufferedReader bufreader = null;
		BufferedWriter bufwriter = null;
		String line = null;
		String name = null;
		Properties prop = new TimeProperties().get();
		
			try {
				fin = new FileReader("N:/615/DIMA1_1.aadl");
				bufreader = new BufferedReader(fin);
				fout = new FileWriter("N:/615/DIMA1_1_real_time.aadl");
				bufwriter = new BufferedWriter(fout);
				Line2CertainString line2CertainString = new Line2CertainString();
				while(null!=(line=bufreader.readLine())){

					bufwriter.write(line,0,line.length());
					bufwriter.newLine();
					name = line2CertainString.line2String(line,prop);
					if(!("".equals(name))){
						bufwriter.write("properties");
						bufwriter.newLine();
						bufwriter.write(" RealtimeProperty::ProcessTime => "+prop.get(name)+";");
						bufwriter.newLine();
					}
					
				}
				bufwriter.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(fin!=null){
					try {
						fin.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fout!=null){
					try {
						fout.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(bufreader!=null){
					try {
						bufreader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(bufwriter!=null){
					try {
						bufwriter.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}
