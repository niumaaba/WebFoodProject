package food.service;

import food.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllWithFtype();
    Food getByFid(int fid);
    boolean add(Food food);
    public List<Food> getlikesFood(String fname,String fprice) ;
    boolean remove(int fid);
    boolean change(Food food);

}
