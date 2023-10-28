package com.acorn.tranjection;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class UserService {
	@Autowired
	UserDao dao;
	
	@Autowired
	PlatformTransactionManager tm;
	
	public void insertWithTx() throws SQLException {
		TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
		
		try {
			dao.insertUser(new User("hong2","9999"));
			dao.insertUser(new User("hong3","9999"));
			tm.commit(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tm.rollback(status);
			
			throw e;
		}
		
		
	}
}
