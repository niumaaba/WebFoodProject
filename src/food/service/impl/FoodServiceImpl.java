package food.service.impl;

import food.dao.FoodDao;
import food.dao.FtypeDao;
import food.dao.impl.FoodDaoImpl;
import food.dao.impl.FtypeDaoImpl;
import food.entity.Food;
import food.entity.Ftype;
import food.service.FoodService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodServiceImpl implements FoodService {
    private FoodDao foodDao = new FoodDaoImpl();
    private FtypeDao ftypeDao = new FtypeDaoImpl();

    public FoodServiceImpl() {
    }

    public List<Food> getAllWithFtype() {
        List<Food> list = this.foodDao.selectAll();
        Map<Integer, Ftype> map = new HashMap();
        int count = 0;

        for(int i = 0; i < list.size(); ++i) {
            Food food = (Food)list.get(i);
            int tid = food.getTid();
            Ftype ftype = (Ftype)map.get(tid);
            if (ftype == null) {
                ftype = this.ftypeDao.selectByTid(tid);
                ++count;
                map.put(tid, ftype);
            }

            food.setFtype(ftype);
        }

        System.out.println(count);
        return list;
    }

    public List<Food> getlikesFood(String fname,String fprice) {
        List<Food> list = this.foodDao.getlikefood(fname,fprice);
        Map<Integer, Ftype> map = new HashMap();
        int count = 0;

        for(int i = 0; i < list.size(); ++i) {
            Food food = (Food)list.get(i);
            int tid = food.getTid();
            Ftype ftype = (Ftype)map.get(tid);
            if (ftype == null) {
                ftype = this.ftypeDao.selectByTid(tid);
                ++count;
                map.put(tid, ftype);
            }

            food.setFtype(ftype);
        }

        System.out.println(count);
        return list;
    }
    public boolean add(Food food) {
        int count = this.foodDao.insert(food);
        return count > 0;
    }


    public boolean remove(int fid) {
        int count = this.foodDao.delete(fid);
        return count > 0;
    }

    public boolean change(Food food) {

        if (food == null) {
            return false;
        } else if (food.getFid() == null) {
            return false;
        } else if (food.getTid() == null && food.getFname() == null && food.getFpic() == null && food.getFprice() == null) {
            return false;
        } else {
            Map<Integer, Ftype> map = new HashMap();
            int tid = food.getTid();
            Ftype ftype = (Ftype)map.get(tid);
            if (ftype == null) {
                ftype = this.ftypeDao.selectByTid(tid);
                map.put(tid, ftype);
            }

            food.setFtype(ftype);
            int count = this.foodDao.update(food);
            return count > 0;
        }
    }

    public Food getByFid(int fid) {
        return this.foodDao.selectByFid(fid);
    }
}
