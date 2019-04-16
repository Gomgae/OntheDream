package dao;

import java.sql.*;
import java.util.*;
import model.Member;


public class MemberDAO {
	
	private Connection con = null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String url;
	private String user;
	private String pw;
	

	public MemberDAO() {
		
		url="jdbc:mariadb://localhost/jhp";
		user="JHP";
		pw="12345";
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 현재 회원 확인
	public boolean checkMember(String id,String email) throws SQLException{
		try {
			String sql="select * from user where id =?";
			con = DriverManager.getConnection(url, user, pw);
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,email);
			rs=ps.executeQuery();
			// rs에 아무것도 안뜨면 회원이 아니다
			boolean isExist=rs.next();
			return isExist;
		}finally {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
//    dao 패키지에 있는 DTO 꺼 가져와서 쓰기
//    회원정보셋 데이터 추가하기
	
    public void insertMember(Member member) throws Exception{
    	try {
        	String sql = "insert into user values (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, member.getid());
            ps.setString(2, member.getpass());
            ps.setString(3, member.getname());
            ps.setString(4, member.getcontact());
            ps.setString(5, member.getemail());
            ps.setString(6, member.getquestion());
            ps.setString(7, member.getanswer());
            ps.executeUpdate();
    }catch(Exception e){
    	e.printStackTrace();
    }finally{
    	execClose(null,ps,con);
    }
    
  }
    
    public void updateMember(Member member)
    {
        String sql = "update user set pass=?, name=?, email=?,contact =? where id=?";
        PreparedStatement pstmt = null;
 
        try {
            pstmt = con.prepareStatement(sql);
            ps.setString(1, member.getid());
            ps.setString(2, member.getpass());
            ps.setString(3, member.getname());
            ps.setString(4, member.getcontact());
            ps.setString(5, member.getemail());
            ps.setString(6, member.getquestion());
            ps.setString(7, member.getanswer());
            pstmt.executeUpdate();
        } catch (SQLException e) {
           
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
    }
//    id에 해당하는 멤버 조회하기
    public Member selectOne(String id)
    {
        String sql = "select * from user where id = ?";
//        구문객체, 리턴할 객체, 결과셋 참조변수들 준비
        PreparedStatement pstmt = null;
        Member member = null;//리턴할 객체참조변수
        ResultSet rs = null;//결과셋 참조변수들 준비
        
        try {
//            구문객체획득
            pstmt = con.prepareStatement(sql);
//            구문완성
            pstmt.setString(1, id);
//            구문 날리고 result set 획득
            rs = pstmt.executeQuery();
//            Resultset 탐색
            if( rs.next() )
            {
            	member = new Member();
            	member.setid( rs.getString("id"));
            	member.setpass(rs.getString("pass"));
            	member.setname( rs.getString("name"));
            	member.setemail(rs.getString("email"));
            	member.setcontact(rs.getString("contact"));
            	
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return member;
    }
    
//    member의 테이블정보 전체조회하기
    public List<Member> selectAll() {
        String sql = "select * from user";
        PreparedStatement pstmt = null;
//        결과값 탐색
        ResultSet rs = null;
        List<Member> memberList = new ArrayList<Member>();
        
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	Member member = new Member();
            	member.setid( rs.getString("id") );
            	member.setpass(rs.getString("pw"));
            	member.setname(rs.getString("name"));
            	member.setemail(rs.getString("email"));
            	member.setcontact(rs.getString("contact"));
                memberList.add(member);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        //   구문객체와 Resultset객체 닫아주기
        finally{
            try{
                if( pstmt != null && !pstmt.isClosed())
                    pstmt.close();
                if( rs != null && !rs.isClosed())
                    pstmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return memberList;
        
    }
  //ID 중복 체크
       public int confirmId(String id)throws Exception{
          Connection con =null;
          PreparedStatement ps = null;
          ResultSet rs = null;
           String sql="";
           int x=-1;
           try{
               con=getConnection();
             sql="select * from user where id= ?";
             ps = con.prepareStatement(sql);
               ps.setString(1, id);
                rs= ps.executeQuery();   
                
                if(rs.next())
                  x=1; //해당아이디 있음
               else
                    x=-1;//해당아이디 없음
           }catch(Exception ex){
                ex.printStackTrace();
           }finally{
                execClose(rs,ps,con);
           }       
            return x;
      }
         
       private Connection getConnection() {
    	   return null;
       }
       //자원 정리를 위한 메소드
       //계란노른자
       //Connection 를통해서 PreparedStatement 를생성하고
       //PreparedStatement 를 통해서 ResultSet 를 생성하기때문에
       //종료할때는 ResultSet=>PreparedStatement=>Connection 와같이 생성순서의 역순으로 close 해줘야한다
     public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
           //자원정리
           if(rs !=null) try{rs.close();}catch(SQLException sqle){}
           if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
           //커넥션 풀로 반납
           if(conn !=null) try{conn.close();}catch(SQLException sqle){}
 }
}
