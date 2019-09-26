package com.one;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class NegaBinaryTest {

	@Test
	public void testSolutionNotNull() {
				
		int a[] = {1,0,0,1,1,1};
		NegaBinary.solution(a);
		Assert.assertNotNull(a);
	}
	
	@Test
	public void testSolutionCorrectAnswer() {
		
		int a[] = {1,0,0,1,1,1};
		int b[] = {1,1,0,1,0,1,1};
		int [] rest = NegaBinary.solution(a);	
		Assert.assertEquals(true, Arrays.equals(b, rest));
		}

}
