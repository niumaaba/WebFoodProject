package food.dao;

import food.entity.Ftype;

import java.util.List;

public interface FtypeDao {
    Ftype selectByTid(int tid);

    List<Ftype> selectAll();
}
