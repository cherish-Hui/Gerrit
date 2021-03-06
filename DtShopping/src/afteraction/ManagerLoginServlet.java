package afteraction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Manager;
import service.QueryUpdateService;

/**
 * Servlet implementation class QueryManagerServlet
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Object[]obj={username,password};
		QueryUpdateService qus=new QueryUpdateService();
		try {
				Manager manager=qus.QueryManager(obj);
				if(manager!=null&&manager.getState().equals("1")){
				request.setAttribute("manager", manager);
				request.getRequestDispatcher("AfterJsp/index.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "用户名或密码不正确");
					request.getRequestDispatcher("AfterJsp/afterlogin.jsp").forward(request, response);
				}
				} catch (Exception e) {
				e.printStackTrace();
				System.out.println("查询失败");
				}	
		
	}
}
