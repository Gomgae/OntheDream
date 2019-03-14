package net.board.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.board.db.*;


public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 부모글 정보 읽어오기
		BoardDAO boarddao = new BoardDAO();
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩 설정
		int num=Integer.parseInt(request.getParameter("num"));
		BoardVO boardvo = boarddao.getDetail(num);
		
		// 2. 부모글 정보에 답글 정보 내용(답글제목,작성자,내용,비번) 업데이트
		boardvo.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		boardvo.setBOARD_NAME(request.getParameter("BOARD_NAME"));
		boardvo.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boardvo.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		
		// 3. 이 정보로 답글 쓰기
		boarddao.boardReply(boardvo);
		boarddao.dbclose();
		
		// 4. 복귀 페이지 설정
		
		ActionForward forward = new ActionForward();
		forward.setPath("BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
	}

}
