package id.co.hijr.app.dao;

import id.co.hijr.app.core.DaoBase;
import id.co.hijr.app.domain.User;

import java.util.List;


import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl  extends DaoBase<User> implements UserDao {


	public UserDaoImpl() {
		super(UserDao.class.getName(), User.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updatePassword(User user) {
		// getSqlSession().update(getNamespace()+".updatePassword", user); 
		update("updatePassword", user);
	}

	@Override
	public List<User> listTestCustomQuery() {
		// TODO Auto-generated method stub
		return list("listTestCustomQuery", User.class);
	}

}
