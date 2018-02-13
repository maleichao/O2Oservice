package com.tykj.member.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.tykj.member.model.Member;
import com.tykj.member.service.IMemberService;
import com.tykj.util.DateUtil;
import com.tykj.util.Utils;
import com.tykj.util.base.BaseController;
import com.webScoke.controller.WebSocketPushHandler;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController{
	@Resource
	private IMemberService memberService;
	/**
	 * 会员对象信息
	 * @param memberId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/getMember",method=RequestMethod.GET)
	@ResponseBody
	public  Map<String,Object> getMember(String memberJsonStr) throws Exception{
		Map<String,Object> model=new HashMap<String,Object>();
		
		try {
		List<Member> list=	memberService.getMemberAll(model);
		model.put("flag", list);
		System.out.println(model);
		} catch (Exception e) {
			throw e;
		} 
		
		return model;
	}
	@RequestMapping(value="/getMemberByParam",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> getMemberByParam(String memberJsonStr,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> model=getFormMap(request);
		if(Utils.objectIsNotEmpty(model)){
			System.out.println(model);
			try {
				List<Member> list=	memberService.getMemberByParam(model);
				model.put("flag", list);
				System.out.println(model);
			} catch (Exception e) {
				throw e;
			} 
		}
		
		return model;
	}
	@RequestMapping(value="/saveMember",method=RequestMethod.GET)
	@ResponseBody
	public Map saveMember(){
		Member member=new Member();
		member.setMemberAuditStatus(0);
		member.setMemberName("test");
		member.setMemberPassword("Pass");
		Date registerDate=DateUtil.getTimestamp();
		member.setRegisterDate(registerDate);
		try {
			memberService.saveMember(member);
		} catch (Exception e) {
		}
		System.out.println(member.getMemberId());
		return null;
		
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(@ModelAttribute Member member ){
		//ThreadPoolManager tpm = ThreadPoolManager.newInstance();
		System.out.println(member.getMemberName());
		for(int i=0;i<60;i++){
		       //System.out.println(i);
			//tpm.addLogMsg( i + "记录一条日志 " );
		   }
		return "/index";
	}
	@RequestMapping(value="/getSessionUrl",method=RequestMethod.GET)
	@ResponseBody
	public Map getSessionUrl(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		if(user==null||user.equals("")){
			session.setAttribute("user", "mlc");
			System.out.println("为空");
		}else{
			System.out.println(user);
		}
		
		return null;
		
	}
	@RequestMapping(value="/sms")
	public void sms(HttpServletRequest httpRequest){
		System.out.println("asdfasdf");
		String token=httpRequest.getParameter("token");
		List<WebSocketSession> list=WebSocketPushHandler.getUsers();
		WebSocketPushHandler webSocketPushHandler=new WebSocketPushHandler();
		//webSocketPushHandler.sendMessagesToUsers(new TextMessage("第二次发送"));
		webSocketPushHandler.sendMessageToUser("2452456", new TextMessage("{\"type\":1}"));;
		
	}

}
