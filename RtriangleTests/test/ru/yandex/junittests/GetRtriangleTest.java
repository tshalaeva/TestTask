package ru.yandex.junittests;

import ru.yandex.rtriangle.*;
import static org.junit.Assert.*;
import org.junit.*;

public class GetRtriangleTest {

	private static Rtriangle rtriangle;
	
	private double a, b, c;
	
	@BeforeClass
	public static void initializeTriangle() {
		rtriangle = new RightTriangle();
	}
	
	@Before
	public void getSides() {
		a = Math.pow(rtriangle.getApexX1() - rtriangle.getApexX2(), 2) + Math.pow(rtriangle.getApexY1() - rtriangle.getApexY2(), 2);
		b = Math.pow(rtriangle.getApexX1() - rtriangle.getApexX3(), 2) + Math.pow(rtriangle.getApexY1() - rtriangle.getApexY3(), 2);
		c = Math.pow(rtriangle.getApexX2() - rtriangle.getApexX3(), 2) + Math.pow(rtriangle.getApexY2() - rtriangle.getApexY3(), 2);
		
		if(c < a) {
			double tmp = c;
			c = a;
			a = tmp;
		}
		
		if(c < b) {
			double tmp = c;
			c = b;
			b = tmp;
		}
	}
		
	@Test
	public void TriangleIsRight() {
		if(a == 0 || b == 0 || c == 0) {
			System.out.println("It is not a triangle");
			fail();
		}
		double sum = a + b;
		assertEquals(c, sum, 0);
	}

}
