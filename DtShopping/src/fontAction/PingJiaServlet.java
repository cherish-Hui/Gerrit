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
import service.PhoService;
import utils.BeanJsonUtil;

@WebServlet("/PingJiaServlet")
public class PingJiaServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PhoService phoService = new PhoService();
		HttpSession session = request.getSession(false);
		User user=(User)session.getAttribute("user");
		String goods=request.getParameter("name");
		String con=request.getParameter("con");
		
		phoService.updateping(goods, user.getUser_id());
		
		int i = phoService.addPing(goods, user.getUser_id(), con);
		Messager messager = new Messager("200","你的评论棒棒的" );
		if (i==0) {
			messager = new Messager("250", "不好意思，你的评论无效");
		}
		BeanJsonUtil.writeJson(response, messager);
	}
}
