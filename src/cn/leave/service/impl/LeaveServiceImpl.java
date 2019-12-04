package cn.leave.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.leave.dao.LeaveMapper;
import cn.leave.pojo.LeaveRecords;
import cn.leave.service.LeaveService;
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
	@Resource
	private LeaveMapper leaveMapper;
	
	@Override
	public List<LeaveRecords> getLeaveByPage(Integer from, Integer pageSize) {
		return leaveMapper.getLeaveByPage(from, pageSize);
	}

	@Override
	public int getLeaveCount() {
		return leaveMapper.getLeaveCount();
	}

	@Override
	public int addLeave(LeaveRecords leaveRecords) {
		return leaveMapper.addLeave(leaveRecords);
	}

	@Override
	public int delLeaveById(Integer id) {
		return leaveMapper.delLeaveById(id);
	}

}
