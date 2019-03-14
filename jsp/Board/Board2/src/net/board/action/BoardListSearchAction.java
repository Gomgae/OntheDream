package net.board.action;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


import net.board.db.BoardDAO;
import net.board.db.BoardVO;

public class BoardListSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO boarddao=new BoardDAO();
		String searchItem = request.getParameter("searchItem"); // 검색 항목
		String searchWord = request.getParameter("searchWord"); // 검색 단어
		
		int count=boarddao.getSearchCount(searchItem,searchWord); // 검색된 글이 총 몇개인지 확인
		int page=1; // 요청 페이지 번호 
		
		if(request.getParameter("page")!=null) // 사용자가 페이지를 요청할때
		page=Integer.parseInt(request.getParameter("page")); // 페이지 번호 확인
		int maxpage = (int)(((double)(count/10))+0.95); // 총 페이지 수
		
		ArrayList<BoardVO> list=boarddao.getBoardSearch(page, 10,searchItem,searchWord); // 보여줄 페이지
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
			forward.setPath("BoardSearchList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
