package food.service;

import food.entity.Ftype;

import java.util.List;

public interface FtypeService {
    List<Ftype> getAllWithFood();

    List<Ftype> getAll();
}
