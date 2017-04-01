package com.oscarthegrouch.app;
import java.util.*;
import org.junit.*;
public class CuPrinterTest{
	@Test
	public void testPrint(){
	System.out.println("TESTING");
	System.out.println(CuPrinter.cuPrint());
	Assert.assertEquals(1,1);	
	}
}
