package com.capgemini.salesmanagement.service;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.dao.ISaleDAO;
import com.capgemini.salesmanagement.dao.SaleDAO;
import com.capgemini.salesmanagement.exceptions.InvalidSaleIdException;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class SaleService implements ISaleService{
	ISaleDAO saleDao = new SaleDAO();
	String prodCategory;
	
	@Override
	public HashMap<Integer, Sale> insertSaleDetails(Sale sale) throws InvalidSaleIdException {
		//int saleId = CollectionUtil.generateSaleId();
		//sale.setSaleId(saleId);
		LocalDate localDate = LocalDate.now();
		sale.setSaleDate(localDate);
		return saleDao.insertSaleDetails(sale) ;
		
	}

	@Override
	public boolean validateProductCode(int productId) {
		if(productId <1005 && productId >1000)
			return true;
		else
			return false;
	}

	@Override
	public boolean validateQuantity(int qty) {
		if(qty>0 && qty<5)
			return true;
		else 
			return false;
	}

	@Override
	public boolean validateProductCat(String prodCat) {
		if(prodCat.equalsIgnoreCase("Electronics")) { 
			prodCategory = prodCat;
			return true;
		}
		else if(prodCat.equalsIgnoreCase("Toys")) {
			prodCategory = prodCat;
			return true;
		}
		    
		else 
			return false;
	}

	@Override
	public boolean validateProductName(String prodName) {
		if(prodCategory.equalsIgnoreCase("Electronics")) {
			if(prodName.equalsIgnoreCase("TV")) 
				return true;
			else if(prodName.equalsIgnoreCase("Smart Phone"))
				return true;
			else if(prodName.equalsIgnoreCase("Video Game"))
				return true;
			else
				return false;
		}
		else if(prodCategory.equalsIgnoreCase("Toys")) {
			if(prodName.equalsIgnoreCase("Soft Toy")) 
				return true;
			else if(prodName.equalsIgnoreCase("Telescope"))
				return true;
			else if(prodName.equalsIgnoreCase("Barbee Doll"))
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public boolean validateProductPrice(float price) {
		if(price >200)
			return true;
		else 
			return false;
	}

	@Override
	public float calculateLineTotal(float prodPrice, int prodQuan) {
		return prodPrice*prodQuan;
	}

	@Override
	public void getAllSaleDetails() {
		HashMap<Integer, Sale> allSaleMap = new HashMap<Integer, Sale>();
		allSaleMap = CollectionUtil.getCollection();
		if(allSaleMap.isEmpty())
			System.out.println("SALE RECORD IS EMPTY");
		else {
			Iterator it = allSaleMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue().toString());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		}
			
		
	}

}
