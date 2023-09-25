package test2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 기존의 Action
public interface Controller {
	// 기존의 .excute와 다르게 String 반환
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
