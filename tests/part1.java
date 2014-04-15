package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import FP.SearchProgram;

public class part1 {
	
	static SearchProgram search;

	@BeforeClass
	public static void firstSetUp() throws Exception{
		search = new SearchProgram();
	}
	
	@Test
	public void testConfigFile() {
		fail("Not yet implemented");
	}

}
