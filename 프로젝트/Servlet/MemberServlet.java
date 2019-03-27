package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import model.Member;
import service.MemberService;

public class MemberServlet extends HttpServlet {
    private MemberService service;
    public MemberServlet(){
        service= new MemberService();
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req,resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req,resp);
    }
    
    protected void doProc(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String contextPath = req.getContextPath();
        String reqUri = req.getRequestURI();
//---------------------------------------------------------------------------------------        
        //로그인
        if(reqUri.equals(contextPath + "/login.do"))
        {
            String id = req.getParameter("id");
            String pass = req.getParameter("pass");
			if(service.login(id, pass)){
                req.setAttribute("msg", "로그인 성공");
                req.getSession().setAttribute("id", id);
            }
            else{
                req.setAttribute("msg", "로그인 실패");
            }
            req.getRequestDispatcher("loginResult.jsp").forward(req, resp);
        }
        else if(reqUri.equals(contextPath + "/loginForm.do"))   //loginForm보여줘
        {
            req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
        }
        else if(reqUri.equals(contextPath + "/main.do"))   //main보여줘
        {
            if(req.getSession().getAttribute("id") == null)
            {
                
                    resp.sendRedirect("loginForm.do");
                    //계속 실행되기 때문에 꼭 리턴해줘야함
                    return;
            }
            
                req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
//-----------------------------------------------------------------------------------------
            
//                memberUpdateForm : 회원정보 수정 폼을 보여달라는 요청
//                파라미터 id가 가져갈 데이터 회원정보셋트
            else if(reqUri.equals(contextPath + "/memberUpdateForm.do"))
            {
                
                String id = req.getParameter("id");
                Member member = service.getMember(id); //id에 해당하는 회원정보셋트 데이터를 가지고
                req.setAttribute("member", member);
                req.getRequestDispatcher("memberUpdateForm.jsp") //memberUpdateForm.jsp로 포워드
                .forward(req, resp);
            }
//-----------------------------------------------------------------------------------------
 
//            memberUpdate.do만들차례임
//            memberUpdate : 회원정보들을 수정해달라는 요청
//            파라미터 : 회원들의 모든정보
//            가저갈데이터는 X
//            main요청으로 redirect
            else if(reqUri.equals(contextPath + "/memberUpdate.do"))
            {
            String id = req.getParameter("id");
            String pw = req.getParameter("pw");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String contact = req.getParameter("contact");
            service.update(id, pw, name, email,contact);
            resp.sendRedirect("main.do");
            return;
            }
//-----------------------------------------------------------------------------------------
//            메인 페이지에서 전체회원보기 버튼을 누르면 발생요청
//            memberList : 모든 회원정보를 보여달라는 요청
//            파라미터 X , 가져갈 데이터 모든 회원들의 정보
//            이동할 페이지 : memberList.jsp로 포워드
            else if(reqUri.equals(contextPath + "/memberList.do"))
            {
                req.setAttribute("memberList", service.getMemberList());
                req.getRequestDispatcher("memberList.jsp")
                .forward(req, resp);
            }
//-----------------------------------------------------------------------------------------    
//            joinFrom : 회원가입 폼을 보여달라는 요청
//            파라미터 X, 가져갈 데이터 없음
//            이동할 페이지는 loginForm.jsp로 포워드
            else if(reqUri.equals(contextPath + "/joinForm.do"))
            {
                req.getRequestDispatcher("joinForm.jsp")
                .forward(req, resp);
            }
            
//-----------------------------------------------------------------------------------------
//            join : 회원가입처리를 해달라는 요청
//            파라미터 : id, pw, name, email    가져갈 데이터는 없음
//            이동할 페이지는 loginForm 요청으로 redirect
            
            else if(reqUri.equals(contextPath + "/join.do"))
            {
            String id = req.getParameter("id");
            String pass = req.getParameter("pass");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String contact = req.getParameter("contact");
            service.join(id, pass, name, email,contact);
            resp.sendRedirect("loginForm.do");
            return;
            }
            
        }
        
    }
