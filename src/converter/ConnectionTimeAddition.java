package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConnectionTimeAddition {
	public void addConnectionTime(){
		FileReader fin = null;
		FileWriter fout = null;
		BufferedReader bufreader = null;
		BufferedWriter bufwriter = null;
		String line = null;
		Properties prop = new ConnectionTimeProperties().get();
		PartTobeAdded partTobeAdded = new PartTobeAdded();
		try {
			fin = new FileReader("N:/615/DIMA1_1_real_time.aadl");
			bufreader = new BufferedReader(fin);
			fout = new FileWriter("N:/615/DIMA1_1_real_time_connTime.aadl");
			bufwriter = new BufferedWriter(fout);
			while(null!=(line=bufreader.readLine())){

				bufwriter.write(partTobeAdded.line2String(line,prop));
				bufwriter.newLine();
				
				
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
