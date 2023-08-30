package JDBC;


import java.util.ArrayList;

public interface Service {

	int register(Product p);

	ArrayList<Product> list();

	Product detail(int pno);

}
