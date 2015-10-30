package id.co.hijr.app;

import com.google.inject.AbstractModule;

import id.co.hijr.app.dao.RoleDao;
import id.co.hijr.app.dao.RoleDaoImpl;
import id.co.hijr.app.dao.UserDao;
import id.co.hijr.app.dao.UserDaoImpl;
import id.co.hijr.app.service.ApplicationService;
import id.co.hijr.app.service.ApplicationServiceImpl;

/**
 * Created by refitgustaroska on 10/30/15.
 */
public class MainModule extends AbstractModule {
    @Override
    public void configure() {
        bind(UserDao.class).to(UserDaoImpl.class);
        bind(RoleDao.class).to(RoleDaoImpl.class);
        bind(ApplicationService.class).to(ApplicationServiceImpl.class);
    }
}
