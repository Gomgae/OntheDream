package net.board.action;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.board.db.*;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO boardvo = new BoardVO();
		request.setCharacterEncoding("UTF-8");
		boardvo.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boardvo.setBOARD_NAME(request.getParameter("BOARD_NAME"));
		boardvo.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		boardvo.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		
		BoardDAO boarddao = new BoardDAO();
		boarddao.boardWrite(boardvo);
		boarddao.dbclose();
		ActionForward forward = new ActionForward();
		forward.setPath("BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
	}
}
