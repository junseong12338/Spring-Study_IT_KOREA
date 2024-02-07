package dao;

import java.util.List;

public interface BoradDAO {
	
	// dao 는 기본적으로 CRUD 기능을 가지고 있다.
	
	int insert(Object ob);
	
	List<Object> selectList();
	int update(Object ob);
	int delete(int idx);
}
