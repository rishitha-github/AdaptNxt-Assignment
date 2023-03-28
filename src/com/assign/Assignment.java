package com.assign;

import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


//Product Name 
//
//Product Price 
//
//Item Number/ SKU/ Product Code 
//
//Model Number 
//
//Product Category 
//
//Product Description 
//
// 

		public class Assignment {

		    public static void main(String[] args) {
		        String url = "https://www.quill.com/hanging-file-folders/cbl/4378.html ";
		        String csvFilePath = "products.csv";
		        String[] headers = {"Product Name", "Product Price", "Item Number", "Model Number", "Product Category", "Product Description"};
		        try {
		            FileWriter csvWriter = new FileWriter(csvFilePath);
		            csvWriter.append(String.join(",", headers));
		            csvWriter.append("\n");

		            Document doc = Jsoup.connect(url).get();
		            Elements productCards = doc.select("div.row");

		            for (Element card : productCards) {
	                    String name = card.select("div.search-product-name-wrap a").text();
		                String price = card.select("div.pricing-wrap").text();
		                String itemNumber = card.select("div.LEffortFindNum").text();
		                String modelNumber = card.select("div.mb-2").text();
		                String category = card.select("div.category").text();
		                String description = card.select("div.js-skuBullets.body-xxs.mb-2.pb-1").text();
		                
                       System.out.printf(name,price,itemNumber,modelNumber,category,description);
		                String[] productDetails = {name, price, itemNumber, modelNumber, category, description};
		                csvWriter.append(String.join(",", productDetails));
		                csvWriter.append("\n");
		            }
		            
		            csvWriter.close();
		            System.out.println("Product details saved to " + csvFilePath);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		


