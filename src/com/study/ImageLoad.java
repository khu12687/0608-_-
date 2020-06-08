package com.study;
/*자바 스탠다드 클래스로, 웹서버에 올려진 이미지를 가져와보자!!(이미 했었다..)
HttpURLConnection : 웹상의 자원에 연결해주는 객체!!
*/
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;
public class ImageLoad extends JFrame{
	JPanel p_center;
	Thread thread; //메인 쓰레드 대신에 윕상의 자원에 접근하여 수집할 실행부!!

	URL url;
	URLConnection con;
	HttpURLConnection httpCon;
	String savePath = "C:/web_app_DB/javaEE/TestSite/data/";
	FileOutputStream fos;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	public ImageLoad(){
		p_center = new JPanel(){
			public void paint(Graphics g){
					g.drawImage(img,0,0,200,200,p_center);
			}
		};

		//스타일 적용
		add(p_center);

		//조립
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		thread = new Thread(){
			public void run(){
				load();
			}
		};
		thread.start();
	}

	public void load(){
		try{
			url = new URL("http://172.30.1.30:8080/images/e5.png");
			httpCon = (HttpURLConnection)url.openConnection();

			//웹상의 자원과 스트림 연결!!
			InputStream is = httpCon.getInputStream();
			fos = new FileOutputStream(savePath+"test.png");

			int data = -1;
			while(true){
				data = is.read(); //1byte 읽기
				if(data==-1) break;
				//읽은 데이터 출력
				fos.write(data); //읽은 데이터 출력
			}
			JOptionPane.showMessageDialog(this,"로드완료");

			//패널에 그리기!!
			img = kit.getImage(savePath+"test.png");
			p_center.repaint();

		}catch(MalformedURLException e){
			
		}catch(IOException e){
			
		}finally{

			if(fos!=null){
				try{
					fos.close();
				}catch(IOException e){

				}
			}
		}
	}
	public static void main(String[] args){
		new ImageLoad();
	}
}
