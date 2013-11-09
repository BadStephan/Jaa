package com.wgsh.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonParseTest {
	public static void main(String[] args){
		FileReader reader = null;
		try {
			reader = new FileReader(new File("res/messages.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonReader jreader = new JsonReader(reader);
		
		System.out.println(jreader);
		
		try {
			jreader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class JsonMessage{
		
	}
}
