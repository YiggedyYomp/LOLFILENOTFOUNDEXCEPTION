package com.oscarthegrouch.app;

import java.io.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class CuPrinter {

    public static String cuPrint(){

	String TableName = "";
	String[] tableNameExtractor;//used to manipulate the string before storing it in TableName
	String[] referencedTableNameExtractor;//used to manipulate the string before printing it to the screen. Might need a variable to store these depending on we store the output. Just printing to the screen for now

        try{
		FileInputStream in = new FileInputStream("/home/oscar14/test.java");
		System.out.println("File successfully accessed");
		CompilationUnit cu = JavaParser.parse(in);
		String[] tokens = cu.toString().split("@");//split the string by @ symbols used to denote annotations

		//for loop for extracting table name
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].indexOf("Table")!=-1){
				tableNameExtractor=tokens[i].split("\\(");
				tableNameExtractor=tableNameExtractor[1].split("\\)");//table name is wrapped in brackets, remove brackets
				tableNameExtractor=tableNameExtractor[0].split("\"");//table name is wrapped in quotes, remove quotes
				tableNameExtractor=tableNameExtractor[1].split("\"");
				TableName=tableNameExtractor[0];
			}
		}

		System.out.println("Referenced Table names are: ");
		//for loop for extracting referenced tables
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].indexOf("ManyToOne")!=-1&&tokens[i+1].indexOf("JoinColumn")!=-1){
				referencedTableNameExtractor=tokens[i+1].split(";");
				referencedTableNameExtractor=referencedTableNameExtractor[referencedTableNameExtractor.length-2].split(" ");				
				System.out.println(referencedTableNameExtractor[referencedTableNameExtractor.length-1]);
			}
		}
		System.out.println("END OF REFERENCED TABLE NAMES");
		System.out.print("Table Name is: ");
     		return TableName;
	}
	catch(FileNotFoundException err){
		System.out.println("File not found");
		return "";
	}
    }
}
