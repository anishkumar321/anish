package com.filehandling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileHandling {

	public static void main(String[] args)throws Exception {
		File file=new File("B:\\Test File handling\\abc.txt");
		FileInputStream fis=new FileInputStream(file);
		StringBuilder sb=new StringBuilder("");
		int i=0;
		do {
			i=fis.read();
					if(i!=-1)
						sb.append((char)i);
		}while(i!=-1);
        fis.close();
        
        System.out.println("READING DONE !!");
        
        File f=new File("B:\\Test File handling\\writefile.txt");
		FileOutputStream fos=new FileOutputStream(f);
		fos.write(sb.toString().getBytes());                   
		fos.flush();
		fos.close();
		System.out.println("WRIING DONE !!");
	}
}
