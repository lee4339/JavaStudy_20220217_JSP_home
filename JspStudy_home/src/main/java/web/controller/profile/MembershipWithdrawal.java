package web.controller.profile;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.UserDao;
import repository.user.User;
import web.service.ProfileService;
import web.service.ProfileServiceImpl;

@WebServlet("/profile/delete")
public class MembershipWithdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService profileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		profileService = new ProfileServiceImpl((UserDao)servletContext.getAttribute("userDao"));
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User principalUser = (User)session.getAttribute("principal");
		boolean result = profileService.deleteUser(principalUser.getUser_code());
		if(result == true) {
			session.invalidate();  // 세션을 강제로 만료시킴.
			response.sendRedirect("/JspStudy_home/auth/signin");
		}
	}

	

}
