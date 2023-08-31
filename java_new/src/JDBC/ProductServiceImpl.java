package JDBC;

//중간 작업
import java.util.ArrayList;

public class ProductServiceImpl implements Service {
	
	private DAO dao;//DAO 인터페이스(아직 안만듬)
	public ProductServiceImpl() {
		dao = new ProductDAOImpl();//DAO 구현체
	}
	@Override
	//register
	public int register(Product p) {
		// 실제 구현 영역
		System.out.println("register_service success!!");
		//dao에서 사용되는 메서드명은 DB구문과 비슷하게 하는것이 일반적
		return dao.insert(p);
	}
	@Override
	//list
	public ArrayList<Product> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}
	@Override
	//detail
	public Product detail(int pno) {
		System.out.println("detail_service success!!");
		return dao.selectOne(pno);
	}
	@Override
	//modify
	public int modify(Product p) {
		System.out.println("modify_service success!!");
		return dao.update(p);
	}
	@Override
	//remove
	public int remove(int pno) {
		System.out.println("delete_service success!!");
		return dao.delete(pno);
	}


}
