package id.co.hijr.app.dao;

import id.co.hijr.app.core.DaoBase;
import id.co.hijr.app.domain.Role;


import org.apache.ibatis.session.SqlSessionFactory;



public class RoleDaoImpl  extends DaoBase<Role> implements RoleDao {


	public RoleDaoImpl() {
		super(RoleDao.class.getName(), Role.class);
		// TODO Auto-generated constructor stub
	}

	

}
