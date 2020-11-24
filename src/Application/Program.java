package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
//teste
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		List<Product> list = new ArrayList<>();
		System.out.print("Enter the number of products:");
		//sc.nextLine();
		int n = sc.nextInt();
		for (int i=1;i<=n;i++) {
			System.out.println("Product #"+i+" data:");
			sc.nextLine();			
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (type=='i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);			
			}
			else if (type == 'u') {
				System.out.print("Manufacture date: ");
				sc.nextLine();
				Date manufactureDate = sdf.parse(sc.next());
				Product product = new UsedProduct(name, price, manufactureDate);
				list.add(product);
			}
			else {
				Product product = new Product(name, price);
				list.add(product);
			}
		
		}
		for (Product product : list) {
			System.out.println(product.priceTag());
		}		
		
	}

}
