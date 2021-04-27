package com.mj.common.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.common.model.vo.Attachment;

public class AttachmentDAO {

	private Properties prop;
	
	public AttachmentDAO() {
		prop = new Properties();
		
		String filePath 
			= AttachmentDAO.class
					  	  .getResource("/config/Attachment.properties")
					  	  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Attachment> selectList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
