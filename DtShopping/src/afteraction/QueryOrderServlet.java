package afteraction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.User;
import service.QueryUpdateService;


/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
      protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String id=request.getParameter("id");
  		  String state=request.getParameter("state");
  		  String orderstate=request.getParameter("orderstate");
  		  Object []obj={id,state,orderstate};
    	  QueryUpdateService qus=new QueryUpdateService();
    	  
  		 if(id==null&&state==null&&orderstate==null){
  			List list=qus.QueryOrder();
  		 try {
  			 request.setAttribute("order", list);
  	  		  request.getRequestDispatcher("/AfterJsp/order_list.jsp").forward(request, response);
  		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
  	}else{
  		List list=qus.QueryOrderCondition(obj);
  		try {
			request.setAttribute("order", list);
			request.getRequestDispatcher("/AfterJsp/order_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
  		
  	}
  }

}
