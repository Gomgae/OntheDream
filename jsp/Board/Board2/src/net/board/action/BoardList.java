package net.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardVO;

public class BoardList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boarddao=new BoardDAO();
		int count=boarddao.getListCount();
		int page=1; // 요청 페이지 번호 
		int limit=10;
		
		if(request.getParameter("page")!=null) // 사용자가 페이지를 요청할때
		page=Integer.parseInt(request.getParameter("page")); // 페이지 번호 확인
		int maxpage = (int)(((double)(count/10))+0.95); // 총 페이지 수
		
		ArrayList<BoardVO> list=boarddao.getBoardList(page, limit); // 보여줄 페이지
		boarddao.dbclose();	
		
		int startpage=(int)((double)( page/10 + 0.9 )-1)*10+1; // 현재 페이지에서 보여줄 페이지 화면 수
		int endpage=startpage+10-1; // 현재 페이지에 보여줄 마지막 페이지 수
		if(endpage > maxpage) endpage = maxpage;
		
		request.setAttribute("page", page);  // 현재 페이지 화면 보여주기
		request.setAttribute("count", count); // 전체글 수
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("list", list); // 보여줄 페이지 화면

		
		ActionForward forward = new ActionForward();
		forward.setPath("BoardList.jsp");
		forward.setRedirect(false);
		return forward;
	}

	
	
	
	
	
	
	
	
	
	
}
