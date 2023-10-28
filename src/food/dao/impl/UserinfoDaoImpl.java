package food.dao.impl;

import food.dao.UserinfoDao;
import food.entity.Userinfo;
import util.db.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserinfoDaoImpl implements UserinfoDao {
    public UserinfoDaoImpl() {
    }

    public Userinfo selectByUsercodeAndUserpwd(Userinfo user) {
        String sql = "select * from userinfo where usercode=? and userpwd=?";
        Userinfo getUser = null;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[]{user.getUsercode(), user.getUserpwd()});

        try {
            if (rs.next()) {
                getUser = new Userinfo(rs.getInt("userid"), user.getUsercode(), "******", rs.getString("nickname"));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        baseDao.close();
        return getUser;
    }
}