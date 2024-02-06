package extest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public List<GoodsInfo> select() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<GoodsInfo> list = new ArrayList<>();
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();

            String select_sql = "select code,name,price,maker from goodsinfo";
            rs = stmt.executeQuery(select_sql);

            while (rs.next()) {
                GoodsInfo g = new GoodsInfo();

                String code = rs.getString("code");
                g.setCode(code);

                String name = rs.getString("name");
                g.setName(name);

                int price = rs.getInt("price");
                g.setPrice(price);

                String maker = rs.getString("maker");
                g.setMaker(maker);

                list.add(g);
            }
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + classNotFoundException.getMessage());
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }

            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }

            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }
        }
        return list;
    }
}
