package food.dao;

import food.entity.Userinfo;

public interface UserinfoDao {
    Userinfo selectByUsercodeAndUserpwd(Userinfo user);
}
