package ex21_1_Connect_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class JDBCExample2_Oracle1_column_name_dept {
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			
			//1단계 : JDBC 드라이버를 로드한다.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

		    //2단계 : DB에 연결한다.
		    String url = "jdbc:oracle:thin:@localhost:1521:xe";
		    conn = DriverManager.getConnection(url, "scott", "tiger");

		    /* 데이터 베이스에 있는 테이블의 데이터를 읽어오기 위해 Statement 객체가 필요 하다.
		     * 2단계에서 얻은 Connection 객체에 대해 createStatement 메소드를 호출해서 얻습니다.
		     */
		    stmt = conn.createStatement();
		    
		    /*
		     * Statement 타입은 java.sql 패키지에 속하는 인터페이스 이름으로
		     * select문을 실행하는 executeQuery라는 메소드가 있습니다.
		     * 이 메소드에 파라미터로 select 문장을 넘겨주어야 합니다.
		     * 이 메소드는 파라미터로 넘겨준 select 문을 데이터 베이스로
		     * 보내서 실행하고 그 결과로 ResultSet 객체를 리턴합니다.
		     */
		    String select_sql = "select * from dept";
		    
		    rs = stmt.executeQuery(select_sql);
		    
		    System.out.println("번호\t부서번호\t부서명\t\t지역");
		    System.out.println("---------------------------------------------------");
		    
		    /*
		    ResultSet 객체로부터 select문의 실행 결과를 얻기 위해서는 먼저 next() 메소드를 호출해야 합니다.
		     */
		    
		    int i = 0;
		    while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
		    	//getInt("deptno") : 컬럼 deptno 값을 int 형으로 리턴하는 메소드
		    	int deptno = rs.getInt("deptno");
		    	
		    	//getString("dname") : 컬럼 dname 값을 String 형으로 리턴하는 메소드
		    	String dname = rs.getString("dname");
		    	
		    	String loc = rs.getString("loc");
		    	
		    	System.out.printf("%5d\t%5d\t%-15s%s\n",
		    						++i,deptno,dname,loc);
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
		            conn.close(); //4단계 : DB연결을 끊는다.
		        } catch (SQLException sqlException) {
		            System.out.println(sqlException.getMessage());
		        }
		}
	}
}
