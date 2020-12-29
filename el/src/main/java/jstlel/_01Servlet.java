package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _01Servlet
 */
public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값
		int iVal = 10;
		long lVal = 10;
		float fVal = 1.4f;
		boolean bVal = true;
		String sVal = "Hello world";
		
		// 객체 테스트
		Object obj = null;
		UserVo vo = new UserVo();
		vo.setNo(10L);
		vo.setName("오\n지\n영\n입\n니\n다\n");
		
		// Map을 이용해 여러 값을 한번에 넘기기
		Map<String, Object> map = new HashMap<>();
		map.put("iVal", iVal);
		map.put("lVal", lVal);
		map.put("fVal", fVal);
		map.put("bVal", bVal);
		
		request.setAttribute("iVal", iVal);
		request.setAttribute("lVal", lVal);
		request.setAttribute("fVal", fVal);
		request.setAttribute("bVal", bVal);
		request.setAttribute("sVal", sVal);
		request.setAttribute("obj", obj);
		request.setAttribute("vo", vo);
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/views/01.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
