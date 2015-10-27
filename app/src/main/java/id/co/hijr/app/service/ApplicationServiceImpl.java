package id.co.hijr.app.service;

import id.co.hijr.app.dao.RoleDao;
import id.co.hijr.app.dao.RoleDaoImpl;
import id.co.hijr.app.dao.UserDao;
import id.co.hijr.app.dao.UserDaoImpl;
import id.co.hijr.app.domain.Role;
import id.co.hijr.app.domain.User;

/**
 * Created by refitgustaroska on 10/27/15.
 */
public class ApplicationServiceImpl implements ApplicationService {

    private UserDao userDao;
    private RoleDao roleDao;

    public ApplicationServiceImpl(){
        userDao = new UserDaoImpl();
        roleDao = new RoleDaoImpl();
    }

    public void createUser(User user, Role role){
        role.setId(roleDao.newId());

        user.setId(userDao.newId());
        user.setRole(role);

        roleDao.add(role);
        userDao.add(user);
    }
}
