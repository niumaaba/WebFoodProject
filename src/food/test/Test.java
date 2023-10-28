package food.test;

import food.entity.Ftype;
import food.service.FtypeService;
import food.service.impl.FtypeServiceImpl;

import java.util.Iterator;
import java.util.List;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        FtypeService service = new FtypeServiceImpl();
        List<Ftype> list = service.getAllWithFood();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Ftype f = (Ftype)var4.next();
            System.out.println(f);
            System.out.println(f.getFoodList());
        }

    }
}
