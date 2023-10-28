package food.dao.impl;

import food.dao.FoodDao;
import food.entity.Food;
import util.db.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {

    public FoodDaoImpl() {
    }

    public Food selectByFid(int fid) {
        String sql = "select * from food where fid=?";
        Food food = null;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[]{fid});

        try {
            if (rs.next()) {
                food = new Food(rs.getInt("fid"), rs.getInt("tid"), rs.getString("fname"), rs.getString("fpic"), rs.getDouble("fprice"), rs.getInt("forder"), rs.getString("fdesc"), rs.getString("fregtime"));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        baseDao.close();
        return food;
    }

    public List<Food> selectAll() {
        String sql = "select * from food";
        List<Food> list = new ArrayList();
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[0]);

        try {
            while(rs.next()) {
                list.add(new Food(rs.getInt("fid"), rs.getInt("tid"), rs.getString("fname"), rs.getString("fpic"), rs.getDouble("fprice"), rs.getInt("forder"), rs.getString("fdesc"), rs.getString("fregtime")));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        baseDao.close();
        return list;
    }

    public List<Food> getlikefood(String fname,String fprice) {
        String sql = "select * from food where";
        if (fname != ""&&fprice=="") {
            sql = sql + "  fname like '%" + fname + "%'";
        }else if(fname == ""&&fprice!=""){
            Double fpr=Double.parseDouble(fprice);
            sql=sql +"  fprice = " + fprice;
        }else if(fname != ""&&fprice!=""){
            Double fpr=Double.parseDouble(fprice);
            sql=sql + "  fname like '%" + fname + "%' and fprice = " + fprice ;
        }
        BaseDao dao = new BaseDao();
        dao.open();
        List<Food> infolist = new ArrayList();
        ResultSet rs = dao.doCha(sql);

        try {
            while(rs.next()) {
                infolist.add(new Food(rs.getInt("fid"), rs.getInt("tid"), rs.getString("fname"), rs.getString("fpic"), rs.getDouble("fprice"), rs.getInt("forder"), rs.getString("fdesc"), rs.getString("fregtime")));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            return null;
        }

        dao.close();
        return infolist;
    }
    public List<Food> selectByTid(int tid) {
        String sql = "select * from food where tid=?";
        List<Food> list = new ArrayList();
        BaseDao baseDao = new BaseDao();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql, new Object[]{tid});

        try {
            while(rs.next()) {
                list.add(new Food(rs.getInt("fid"), rs.getInt("tid"), rs.getString("fname"), rs.getString("fpic"), rs.getDouble("fprice"), rs.getInt("forder"), rs.getString("fdesc"), rs.getString("fregtime")));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        baseDao.close();
        return list;
    }

    public int insert(Food food) {
        String sql = "insert into food(fid,tid,fname,fpic,fprice,fdesc,fregtime) values(null,?,?,?,?,?,current_date)";
        int count = -1;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
         count = baseDao.execDML(sql, new Object[]{food.getTid(), food.getFname(), food.getFpic(),food.getFprice(), food.getFdesc()});
        baseDao.close();
        return count;
    }

    public int delete(int fid) {
        String sql = "delete from food where fid=?";
        int count = -1;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
         count = baseDao.execDML(sql, new Object[]{fid});
        baseDao.close();
        return count;
    }

    public int update(Food food) {
        StringBuilder sql = new StringBuilder("update food set ");
        Integer tid = food.getTid();
        String fname = food.getFname();
        String fpic = food.getFpic();
        Double fprice = food.getFprice();
        String fdesc=food.getFdesc();
        List<Object> param = new ArrayList();
        if (tid != null) {
            sql.append("tid=?,");
            param.add(tid);
        }

        if (fname != null) {
            sql.append("fname=?,");
            param.add(fname);
        }

        if (fpic != null) {
            sql.append("fpic=?,");
            param.add(fpic);
        }

        if (fprice != null) {
            sql.append("fprice=?,");
            param.add(fprice);
        }

        if (fdesc != null) {
            sql.append("fdesc=?,");
            param.add(fdesc);
        }

        String sqlStr = sql.toString();
        String tSql = sql.substring(0, sql.length() - 1) + " where fid=?";
        param.add(food.getFid());
        System.out.println(tSql);
        int count = -1;
        BaseDao baseDao = new BaseDao();
        baseDao.open();
         count = baseDao.execDML(tSql, param);
        baseDao.close();
        return count;
    }
}
