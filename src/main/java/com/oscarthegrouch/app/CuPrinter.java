package com.oscarthegrouch.app;

import java.io.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class CuPrinter {

    public static String cuPrint(){
        // creates an input stream for the file to be parsed
        try{
		FileInputStream in = new FileInputStream("/home/oscar14/test.java");
		System.out.println("Shit worked yo");
		// parse the file
		CompilationUnit cu = JavaParser.parse(in);
      		// prints the resulting compilation unit to default system output
     		return cu.toString();
	}
	catch(FileNotFoundException err){
		System.out.println("File not found");
		return "Shit didn't work yo";
	}
    }
}
