package com.oscarthegrouch.app;

import java.io.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class CuPrinter {

    public static String cuPrint(){
	String TableName = "";
	String[] tableNameExtractor;//used to manipulate the string before storing it in TableName
        try{
		FileInputStream in = new FileInputStream("/home/oscar14/test.java");
		System.out.println("Shit worked yo");
		CompilationUnit cu = JavaParser.parse(in);
		String[] tokens = cu.toString().split("@");//split the string by @ symbols used to denote annotations
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].indexOf("Table")!=-1){
				tableNameExtractor=tokens[i].split("\\(");
				tableNameExtractor=tableNameExtractor[1].split("\\)");//table name is wrapped in brackets, remove brackets
				tableNameExtractor=tableNameExtractor[0].split("\"");//table name is wrapped in quotes, remove quotes
				tableNameExtractor=tableNameExtractor[1].split("\"");
				TableName=tableNameExtractor[0];
			}
		}
     		return TableName;
	}
	catch(FileNotFoundException err){
		System.out.println("File not found");
		return "Shit didn't work yo";
	}
    }
}
