package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class JumpServlet
 */
public class JumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet");
		
		// forward転送時、転送する引数生成。
		request.setAttribute("java", 21);
		
		// forward(page移動) : 従来のURLが固定 -> 内容だけを変更
		RequestDispatcher rd =request.getRequestDispatcher("jump.jsp");	// 凄く原始的な方法。
		
		//
		rd.forward(request, response);
	}

}
