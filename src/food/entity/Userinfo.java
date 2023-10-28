package food.entity;

public class Userinfo {
    private Integer userid;
    private String usercode;
    private String userpwd;
    private String nickname;

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserpwd() {
        return this.userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String toString() {
        return "Userinfo [userid=" + this.userid + ", usercode=" + this.usercode + ", userpwd=" + this.userpwd + ", nickname=" + this.nickname + "]";
    }

    public Userinfo(Integer userid, String usercode, String userpwd, String nickname) {
        this.userid = userid;
        this.usercode = usercode;
        this.userpwd = userpwd;
        this.nickname = nickname;
    }

    public Userinfo() {
    }
}
