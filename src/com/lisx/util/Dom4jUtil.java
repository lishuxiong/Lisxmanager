package com.lisx.util;

import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtil {

	private static String DBFILE;
	
	static{
		ClassLoader cl = Dom4jUtil.class.getClassLoader();
		URL url = cl.getResource("users.xml");
		DBFILE = url.getPath();//获取文件路径
	}
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		return reader.read(DBFILE);
	}
	
	/**
	 * 保存数据到指定路径的文件下(user.xml)
	 * @param document
	 * @throws Exception
	 */
	public static void writeDocument2XML(Document document) throws Exception{
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(DBFILE), format);
		writer.write(document);
		writer.flush();
		writer.close();
	}
	
}
