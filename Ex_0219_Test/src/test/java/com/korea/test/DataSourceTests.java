package com.korea.test;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_mybatis;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Context_1_mybatis.class})
@Log4j
public class DataSourceTests {

		@Autowired 
		private DataSource dataSource;
		
		@Test
		public void testConnection() {
			try(Connection connection = dataSource.getConnection()){
		   		log.info(connection);
		   	} catch( Exception e) {
		   		fail(e.getMessage());
		   	}
		}
}
