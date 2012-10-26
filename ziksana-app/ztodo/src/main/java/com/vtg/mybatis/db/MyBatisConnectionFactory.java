package com.vtg.mybatis.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vtg.mapper.CategoryMapper;
import com.vtg.mapper.MemberMapper;
import com.vtg.mapper.MemberRoleMapper;
import com.vtg.mapper.TodoListMapper;
import com.vtg.mapper.TodoMapper;

/**
 * MyBatis Connection Factory, which reads the configuration data from a XML
 * file.
 * 
 * @author
 */
public class MyBatisConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			final String resource = "SqlMapConfig.xml";
			final Reader reader = Resources.getResourceAsReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader);
				sqlSessionFactory.getConfiguration().addMapper(
						MemberMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(
						CategoryMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(
						MemberRoleMapper.class);	
				sqlSessionFactory.getConfiguration().addMapper(
						TodoMapper.class);		
				sqlSessionFactory.getConfiguration().addMapper(
						TodoListMapper.class);		
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {

		return sqlSessionFactory;
	}

}
