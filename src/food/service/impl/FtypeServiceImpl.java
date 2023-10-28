package food.service.impl;

import food.dao.FoodDao;
import food.dao.FtypeDao;
import food.dao.impl.FoodDaoImpl;
import food.dao.impl.FtypeDaoImpl;
import food.entity.Ftype;
import food.service.FtypeService;

import java.util.List;

public class FtypeServiceImpl implements FtypeService {
    private FoodDao foodDao = new FoodDaoImpl();
    private FtypeDao ftypeDao = new FtypeDaoImpl();

    public FtypeServiceImpl() {
    }

    public List<Ftype> getAllWithFood() {
        List<Ftype> list = this.ftypeDao.selectAll();

        for(int i = 0; i < list.size(); ++i) {
            Ftype ftype = (Ftype)list.get(i);
            ftype.setFoodList(this.foodDao.selectByTid(ftype.getTid()));
        }

        return list;
    }

    public List<Ftype> getAll() {
        return this.ftypeDao.selectAll();
    }
}
