package cn.leave.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.leave.pojo.LeaveRecords;
import cn.leave.pojo.Page;
import cn.leave.service.LeaveService;

@Controller
public class LeaveController {
	
	@Resource
	private LeaveService leaveService;
	Page page = null;
	
	@RequestMapping(value="/indexs")
	public String index(Model model,Integer pageIndex){
		//总记录
		int totalCount = leaveService.getLeaveCount();
		int pageSize = 5;	//当前页
		int index = 1;
		if(pageIndex != null){
			index = pageIndex;
		}
		page = new Page();
		page.setPageSize(pageSize);
		page.setCurrPageNo(index);
		page.setTotalCount(totalCount);
		int from = (page.getCurrPageNo() - 1)* page.getPageSize();
		List<LeaveRecords> list = leaveService.getLeaveByPage(from, pageSize);
		model.addAttribute("leave", list);
		model.addAttribute("page", page);
		return "/index";
	}
	
	@RequestMapping("/addLeave")
	public String addLeave(){
		return "/addLeave";
	}
	
	@RequestMapping("/leaveSave")
	public String LeaveSave(LeaveRecords leave,Model model){
		if(leaveService.addLeave(leave) > 0){
			return "redirect:/indexs";
		}
		return "/addLeave";
	}
	
	@RequestMapping("/delLeave")
	public String delLeave(Model model,@RequestParam("id")Integer id){
		System.out.println(id);
		int count = leaveService.delLeaveById(id);
		return "redirect:/indexs";
	}
}
