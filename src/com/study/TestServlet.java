package com.study;
/*
�� Ŭ������ ���ϰ� ���� ���������� ����Ǵ�, �������� Ŭ�����̴�!!
�̷��� Ŭ������ ������, ����(Servlet)�̶� �Ѵ�!! ���������� ����Ǵ� Ŭ����

�׸���, �������� �����ϱ� ���ؼ��� ���� Servelt Ŭ������ ��ӹޱ⸸ �ϸ�ȴ�!!

javaSE : rt.jar ���� ������ִ�
javaEE : javaEE�� ����ȯ���� ��ġ�� ���� ���� ������ ��� jar �� �ִ��� �� ���� ����..
			�ذ�) javaEE ������ ������ ������ ������̱� ������
					javaEE ������ jar ���� ������ ������ �ִ�...
					resin, jboss, weblogic.. ����� ������ ���������̴�
*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException; //javaSE
import java.io.PrintWriter; //javaSE
//���� javaEE > javaSE�� �����ϰ� �ִ�..(�� swing ���� ���������� api�� �����ִ�, �� �����߰� ���õ� �͸� ����...)
public class TestServlet extends HttpServlet{
	//���� api �����ؼ� �˸´� �޼��� ������!!
	//javaEE api document �� �����ؾ� �Ѵ�!!

//�Ʒ��� �޼����, Ŭ���̾�Ʈ�� �������� �����ҋ� �����ϰ� �Ǵ� �޼���!
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		//���� ������ Ŭ���̾�Ʈ�� ����� ��Ʈ���� �̿��Ͽ� ���ڿ��� ����غ���!!
		//���ڱ���� ��½�Ʈ���� ��� �޼���
		PrintWriter out = resp.getWriter(); 
		out.print("my web site !!!");
	}
	//�ܼ��� �ƴ�, Ŭ���̾�Ʈ�� ���������� �޽����� ����ؾ� �Ѵ�!!
	//���� ��Ʈ���� �̿��ؾ� �Ѵ�!!
}
