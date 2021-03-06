package fontAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Messager;
import model.User;
import service.UserServiceImpl;
import utils.BeanJsonUtil;

@WebServlet("/RegisterServlet1")
public class RegisterServlet1 extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	

	HttpSession session = request.getSession();
	String email = (String) session.getAttribute("email2");
	
	
	User user = new User();

	UserServiceImpl uImpl = new UserServiceImpl();
	Messager messager;

	try {
		if (password1.equals(password2)) {
			user.setEmail(email);
			user.setPassword(password1);
			uImpl.register(user);
			

		    request.setAttribute("msg", 200);	

		    messager = new Messager("200", "注册成功！请登陆");
			

		} else {

			request.setAttribute("msg", 250);

			messager = new Messager("250", "注册失败！请重新注册");

		}
		BeanJsonUtil.writeJson(response, messager);
	} catch (Exception e) {
			request.getRequestDispatcher("/FontJsp/error2.jsp").forward(request, response);
		
		
	}
	
}
	

}
