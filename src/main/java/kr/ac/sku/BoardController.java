package kr.ac.sku;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.sku.model.BoardDTO;
import kr.ac.sku.service.BoardMapper;




@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;

	@RequestMapping(value="/board_list.do")
	public String listBoard(HttpServletRequest req) throws Exception{
		List<BoardDTO>list = boardMapper.listBoard();
		req.setAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/geolocation1.gps")
	public String test1(HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("EUC-KR");		
		return "geolocation/test";
	}
	
	@RequestMapping(value="/geolocation2.gps")
	public String test2(HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("EUC-KR");
		
		HttpSession session = req.getSession();
		session.setAttribute("latitude", req.getParameter("latitude"));
		session.setAttribute("longitude", req.getParameter("longitude"));		
		return "geolocation/test2";
	}
}
