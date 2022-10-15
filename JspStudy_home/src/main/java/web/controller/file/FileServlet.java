package web.controller.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import repository.FileDao;
import web.service.FileService;
import web.service.FileServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, //임시 파일 크기 1MB
		maxFileSize = 1024 * 1024 * 50,  //업로드할 때 파일의 최대 크기 50MB
		maxRequestSize = 1024 * 1024 * 50 * 3 //요청시에 최대 크기 150MB
)
@WebServlet("/file-upload")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		fileService = new FileServiceImpl((FileDao)servletContext.getAttribute("fileDao"));
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/file/file.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> fileList = new ArrayList<String>(); 
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for(Part part : parts) {
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String fileName = part.getSubmittedFileName();
			String tempFileName = uuid + "_" + fileName;
			
			fileName = part.getSubmittedFileName();
			
			InputStream is = part.getInputStream();
			String realPath = request.getServletContext().getRealPath("/static/fileupload");
			
			File path = new File(realPath);
			if(!path.exists()) {
				path.mkdirs();
			}
			String filePath = realPath + File.separator + tempFileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			int size = 0;
			byte[] buf = new byte[1024];
			while((size = is.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fileList.add(tempFileName);
			
		}
		fileService.uploadFile(fileList);
		response.sendRedirect("/JspStudy_home/file-upload");
	}


}