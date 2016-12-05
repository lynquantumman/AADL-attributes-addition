package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyReliabilityAddition {
	public void addPropertyReliability(){
		FileReader fin = null;
		FileWriter fout = null;
		BufferedReader bufreader = null;
		BufferedWriter bufwriter = null;
		String line = null;
		String name = null;
		Properties prop = new ReliabilityProperties().get();
		
			try {
				fin = new FileReader("N:/615/DIMA3_5.aadl");
				bufreader = new BufferedReader(fin);
				fout = new FileWriter("N:/615/DIMA3_5_reliability.aadl");
				bufwriter = new BufferedWriter(fout);
				Line2CertainString line2CertainString = new Line2CertainString();
				while(null!=(line=bufreader.readLine())){

					bufwriter.write(line,0,line.length());
					bufwriter.newLine();
					name = line2CertainString.line2String(line,prop);
					if(!("".equals(name))){
						bufwriter.write("properties");
						bufwriter.newLine();
						bufwriter.write(" Architecture_Analysis::Comprel => "+prop.get(name)+";");
						bufwriter.newLine();
						bufwriter.write("Architecture_Analysis::AnalyPnt => 0;");
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
