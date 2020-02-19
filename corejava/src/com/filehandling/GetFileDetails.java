package com.filehandling;

import java.io.File;
import java.sql.Timestamp;
import java.io.File;

public class GetFileDetails {

	public static void main(String[] args) {
		String path="B:\\Test File handling";
		File file=new File("B:\\Test File handling");
		String filelist[]=file.list();
		for(int i=0;i<filelist.length;i++) {
			System.out.println("File Name : "+filelist[i]);
			file=new File(path+filelist[i]);
			System.out.println("File Size : "+file.length()/(long)1024+"KB");
			System.out.println("File Date : "+file.getPath());
			System.out.println("File Read : "+file.canRead());
			System.out.println("File Write : "+file.canWrite());
			System.out.println("File Last Modified : "+file.lastModified());
			System.out.println("File is file : "+file.isFile());
			System.out.println("\n \n");
		}

	}

}
