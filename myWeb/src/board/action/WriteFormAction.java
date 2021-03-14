package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 글 입력 폼 처리
public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 새글과 답변글을 구분할 변수 선언
		int num = 0, ref = 1, step = 0, depth = 0;
		try {
			if(request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				//System.out.println(ref);
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 뷰에서 사용할 속성 담기
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("step", new Integer(step));
		request.setAttribute("depth", new Integer(depth));
		return "/board/writeForm.jsp";
	}
}