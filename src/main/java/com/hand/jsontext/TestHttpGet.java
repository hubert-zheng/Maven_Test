package com.hand.jsontext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestHttpGet {

	public static void main(String[] args) {
		new ReadByGet().start();
	}
	
//	static class ReadByGet extends Thread{
}
class ReadByGet extends Thread{
	@Override
	public void run() {
		try {
			
			
			//URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=zxbTest&key=134905750&type=data&doctype=json&version=1.1&q=direction"); //json格式
			URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=zxbTest&key=134905750&type=data&doctype=xml&version=1.1&q=direction"); //xml格式

			URLConnection connection = url.openConnection();//打开链接
			//获取输入流
			InputStream is = connection.getInputStream();
			//若获取到乱码,可在获取流中指定编码UTF-8
			//InputStreamReader isr = new InputStreamReader(is,"UFT-8");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			StringBuilder builder = new StringBuilder();
			while((line = br.readLine())!=null){
				builder.append(line);
			}
			//关闭流
			br.close();
			isr.close();
			is.close();
			
			//-------输出-------------
			System.out.println(builder.toString());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
