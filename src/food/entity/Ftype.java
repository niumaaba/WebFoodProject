package food.entity;

import java.util.List;

public class Ftype {
    private Integer tid;
    private String tname;
    private List<Food> foodList;

    public List<Food> getFoodList() {
        return this.foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Integer getTid() {
        return this.tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return this.tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String toString() {
        return "Ftype [tid=" + this.tid + ", tname=" + this.tname + "]";
    }

    public Ftype(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Ftype() {
    }
}
