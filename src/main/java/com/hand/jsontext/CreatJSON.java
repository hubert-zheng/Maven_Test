package com.hand.jsontext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreatJSON {

	public static void main(String[] args) {
	JsonObject object = new JsonObject();
	object.addProperty("cat", "IT");
	
	JsonArray array = new JsonArray();
	//在array中添加3个元素
	//第一个元素
	JsonObject lan1 = new JsonObject();
	lan1.addProperty("id", 1);
	lan1.addProperty("name", "Java");
	lan1.addProperty("ide", "Eclipse");
	array.add(lan1);
	//第二个元素
	JsonObject lan2 = new JsonObject();
	lan2.addProperty("id", 2);
	lan2.addProperty("name", "Swift");
	lan2.addProperty("ide", "Xcode");
	array.add(lan2);
	//第三个元素
	JsonObject lan3 = new JsonObject();
	lan3.addProperty("id", 3);
	lan3.addProperty("name", "C#");
	lan3.addProperty("ide", "Visual Studio");
	array.add(lan3);
	
	//将array添加到jsonObject中
	object.add("languages", array);
	
	//添加最后一个属性
	object.addProperty("pop", true);
	
	//-------Json数据创建完成-------------
	
	System.out.println(object.toString());
	
	
	}
}
