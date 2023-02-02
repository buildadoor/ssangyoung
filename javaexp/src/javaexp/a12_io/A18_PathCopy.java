package javaexp.a12_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A18_PathCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orFile = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\a02_fold\\cpyFile01.txt";
		String tgFile = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\a03_fold\\showcpcpy.txt";
		Path orPath = Paths.get(orFile);
		Path tgPath = Paths.get(tgFile);
		try {

			Files.copy(orPath, tgPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String path = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io";
		 * File fold01 = new File(path + "\\a02_fold"); if (!fold01.exists())
		 * fold01.mkdir(); File fold02 = new File(path + "\\a03_fold"); if
		 * (!fold02.exists()) fold02.mkdir(); File file01 = new File(path +
		 * "\\a02_fold", "cpyFile01.txt"); try { if (!file01.exists())
		 * file01.createNewFile(); String orgFile = path + "\\a02_fold\\cpyFile01.txt";
		 * String tarFile = path + "\\a03_fold\\showcpcpy.txt"; Path oriPath =
		 * Paths.get(orgFile); Path copPath = Paths.get(tarFile);
		 * System.out.println("복사완료"); } catch (IOException e) { e.printStackTrace(); }
		 */
	}
}
