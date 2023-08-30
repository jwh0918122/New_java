package JDBC;

import java.util.ArrayList;

public interface DAO {

	int insert(Product p);

	ArrayList<Product> selectList();

	Product selectOne(int pno);

}
