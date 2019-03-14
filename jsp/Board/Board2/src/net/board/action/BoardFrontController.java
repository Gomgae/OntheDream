package net.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.*;

public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String ContextPath=request.getContextPath();
		String command=RequestURI.substring(ContextPath.length());
	    StringBuffer RequestURL=request.getRequestURL();
	    System.out.println(RequestURI);
	    System.out.println(ContextPath);
	    System.out.println(RequestURL);
	    ActionForward forward=null;
	    Action action=null; 
		if(command.equals("/BoardList.bo")) {
			 action= new BoardList();
			 forward=action.execute(request, response);
		}else if(command.equals("/BoardAddAction.bo")) {
			action=new BoardAddAction();
			forward=action.execute(request, response);
			
		}else if(command.equals("/redirect.bo")) {
			response.sendRedirect("redirect.jsp");
		}else if(command.equals("/BoardDetailAction.bo")) {
			action = new BoardDetailAction();
			forward=action.execute(request, response);
		}else if(command.equals("/BoardDeleteAction.bo")) {
			action = new BoardDeleteAction();
			forward=action.execute(request, response);
				
		}else if ( command.equals("/BoardDelete.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/BoardDelete.jsp");			
			
		}else if(command.equals("/BoardReply.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/BoardReply.jsp");
		}else if(command.equals("/BoardReplyAction.bo")) {
			action = new BoardReplyAction();
			forward=action.execute(request, response);
			
		}else if(command.equals("/BoardListSearch.bo")) {
			System.out.println("½ÇÇè2");
			action = new BoardListSearchAction();
			forward=action.execute(request, response);
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
