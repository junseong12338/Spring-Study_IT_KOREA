package util;

public class Page {
	
	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {
		int totalPage; //��ü ������ ��
		int startPage; //���� ������ ��ȣ
		int endPage; //������ ������ ��ȣ
		
		boolean isPrevPage, isNextPage;
		StringBuffer sb;
		
		
		isPrevPage=isNextPage=false;
		
		//��ü ������ ��
		totalPage=(int)(rowTotal/blockList);
		
		//�Խù����� 10�� ����� �������� �ʰ� �������� ������ ��
		if(rowTotal % blockList !=0) {
			totalPage++;
		}
		
		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if(nowPage > totalPage) {
			nowPage = totalPage;
		}
		
		//���������� ���ϱ�
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		
		//���������� ���ϱ�
		endPage = startPage + blockPage -1;
		
		//������ ������ ���� ��ü ������������ ũ�� ������ ������ ���� ����
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		//������ �������� ��ü���������� ������� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if(endPage < totalPage) {
			isNextPage = true;
		}
		
		//������������ ���� 1���� ũ�� ���� �������� �̵��� �� �ֵ��� �� ����
		if(startPage > 1) {
			isPrevPage = true;
		}
		
		sb = new StringBuffer();
		
		//----�׷� ������ó�� ����-------------------------------------
		if(isPrevPage) {
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(startPage - 1);
			sb.append("'><img src='resources/img/btn_prev.gif'></a>");
		} else {
			sb.append("<img src='resources/img/btn_prev.gif'>");
		}
		
		//---- ������ ����� ���--------------------------------------
		sb.append(" ");
		for(int i = startPage; i <=endPage; i++) {
			if(i > totalPage) {
				break;
			}
			if(i == nowPage) {//���� ���õ� ������
				sb.append("&nbsp; <b> <font color='#ff0000'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {//���� �������� �ƴҶ�
				sb.append("&nbsp; <a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}//for��
		
		sb.append("&nbsp; ");
		//----�׷� ������ó�� ����-------------------------------------
		if(isNextPage) {
			sb.append("<a href='"+pageURL+"?page=");
			
			sb.append(endPage + 1);
			sb.append("'><img src='resources/img/btn_next.gif'></a>");
		} else {
			sb.append("<img src='resources/img/btn_next.gif'>");
		}
		
		return sb.toString();	
		
	}

}



















