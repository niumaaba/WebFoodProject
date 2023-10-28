package food.dao;

import food.entity.Food;

import java.util.List;

public interface FoodDao {
    List<Food> selectAll();

    List<Food> selectByTid(int tid);

    Food selectByFid(int fid);

    int insert(Food food);

    int delete(int fid);

    int update(Food food);
    List<Food> getlikefood(String fname,String fprice);
}
