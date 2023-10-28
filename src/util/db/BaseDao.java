package util.db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PWD = "YU19810919";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException var1) {
            var1.printStackTrace();
        }

    }

    public BaseDao() {
    }

    public void open() {
        try {
            this.conn = DriverManager.getConnection(URL, USERNAME, PWD);
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    private void createprepareStatement(String sql, Object... param) {
        try {
            this.ps = this.conn.prepareStatement(sql);

            for(int i = 0; i < param.length; ++i) {
                this.ps.setObject(i + 1, param[i]);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public ResultSet execDQL(String sql, Object... param) {
        try {
            this.createprepareStatement(sql, param);
            this.rs = this.ps.executeQuery();
            return this.rs;
        } catch (SQLException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public int execDML(String sql, Object... param) {
        try {
            this.createprepareStatement(sql, param);
            return this.ps.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
            return -1;
        }
    }

    public int execDML(String sql, List<Object> param) {
        try {
            this.ps = this.conn.prepareStatement(sql);

            for(int i = 0; i < param.size(); ++i) {
                this.ps.setObject(i + 1, param.get(i));
            }

            return this.ps.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
            return -1;
        }
    }

    public ResultSet doCha(String sql) {

        try {
            PreparedStatement psmt = this.conn.prepareStatement(sql);
            return psmt.executeQuery();
        } catch (SQLException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public void close() {
        if (this.rs != null) {
            try {
                this.rs.close();
            } catch (SQLException var25) {
                var25.printStackTrace();
            } finally {
                this.rs = null;
            }
        }

        if (this.ps != null) {
            try {
                this.ps.close();
            } catch (SQLException var23) {
                var23.printStackTrace();
            } finally {
                this.ps = null;
            }
        }

        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException var21) {
                var21.printStackTrace();
            } finally {
                this.conn = null;
            }
        }

    }
}
