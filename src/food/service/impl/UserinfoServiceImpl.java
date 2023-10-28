package food.service.impl;

import food.dao.UserinfoDao;
import food.dao.impl.UserinfoDaoImpl;
import food.entity.Userinfo;
import food.service.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService {
    private UserinfoDao userinfoDao = new UserinfoDaoImpl();

    public UserinfoServiceImpl() {
    }

    public Userinfo login(Userinfo userinfo) {
        return this.userinfoDao.selectByUsercodeAndUserpwd(userinfo);
    }
}
