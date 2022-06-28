package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char condition = sc.next().charAt(0);
			condition = Character.toUpperCase(condition);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(condition == 'I') {
				System.out.print("Customs fee: ");
				double customsF = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsF)); 
			}
			else if(condition == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, date));
			}
			else {
				product.add(new Product(name, price));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : product) {
			System.out.println(prod.priceTag());
		}
	
		sc.close();

	}

}
