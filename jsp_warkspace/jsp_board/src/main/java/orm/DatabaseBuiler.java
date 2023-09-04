package orm;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseBuiler {

	private static SqlSessionFactory factory;
	private static final String config = "orm/MybatisConfig.xml";

	// 초기화 블럭을 사용하여 객체 생성 후 초기화
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(config));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
