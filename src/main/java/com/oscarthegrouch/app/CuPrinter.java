package com.oscarthegrouch.app;

import java.io.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class CuPrinter {

    public static String cuPrint(){
	String TableName = "";
        // creates an input stream for the file to be parsed
        try{
		FileInputStream in = new FileInputStream("/home/oscar14/test.java");
		System.out.println("Shit worked yo");
		// parse the file
		CompilationUnit cu = JavaParser.parse(in);
      		// prints the resulting compilation unit to default system output
		String[] tokens = cu.toString().split("@");
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].indexOf("Table")!=-1){
				TableName=tokens[i];
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
