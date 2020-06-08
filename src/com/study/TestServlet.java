package com.study;
/*
이 클래스는 톰켓과 같은 서버에서만 실행되는, 서버전용 클래스이다!!
이러한 클래스를 가리켜, 서블릿(Servlet)이라 한다!! 서버에서만 실행되는 클래스

그리고, 서블릿으로 정의하기 위해서는 단지 Servelt 클래스를 상속받기만 하면된다!!

javaSE : rt.jar 곳에 모아져있다
javaEE : javaEE는 개발환경을 설치한 적이 없기 때문에 어디에 jar 가 있는지 알 수가 없다..
			해결) javaEE 스팩을 따르는 톰켓을 사용중이기 때문에
					javaEE 관련한 jar 또한 톰켓이 가지고 있다...
					resin, jboss, weblogic.. 등등의 서버도 마찬가지이다
*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException; //javaSE
import java.io.PrintWriter; //javaSE
//따라서 javaEE > javaSE를 포함하고 있다..(단 swing 같은 독립실행형 api는 빠져있다, 즉 웹개발과 관련된 것만 포함...)
public class TestServlet extends HttpServlet{
	//서블릿 api 참조해서 알맞는 메서드 재정의!!
	//javaEE api document 를 참조해야 한다!!

//아래의 메서드는, 클라이언트가 브라우저로 접근할떄 동작하게 되는 메서드!
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		//현재 접속한 클라이언트와 연결된 스트림을 이용하여 문자열을 출력해보자!!
		//문자기반의 출력스트림을 얻는 메서드
		PrintWriter out = resp.getWriter(); 
		out.print("my web site !!!");
	}
	//콘솔이 아닌, 클라이언트의 웹브라우저에 메시지를 출력해야 한다!!
	//따라서 스트림을 이용해야 한다!!
}
