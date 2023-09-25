package test2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() {
		handlerMapping = new HandlerMapping();
		
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");	//setter 주입
		viewResolver.setSuffix(".jsp");	//setter 주입
	}
	
    public DispatcherServlet() {
        super();
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri=request.getRequestURI();
    	String command=uri.substring(uri.lastIndexOf("/"));
    	System.out.println("command: "+command);
    	
    	Controller ctrl=handlerMapping.getController(command);
    	String viewName =ctrl.handleRequest(request, response); // 경로를 대강 컨트롤러로 반환
    	// viewName이 .do를 가진다 ---> view를 가는게 아니라 ctrl를 한번 더 수행하는거
    	// 그래서 .do.jsp와 같은 경우 발생
    	// 다형성 형성(피카츄)
    	
    	String path = viewName;
    	if(!viewName.contains(".do")) {	
    		path = viewResolver.getView(viewName);			// 정확한 경로로 변환
    	}
    	
    	response.sendRedirect(path);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
}
