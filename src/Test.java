import java.util.List;
import java.util.Scanner;

import com.mydata.dao.ProductDao;
import com.mydata.dao.ProductDaoImpl;
import com.mydata.model.Product;
import com.mydata.util.CreateConnection;

public class Test {
	
	public static boolean loop = true;

	public static void main(String[] args) {

		ProductDao pd = new ProductDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		while(loop) {
		System.out.println("1.save Product");
		System.out.println("2.update Product");
		System.out.println("3.delete Product");
		System.out.println("4.view Product by id");
		System.out.println("5.view all Product");
		System.out.println("6.close the connection");

		System.out.println("Enter your choice");
		int ch = sc.nextInt();

		switch (ch) {

		case 1:
			System.out.println("Enter the id , name , cost, quantity");

			Product p = new Product(sc.nextInt(), sc.next(), sc.nextFloat(), sc.nextInt());

			int x = pd.saveProduct(p);

			System.out.println(x + " rows inserted");
			break;

		case 2:
			System.out.println("Enter the id and cost");

			int i = sc.nextInt();
			float c = sc.nextFloat();

			String status = pd.updateProduct(i, c);

			if (status.equals("success"))
				System.out.println("row updated");
			else
				System.out.println("something wrong");

			break;

		case 3:

			System.out.println("Enter the id");
			i = sc.nextInt();
			x = pd.deleteProduct(i);

			System.out.println(x + " rows are deleted");
			break;

		case 4:
			System.out.println("Enter the id");
			i = sc.nextInt();
			Product p1 = pd.fetchById(i);
			System.out.println(p1);
			break;

		case 5:
			List<Product> pList = pd.fetchAllProduct();

			for (Product pp : pList) {
				System.out.println(pp);
			}
			break;
		case 6:
			try {
				CreateConnection.initConnection().close();
				System.out.println("Connection Closed");
				loop = false;
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		}

		sc.close();

	}

}
