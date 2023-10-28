package food.entity;

public class Food {
    private Integer fid;
    private Integer tid;
    private String fname;
    private String fpic;
    private Double fprice;
    private Integer forder;
    private String fdesc;
    private String fregtime;
    private Ftype ftype;

    public Integer getFid() {
        return this.fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTid() {
        return this.tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpic() {
        return this.fpic;
    }

    public void setFpic(String fpic) {
        this.fpic = fpic;
    }

    public Double getFprice() {
        return this.fprice;
    }

    public void setFprice(Double fprice) {
        this.fprice = fprice;
    }

    public Integer getForder() {
        return this.forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }

    public String getFdesc() {
        return this.fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public String getFregtime() {
        return this.fregtime;
    }

    public void setFregtime(String fregtime) {
        this.fregtime = fregtime;
    }

    public Ftype getFtype() {
        return this.ftype;
    }

    public void setFtype(Ftype ftype) {
        this.ftype = ftype;
    }

    public String toString() {
        return "Food [fid=" + this.fid + ", tid=" + this.tid + ", fname=" + this.fname + ", fpic=" + this.fpic + ", fprice=" + this.fprice + ", forder=" + this.forder + ", fdesc=" + this.fdesc + ", fregtime=" + this.fregtime + ", ftype=" + this.ftype + "]";
    }

    public Food(Integer fid, Integer tid, String fname, String fpic, Double fprice, Integer forder, String fdesc, String fregtime) {
        this.fid = fid;
        this.tid = tid;
        this.fname = fname;
        this.fpic = fpic;
        this.fprice = fprice;
        this.forder = forder;
        this.fdesc = fdesc;
        this.fregtime = fregtime;
    }

    public Food() {
    }
}
