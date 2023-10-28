package food.dao.impl;

import food.dao.FtypeDao;
import food.entity.Ftype;
import util.db.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FtypeDaoImpl implements FtypeDao {
    public FtypeDaoImpl() {
    }

    public Ftype selectByTid(int tid) {
        String sql = "select * from ftype where tid=?";
        Ftype ftype = null;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[]{tid});

        try {
            if (rs.next()) {
                ftype = new Ftype(rs.getInt("tid"), rs.getString("tname"));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        baseDao.close();
        return ftype;
    }

    public List<Ftype> selectAll() {
        String sql = "select * from ftype";
        List<Ftype> list = new ArrayList();
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[0]);

        try {
            while(rs.next()) {
                list.add(new Ftype(rs.getInt("tid"), rs.getString("tname")));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        baseDao.close();
        return list;
    }
}