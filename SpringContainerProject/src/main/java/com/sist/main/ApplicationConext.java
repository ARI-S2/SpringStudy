package com.sist.main;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.collections.map.HashedMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class ApplicationConext {
	private Map map = new HashedMap();
	public ApplicationConext(String path) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(path));
			Element beans = doc.getDocumentElement();
			NodeList list= beans.getElementsByTagName("name");
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
