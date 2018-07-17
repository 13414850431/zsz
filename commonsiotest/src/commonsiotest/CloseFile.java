package commonsiotest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class CloseFile {
	public static void closeQuietly(Reader reader){
		if(reader!=null){
			 try {
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void closeQuietly(OutputStream outStream){
		if(outStream!=null){
			 try {
				 outStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void closeQuietly(InputStream inStream){
		if(inStream!=null){
			 try {
				 inStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void closeQuietly(OutputStreamWriter writer){
		if(writer!=null){
			 try {
				 writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void closeQuietly(BufferedWriter buffWriter){
		if(buffWriter!=null){
			 try {
				 buffWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
