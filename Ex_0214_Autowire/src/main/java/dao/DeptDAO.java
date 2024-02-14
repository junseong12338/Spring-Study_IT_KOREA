package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.DeptDTO;

@Repository("deptDAO") //dept_dao : ���� DeptDAO�� �ڵ������ϱ� ���� ��Ī
public class DeptDAO {

	// ������ ȣ�� ���� 
	// ��ü�� ������ ��
	public DeptDAO() {
		System.out.println("-----deptDAO �������� ȣ��-----");
	}
	
	@Autowired
	SqlSession sqlSession;
	
	
	// ��ü �μ� ��ȸ
	public List<DeptDTO> selectList(){
		return sqlSession.selectList("d.dept_list");
	}
}
