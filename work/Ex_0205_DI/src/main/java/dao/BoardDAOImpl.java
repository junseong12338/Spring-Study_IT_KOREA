package dao;

import java.util.*;


public class BoardDAOImpl implements BoradDAO{

	@Override
	public int insert(Object ob) {
		
		return 0;
	}

	@Override
	public List<Object> selectList() {
		List<Object> list = new ArrayList<Object>();
		list.add("����");
		list.add("���");
		list.add("����");
		list.add("������");
		return list;
	}

	@Override
	public int update(Object ob) {
		return 0;
	}

	@Override
	public int delete(int idx) {
		return 0;
	}
	
}
