package id.co.hijr.app.service;

import id.co.hijr.app.domain.Role;
import id.co.hijr.app.domain.User;

/**
 * Created by refitgustaroska on 10/27/15.
 */
public interface ApplicationService {

    public void createUser(User user, Role role);
}
