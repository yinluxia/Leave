package cn.leave.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.leave.pojo.LeaveRecords;

public interface LeaveService {
	/**
	 * 分页查询请假记录信息
	 * 
	 * @param from
	 * @param pageSize
	 * @return
	 */
	public List<LeaveRecords> getLeaveByPage(@Param("from") Integer from,
			@Param("pageSize") Integer pageSize);

	/**
	 * 查询请假信息总记录数
	 * 
	 * @return
	 */
	public int getLeaveCount();

	/**
	 * 添加新的请假记录信息
	 * 
	 * @param leaveRecords
	 * @return
	 */
	public int addLeave(LeaveRecords leaveRecords);

	/**
	 * 根据指定的id删除请假信息
	 * @param id
	 * @return
	 */
	public int delLeaveById(@Param("id") Integer id);
}
