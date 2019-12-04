package cn.leave.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 请假实体类
 * @author YINLUXIA
 *
 */
public class LeaveRecords {
	private int id;		//主键id
	private String name;//姓名
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTime;	//请假时间
	private String reason;	//请假原因
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
