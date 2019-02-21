import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로딩중...");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + " " + pw);
		
		if(id.equals("1")) {
			response.sendRedirect("1.html");
		}else {
			response.sendRedirect("2.html");
		}
		
/*		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("아이디 = " + id + "<br>");
		out.println("비밀번호 = " + pw);  페이지 만드는방법 */	
		
	//1. redirect 방식 	
		/*request.setAttribute("id", "abc"); // 값을 넣어서
		response.sendRedirect("redirect.jsp");*/
		
/*		//2.Dispatchar 방식
		RequestDispatcher dispatcher=request.getRequestDispatcher("redirect.jsp");
		request.setAttribute("id", "abc");
		dispatcher.forward(request, response);
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

/*	@Override
	public void init() throws ServletException {
	System.out.println(" -- init() -- ");
	}
	@Override
	public void destroy() {
	System.out.println(" -- destroy() -- ");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}*/
	
	
}
