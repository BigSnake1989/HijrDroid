package id.co.hijr.app.dao;

import id.co.hijr.app.core.DaoGeneric;
import id.co.hijr.app.domain.User;

import java.util.List;


public interface UserDao extends DaoGeneric<User> {

	public void updatePassword(User user);
	
	public List<User> listTestCustomQuery();

}
