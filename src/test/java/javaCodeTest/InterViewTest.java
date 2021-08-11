package javaCodeTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.bcel.generic.Select;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ups.nj.supperpage.CucumberBaseClass;

public class InterViewTest extends CucumberBaseClass{
	static String password = "";
	// How to find out duplicate element / number
	public static void duplicateNum() {
		// Initialize array
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9 };
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (set.add(array[i]) == false) {
				System.out.println("Duplicate number is a  : " + array[i]);
			}
		}
	}

	// How to remove duplicate element / number
	public static void removeDuploicateNum() {
		// input list with duplicate
		List<Integer> num = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9));
		System.out.println("List of value is a : " + num);
		List<Integer> newNum = num.stream().distinct().collect(Collectors.toList());
		System.out.println("New List value is a : " + newNum);
	}

	// How to find out missing element / number
	public static void missingNumber() {
		// Initialize array
		int[] array = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				System.out.println(array[i] + 1 + " Missing number");
				break;
			}
		}
	}

	// How to find out the palindrome number
	public static void checkPalindrome() {
		String palindrome = "454";
		// Reverse the given string
		String reverse = new StringBuffer(palindrome).reverse().toString();
		// Check whether the string is palindroum or not
		if (palindrome.equals(reverse)) {
			System.out.println("Yes, it is a palindroume number;");
		} else {
			System.out.println("No, it is not a palindroume number;");
		}
	}
	
	
	

	// How to find even number
	public static void evenAndOddNumber() {
		// declare the integer variable
		int num = 30;

		// if conditions to check if the reminder is zero
		if (num % 2 == 0) {

			// if reminder is zero then this a even num
			System.out.println(" This is a Even Number : " + num);
		}

		else {
			// if reminder is not zero then this a odd num
			System.out.println(" This is a odd Number : " + num);
		}

	}

	// How to remove special characters ?
	public static void removeSpecialCharacters() {
		String value = "My#Nmae%Is^Mohammed*Alam&$.";
		value = value.replaceAll("[^a-zA-Z0-9]", " ");
		System.out.println(value);

		String num = "10,500.99";
		num = num.replaceAll("\\W+", " ");
		System.out.println(num);
	}

	// How to find out the prime number?
	public static void isPrimeNumber() {
		int limit = 100;
		System.out.println("Prime number between 1 and : " + limit);
		// loop through the number one by one
		for (int i = 1; i < 100; i++) {
			boolean isPrime = true;
			// check to see if the number is prime
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.println("This is a Prime Num : " + i + " ");
		}
	}

	// How to write data in excel or upload data in excel from web element or text
	// Create a workbook object
	// Create a sheet in workbook
	// Create a row in sheet
	// Add cells in sheet
	// Repeat step 3 and 4 to write more data by map family

	public static void writeExcel() {

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Smarttech");
		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "FIRSTNAME", "LASTNAME" });
		data.put("2", new Object[] { 101, "Ansar", "Mehmood" });
		data.put("3", new Object[] { 102, "Badrul", "Rahman" });
		data.put("4", new Object[] { 103, "Imam", "Mahdi" });
		data.put("5", new Object[] { 104, "Korshed", "Alam" });

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String Key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objarr = data.get(Key);

			int cellnum = 0;
			for (Object obj : objarr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);

				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
		FileOutputStream out = new FileOutputStream(new File ("Student.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Student.xlsx written successfully on disk");
		}
		catch (Exception e) {
        	e.getMessage();
        }
	}
	// How to find second highest  number
	public static void secondHighestNumber() {

		   int array[] = { 100, 20, 306, 40, 50, 60 };
		
		   int size = array.length;
		   System.out.println(size);  // Find out the length
		   
		   Arrays.sort(array);  //Sort the value by sort method 
		   System.out.println(Arrays.toString(array));
		   	   
		  int res  = array[size - 2];
		  System.out.println("my 2nd largest number  is a: " + res);
		  
	}
	
	// SSN DOB ADDRESS	
	public static void myPassword() {
	byte [] encodedString = Base64.encodeBase64(password.getBytes());
	System.out.println(encodedString);
		
	byte [] decoedString = Base64.decodeBase64(password);
	System.out.println(decoedString);
			 
	}
	
	public static String decodingString(String password) {
		byte [] decoedString = Base64.decodeBase64(password);
		return (new String (decoedString));
	}
	

	// Created for generating random string for Unique email
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
		return (generatedString1);
	}

	// Created for generating random string for Unique email
	public static String randomNumeric() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	

	

	public static void main(String[] args) {	
		System.out.println(randomNumeric());
		//myPassword();
	//driver.findElement(By.xpath("")).sendKeys(InterViewTest.decodingString(password));	
		// duplicateNum();
		// removeDuploicateNum();
		// missingNumber();
		// checkPalindrome();
		// evenAndOddNumber();
		// removeSpecialCharacters();
		// isPrimeNumber();
		// writeExcel();
		
	
	}
}
