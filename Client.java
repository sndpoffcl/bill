package com.capgemini.salesmanagement.ui;

import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.exceptions.InvalidSaleIdException;
import com.capgemini.salesmanagement.service.*;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class Client {

	public static void main(String[] args) {
		ISaleService services = new SaleService();
		boolean flag = true;
		int switchKey;
		HashMap<Integer,Sale> saleMap = new HashMap<Integer, Sale>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t *********BILLING SOFTWARE APPLICATION********");
		while(flag) {
			System.out.println("KINDLY CHOSE AN OPTION: ");
			System.out.println("1. GET DETAILS OF A PRODUCT ");
			System.out.println("2. DO BILLING");
			System.out.println("3. GET SALES RECORD");
			System.out.println("4. EXIT");
			switchKey = sc.nextInt();
			switch(switchKey) {
			case 1 : System.out.println("THIS FEATURE IS CURRENTLY IN DEVELOPMENT(out of scope)");
					 break;
			
			case 2 : System.out.println("\t\t*******BILLING******");
					 // entering product code
					 System.out.println("Please enter the product code");
					 int prodCode = sc.nextInt();
					 if(services.validateProductCode(prodCode)) 
						 System.out.println("ACCEPTED : PRODUCT CODE -> " + prodCode);
					 else {
						 System.out.println("PLEASE ENTER VALID PRODUCT CODE, EXITING FROM CURRENT STATE");
						 break;
					 }
					 //enter product quantity
					 System.out.println("Please enter the quantity");
					 int prodQuan = sc.nextInt();
					 if(services.validateQuantity(prodQuan)) 
						 System.out.println("ACCEPTED : PRODUCT QUANTITY -> " + prodQuan);
					 else {
						 System.out.println("PLEASE ENTER VALID PRODUCT QUANTITY, EXITING FROM CURRENT STATE");
						 break;
					 }
					 //enter product category
					 System.out.println("Please enter the  product category");
					 String prodCat = sc.next();
					 if(services.validateProductCat(prodCat)) 
						 System.out.println("ACCEPTED : PRODUCT CATEGORY -> " + prodCat);
					 else {
						 System.out.println("PLEASE ENTER VALID PRODUCT CATEGORY, EXITING FROM CURRENT STATE");
						 break;
					 }
					 //enter product name
					 sc.nextLine();
					 System.out.println("Please choose the product name");
					 String prodName = sc.nextLine();
					 if(services.validateProductName(prodName)) 
						 System.out.println("ACCEPTED : PRODUCT NAME -> " + prodName);
					 else {
						 System.out.println("PLEASE ENTER VALID PRODUCT NAME, EXITING FROM CURRENT STATE");
						 break;
					 }
					 //enter product model name
					 sc.nextLine();
					 System.out.println("Please enter product model name");
					 String prodModelName = sc.nextLine();
					 //enter product price 
					 System.out.println("Enter the price of the product");
					 float prodPrice = sc.nextFloat();
					 if(services.validateProductPrice(prodPrice)) 
						 System.out.println("ACCEPTED : PRODUCT PRICE -> " + prodPrice);
					 else {
						 System.out.println("PLEASE ENTER VALID PRODUCT PRICE, EXITING FROM CURRENT STATE");
						 break;
					 }
					 //calculate line total
					 float lineTotal = services.calculateLineTotal(prodPrice,prodQuan);
					 //get saleId and create sale object
					 int saleId = CollectionUtil.generateSaleId();
					 Sale newSale = new Sale(saleId,prodCode,prodQuan,prodCat,prodName,lineTotal);
					 //save sale object
					 try {
						 saleMap = services.insertSaleDetails(newSale);
					 } catch (InvalidSaleIdException e) {
						 System.out.println(" PLEASE TRY AGAIN");
						 break;
					 }
					 System.out.println("\t\t*******SALE DETAILS*******");
					 System.out.println("PRODUCT CODE : " + saleMap.get(saleId).getProdCode() );
					 System.out.println("PRODUCT QUANTITY : " + saleMap.get(saleId).getQuantity() );
					 System.out.println("PRODUCT CATEGORY : " + saleMap.get(saleId).getCategory() );
					 System.out.println("PRODUCT NAME : " + saleMap.get(saleId).getProductName() );
					 System.out.println("PRODUCT MODEL NAME : " +  prodModelName);
					 System.out.println("PRODUCT PRICE : " + prodPrice );
					 System.out.println("LINE TOTAL : " + saleMap.get(saleId).getLineTotal() ); 
					 System.out.println(saleMap.get(saleId).toString());
					 //case 2 ends here
					 break;
					 
			case 3 : System.out.println("\t\t ****BILLING RECORDS****");
					 services.getAllSaleDetails();
					 break;
			 		 
			case 4 : System.out.println("EXITING FROM APPLICATION");
			   		 flag=false;
			   		 break;
			   
			default : System.out.println("PLEASE ENTER A VALID OPTION");
			 		  break;
		
			}
		} 
		
		sc.close();
	}

}
