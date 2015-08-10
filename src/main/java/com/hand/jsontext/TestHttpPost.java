package com.hand.jsontext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHttpPost {
	
	public static void main(String[] args) {
		new ReadByPost().start();
	}
}
class ReadByPost extends Thread{
	
	@Override
	public void run() {
		try {
			
			URL url = new URL("http://fanyi.youdao.com/openapi.do");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("encoding", "UTF-8"); //编码设置为UTF-8
			//设定参数
			connection.setDoInput(true); //当前connection可从网络获取数据
			connection.setDoOutput(true);//当前connection可从网络传输数据
			//在执行任何输入输出之前，把connection设置为POST
			//把当前的connection访问网络方式设置为POST
			connection.setRequestMethod("POST");
			
			//包装输出流
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			//向服务器传出数据
			bw.write("keyfrom=zxbTest&key=134905750&type=data&doctype=xml&version=1.1&q=direction");
			bw.flush(); //强制输出
			
			//如果POST,需要先向服务器发送数据，所以需要将输入流放在输出流之后
			//包装输入流
			InputStream is =connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); 
			
			//读取
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line=br.readLine())!=null) {
				builder.append(line);
			}
			
			//读取完毕，关闭流
			bw.close();
			osw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			
			//将读取到的数据输出
			System.out.println(builder.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}