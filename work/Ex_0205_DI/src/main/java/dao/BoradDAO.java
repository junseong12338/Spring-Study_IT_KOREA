package dao;

import java.util.List;

public interface BoradDAO {
	
	// dao �� �⺻������ CRUD ����� ������ �ִ�.
	
	int insert(Object ob);
	
	List<Object> selectList();
	int update(Object ob);
	int delete(int idx);
}
