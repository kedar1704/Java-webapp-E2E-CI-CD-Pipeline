package com.mvc.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddserviceTest {
	

	Addservice as5 = new Addservice();


	@Test
	void testAdd() {
		float expected = 100;
		float actual = as5.add(50, 50);
		assertEquals(expected,actual);
	}

	@Test
	void testSubtract() {
		float expected1 = 0;
		float actual1 = as5.subtract(50, 50);
		assertEquals(expected1,actual1);
	}

	@Test
	void testMultiply() {
		float expected2 = 100;
		float actual2 = as5.multiply(10, 10);
		assertEquals(expected2,actual2);
	}

	@Test
	void testDivision() {
		float expected3 = 100;
		float actual3 = as5.division(500, 5);
		assertEquals(expected3,actual3);
	}

}
