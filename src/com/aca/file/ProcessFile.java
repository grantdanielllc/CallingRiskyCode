package com.aca.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ProcessFile {

	public static void main(String[] args) {
	
		ProcessFile processFile = new ProcessFile();
		
//		processFile.displayFiles();
//		
		FileReader reader = processFile.getReader("c:/users/daniel/dan.txt");
		if (null != reader) {
			processFile.readFile(reader);
		}
		
//		processFile.userInput();
	}

	private void displayFiles() {
		
		File file = new File("c:/users/daniell");
		System.out.println("exists? : " + file.exists());
		System.out.println("is file? : " + file.isFile());
		System.out.println("is directory? :" + file.isDirectory());
		
		File[] files = file.listFiles(); //will return null if this is not a directory
		
		//risky behavior, if files == null, runtime exception
		for (File myFile : files) {
			if (myFile.isFile()) {
				System.out.println(myFile.getName());
			}
		}	
		
	}
	
//	 https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
	// checked exception, the compiler forces you into action
	
	private FileReader getReader(String path) {
		FileReader fileReader = null;	
		
		try {
			fileReader = new FileReader(path);
		} catch (FileNotFoundException e) {			
			System.out.println(e.getMessage());
		}
		return fileReader;
	}
	
	private void readFile(FileReader reader) {	
		
		Scanner scanner = new Scanner(reader);
		String line = null;
		int totalWords = 0;
		
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			String[] words = line.split(" ");
			totalWords = totalWords + words.length;
			System.out.println("line: " + line);
		} 
		
		System.out.println("total words: " + totalWords);
		
	}
	
	//runtime exception, the compiler does not force you to do something
	
	private void userInput() {
		
		String input = "10";
		
		
		
		Integer i = Integer.valueOf(input);
		
	}
	
	

}
