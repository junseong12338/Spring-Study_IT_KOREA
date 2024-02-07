package com.korea.first;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	
	public static void main(String[] args) throws Exception{
		// �������� �Ű����� ������ �ΰ��� ���
		// 1.  reflection API
		// ���� reflection API�� ���ؼ� �Ű������� �̸��� �������� �õ��Ѵ�.
		// 2 . Class File
		// 1. ��� �����ϸ� Ŭ���������� ���� �о �Ű������� �̸��� �����´�.
		
		// ClassŬ���� : Ŭ���� ������ ������ ���� Ŭ����
		// forName() : Ŭ������ ���ϸ��� ���ڷ� �־��ָ� �ش� Ŭ���� ���� ��ȯ
		Class clazz = Class.forName("com.korea.first.YoilTeller");
		
		// ���ο� ��ü ����
		Object obj  = clazz.newInstance();
		
		// ��� �޼��� ���� ������ �迭�� ����
		
		// ����� �޼��带 ���� ���������� ������� ��� �޼��� �����´�.
		Method[] methodArr = clazz.getDeclaredMethods();
		for(Method m : methodArr) {
			String name = m.getName();//�޼����� �̸�
			Parameter[] paramArr = m.getParameters(); //�Ű�����
			Class returnType = m.getReturnType();//��ȯ Ÿ��
			
			//", " : ������
			//"(" : ���λ�
			//")" : ���̻�
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			// �Ķ���� �̸��� �������ϴ� �ݺ���
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} 
}