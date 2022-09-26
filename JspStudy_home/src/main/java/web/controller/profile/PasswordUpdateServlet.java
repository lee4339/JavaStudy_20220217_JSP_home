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


@WebServlet("/profile/update/password")
public class PasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService profileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		profileService = new ProfileServiceImpl((UserDao)servletContext.getAttribute("userDao"));	
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/profile/password-update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("new-password");
		HttpSession session = request.getSession();
		User principarUser = (User)session.getAttribute("principal");
		boolean result = profileService.updatePassword(principarUser.getUser_code(), password);
		if(result == true) {
			response.sendRedirect("/JspStudy_home/profile/mypage");
		} else {
			
		}
	}


}
