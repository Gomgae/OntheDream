package service;
import java.util.List;
 
import dao.MemberDao;
import model.Member;
 
// 멤버 Dao를 사용해야함
public class MemberService {
    private MemberDao memberDao;
//    싱글턴 패턴 적용
    public MemberService(){
        memberDao = MemberDao.getInstance();
    }
//    로그인 처리하는 기능(파라미터 id, pw, 리턴로그인 성공여부)
//    입력받은 id에 해당하는 데이터가 디비에 있는지 확인
//    있으면 그 데이터의 pw가 입력받은 pw와 같은지 확인
    
    public boolean login(String id, String pass)
    {
        Member member = memberDao.selectOne(id);
//        로그인 아이디 없으면 실패
        if(member == null)
            return false;
        else
        {//아이디 있는데 로그인 할때 비밀번호가 일치하면 성공
            if(member.getpass().equals(pass))
                return true;
            //아니면 실패
            else 
                return false;
        }
    }
    
//    id에 해당하는 정보를 가져다 주는 기능(파라미터 id, 리턴 회원정보셋)
//    입력받은 id에 해당하는 데이터들을 갖다 주기
//    셔틀역할
    public Member getMember(String id)
    {
        return memberDao.selectOne(id);
    }
    
//    회원정보를 수정해주는 기능(파라미터 회원정보셋)
//    회원정보셋의 id에 해당하는 데이터를 디비에서찾아서 그 pw가 회원정보셋의 pw와 일치한다면 
//    해당데이터의 name, email을 파라미터로 넘어온 회원정보셋의 name, email로 수정
    public boolean update(String id, String pass, String name, String email,String contact)
    {//회원정보 쪼로로로 받아서
        Member member = new Member();
        member.setid(id);
        member.setpass(pass);
        member.setname(name);
        member.setemail(email);
        member.setcontact(contact);
        Member originMember = memberDao.selectOne(id);
        if(originMember.getpass().equals(member.getpass())) //비밀번호가 맞으면 
        {
            memberDao.updateMember(member);
            return true;
        }
        else
            return false;
    }
    
//    모든 회원정보리스트를 갖고 오는 기능(파라미터 x, 리턴 회원정보셋의 배열)
//    모든 회원정보리스트를 갖고오기
    public List<Member> getMemberList()
    {
        return memberDao.selectAll();
    }
    
//    회원가입하기 기능(파라미터 : 회원정보셋, 리턴 : 가입성공여부)
//    회원정보셋의 id에 해당하는 데이터가 있는지 확인
//    없으면 회원정보셋 데이터를 디비에 추가
    public boolean join(String id, String pass, String name, String email,String contact)
    {
        if(memberDao.selectOne(id) == null)
        {
            Member member = new Member();
            member.setid(id);
            member.setpass(pass);
            member.setname(name);
            member.setemail(email);
            member.setcontact(contact);
            memberDao.insertMember(member);
            return true;
        }
        else 
            return false;
    }
}
