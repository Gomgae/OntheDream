package net.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardVO;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boarddao=new BoardDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		BoardVO boardvo=boarddao.getDetail(num);
		boarddao.dbclose();
		request.setAttribute("boardvo", boardvo);
		ActionForward forward = new ActionForward();
		forward.setPath("BoardDetail.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
