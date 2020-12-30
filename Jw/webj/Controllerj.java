package egovframework.thymleaf.Jw.webj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.thymleaf.Jw.service.Servicej;



@Controller
public class Controllerj {
	
	@Resource(name="Servicej")
	private Servicej Servicej;

	
	@RequestMapping(value = "/thymleaf/j.th")
public String thymleafIndex(Model model, @RequestParam Map<String, String> param) {
		
		
		List<Map<String, Object>> list = Servicej.selectNotice(param);
		
		model.addAttribute("noticeList", list);
		model.addAttribute("inputTx", param.get("inputTx"));
		model.addAttribute("inputGbn", param.get("inputGbn"));
		return "jw/jw.html";
		
	}
	
	@RequestMapping(value="/thymleaf/nextpage.th")
	public String thymleafnext(Model model) {
		return "jw/2page.html";
	}
	@RequestMapping(value="/thymleaf/deleteNoticeJ.th")
	public String thymleafdel(Model model, @RequestParam(name = "no", required = false) String[] param) {
		
	int succes = 0;
	
		try {
		for(int i=0; i<param.length; i++) {
		Map<String, String> map = new HashMap<>();
		
		map.put("NO",param[i]);
		map.put("USE_YN", "N");
		map.put("REG_ID", "invako");
		succes=Servicej.deleteNotice(map);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		model.addAttribute("result", succes);
		return "forward:/thymleaf/j.th";
	}
	
	@RequestMapping(value = "/thymleaf/insertNoticeEmptyJ.th")
	public String insertNoticeEmpty(Model model, @RequestParam(name = "no", required = false) String param) {
		
		Map<String, Object> detail = null;
		
		if(null != param && !"".equals(param)) {
			detail = Servicej.selectNoticeDetail(param);
		}
		
		model.addAttribute("notice", detail);
		return "jw/noticeInsertJ.html";
	}
	
	@RequestMapping(value = "/thymleaf/insertNoticeJ.th")
	public String insertNotice(Model model, @RequestParam Map<String, String> param) {
		
		int succes = 0; 
		
		try {
			
			if(null != param.get("no") && !"".equals(param.get("no"))) {
				succes = Servicej.updateNotice(param);
			} else {
				succes = Servicej.insertNotice(param);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("result", succes);
		return "forward:/thymleaf/j.th";
	}
	
	@RequestMapping(value = "/thymleaf/detailNoticeJ.th")
	public String detailNotice(Model model, @RequestParam(name = "no", required = false) String param) {
		
		Map<String, Object> detail = null;	
		
		if(null != param && !"".equals(param)) {
			detail = Servicej.selectNoticeDetail(param);
		}
		
		model.addAttribute("notice", detail);
		
		return "jw/noticeDetailJ.html";
	}


	@RequestMapping(value = "/thymleaf/login.th")
	public String login(Model model,HttpSession session, @RequestParam Map<String, String> param) {
		
		String id ="admin";
		String passward = "1234";
		
		
		
		if(param.get("ID").equals(id) && param.get("Passward").equals(passward)) {
			System.out.println("true");
			System.out.println(id);
			session.setAttribute("id", id);
			return "forward:/thymleaf/j.th";
			
		} else {
			System.out.println("false");
			return "jw/2page.html";
		}		
	}
	
	@RequestMapping("/thymleaf/logout.th")
	public ModelAndView loginProcess(Model model, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("forward:/thymleaf/j.th");
		return mv;
	}
}
