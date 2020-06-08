package com.study;
/*�ڹ� ���Ĵٵ� Ŭ������, �������� �÷��� �̹����� �����ͺ���!!(�̹� �߾���..)
HttpURLConnection : ������ �ڿ��� �������ִ� ��ü!!
*/
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;
public class ImageLoad extends JFrame{
	JPanel p_center;
	Thread thread; //���� ������ ��ſ� ������ �ڿ��� �����Ͽ� ������ �����!!

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

		//��Ÿ�� ����
		add(p_center);

		//����
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

			//������ �ڿ��� ��Ʈ�� ����!!
			InputStream is = httpCon.getInputStream();
			fos = new FileOutputStream(savePath+"test.png");

			int data = -1;
			while(true){
				data = is.read(); //1byte �б�
				if(data==-1) break;
				//���� ������ ���
				fos.write(data); //���� ������ ���
			}
			JOptionPane.showMessageDialog(this,"�ε�Ϸ�");

			//�гο� �׸���!!
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
