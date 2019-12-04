package cn.leave.pojo;

public class Page {
	private Integer currPageNo; // 当前页
	private Integer totalCount; // 总记录
	private Integer totalPageCount; // 总页数
	private Integer pageSize; // 页大小

	public Integer getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.totalPageCount = this.totalCount % this.pageSize == 0 ? this.totalCount
					/ this.pageSize
					: this.totalCount / this.pageSize + 1;
		}
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
