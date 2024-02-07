package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_mybatis;
import context.Context_2_dao;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//AbstractAnnotationConfigDispatcherServletInitializer
	//���������� �����ϴ� Ŭ������ �� ���ø����̼��� �ʱ�ȭ�� ���� ���� ����� �����Ѵ�.
	//�� Ŭ������ ����ϸ� �ڹ� ��� ���� Ŭ������ �̿��Ͽ� DispatcherServlet �� ContextLoaderListener�� ����� �� �ִ�.
	//�̸� ���� web.xml�� ������� �ʰ� �� ���ø����̼��� �ʱ�ȭ�� ������ �� �ִ�.
	//�ش� Ŭ������ ��ӹ޾� �ʿ��� ������ �������̵� �Ͽ� ����Ѵ�.
	

	//getRootConfigClasses()
	//������Ʈ�� �� ���� ������ ����Ѵ�.
	//�����ͺ��̽� ����Ǯ(DBCP), Mybatis, Mybatis���� ��� ���� ���� ������ ����ϴ� �޼���
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { Context_1_mybatis.class,Context_2_dao.class };
	}
	// .class : Ŭ���� ���ͷ� Ŭ���� ����ü�� ���� �ϴ� ����
	
	//DispatcherServlet�� ����� ���� Ŭ������ ��ȯ�Ѵ�.
	//Spring MVC �� ���� ������ ����Ѵ�.
	//VIEW�� Controller ���� ������ ����ϴ� �޼���
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletContext.class };

	}
	
	//DispatcherServlet�� URL ������ �����Ѵ�.
	//��� ��û�� ó���ϵ��� "/"�� �����Ǿ��ִ�.
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	// Client�� ��û�� Servlect�� �����ϱ� ���̳� �Ŀ� �䫊 �� ���� �����͸� �����ϰų�
	// �߰� �۾��� �����ϴµ� ���Ǵ� �ڹ� ������Ʈ�� �ǹ��Ѵ�.
	@Override
	protected Filter[] getServletFilters() {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);

    return new Filter[] { characterEncodingFilter };
	}
}
