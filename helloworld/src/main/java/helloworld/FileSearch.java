package helloworld;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class FileSearch {

	public static boolean checkFileName(File dirName) {
		if (dirName.getName().equals("vik.txt")) {
			System.out.println("file found at " + dirName.getAbsolutePath());
			return true;
		}
		return false;
	}

	public static void searchFile(File dirName) {
		File[] filesInDirectory = dirName.listFiles();
		if (filesInDirectory != null) {
			for (File fileEntry : filesInDirectory) {
				if (!fileEntry.isHidden()) {

					if (fileEntry.isDirectory()) {
						searchFile(fileEntry);
					} else {
						if (checkFileName(fileEntry))
							return;
					}
				}
			}
		}
	}

	public static void search(String fileName) throws IOException, InterruptedException {
		for (Path root : FileSystems.getDefault().getRootDirectories()) {
			File file = new File(root.toString());
			/*
			 * As we dont have multiple drives so i am considering all folders in C as
			 * drives
			 */
			File[] filesInDirectory = file.listFiles();
			for(File file1 : filesInDirectory) {
			(new Thread(new MyRunnable(file1))).start();
				//(new Thread(()->FileSearch.searchFile(file1))).start();
			}
		//	Thread.currentThread().sleep(Timer.ONE_MINUTE);
			//searchFile(file);
		}
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		long startTime=System.nanoTime();
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter file name to search in all drives");

		String inputFileName = sc.nextLine();

		if (!inputFileName.isEmpty()) {
			search(inputFileName);

		}
long endTime=System.nanoTime();
long timeElapsed=endTime-startTime;
System.out.println("Execution time in milliseconds : " + 
		timeElapsed / 1000000);
		if (sc != null)
			sc.close();
	}

}

class MyRunnable implements Runnable {
	private File path;
	MyRunnable(File path) {
		this.path = path;
	}
	public void run() {
		FileSearch.searchFile(this.path);
	}
}
