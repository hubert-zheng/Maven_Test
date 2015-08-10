package com.hand.jsontext;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJson {

	public static void main(String[] args) {
		try {
			
			JsonParser parser = new JsonParser();//json解析器
			JsonObject object = (JsonObject) parser.parse(new FileReader("json.json"));
			//json数据里的单一元素
			System.out.println("cat="+object.get("cat").getAsString());//获取cat键的数据
			System.out.println("pop="+object.get("pop").getAsBoolean()); // 根据json的数据格式确定后面的getAsBoolean
			//json数据里的json数组
			JsonArray array = object.get("languages").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				System.out.println("--------------");
				JsonObject subobject = array.get(i).getAsJsonObject();//读取第i个里元素
				System.out.println("id="+subobject.get("id").getAsInt());
				System.out.println("name="+subobject.get("name").getAsString());
				System.out.println("ide="+subobject.get("ide").getAsString());

			}
		
		
		
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
