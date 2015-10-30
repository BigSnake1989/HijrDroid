package id.co.hijr.app.service;

import com.google.inject.Inject;

import id.co.hijr.app.dao.RoleDao;
import id.co.hijr.app.dao.UserDao;
import id.co.hijr.app.domain.Role;
import id.co.hijr.app.domain.User;

/**
 * Created by refitgustaroska on 10/27/15.
 */
public class ApplicationServiceImpl implements ApplicationService {

    @Inject
    private UserDao userDao;

    @Inject
    private RoleDao roleDao;


    public void createUser(User user, Role role){
        role.setId(roleDao.newId());

        user.setId(userDao.newId());
        user.setRole(role);

        roleDao.add(role);
        userDao.add(user);
    }
}
