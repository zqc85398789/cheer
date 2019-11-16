package com.cheer.mybatis.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cheer.util.DateUtil;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table i_leave_day
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ILeaveDay implements Serializable{
    /**
     * id
    */
    private Integer id;

    /**
     * empno
    */
    @NotBlank(message = "{staff.empno.empty}")
    private String empno;

    /**
     * leave_date
    */
    @NotNull(message="{leaveDay.leaveDate.empty}")
    private Date leaveDate;
    
    private String leaveDateAsStr;

    /**
     * days
    */
    @NotNull(message="{leaveDay.days.empty}")
    private Integer days;

    /**
     * created_by
    */
    private String createdBy;

    /**
     * created_time
    */
    private Date createdTime;

    /**
     * update_time
    */
    private Date updateTime;

    /**
     * update_by
    */
    private String updateBy;

    /**
     * version
    */
    private Integer version;
    
    private IStaff iStaff;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.id
     *
     * @return the value of i_leave_day.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.id
     *
     * @param id the value for i_leave_day.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.empno
     *
     * @return the value of i_leave_day.empno
     *
     * @mbggenerated
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.empno
     *
     * @param empno the value for i_leave_day.empno
     *
     * @mbggenerated
     */
    public void setEmpno(String empno) {
        this.empno = empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.leave_date
     *
     * @return the value of i_leave_day.leave_date
     *
     * @mbggenerated
     */
    public Date getLeaveDate() {
        return leaveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.leave_date
     *
     * @param leaveDate the value for i_leave_day.leave_date
     *
     * @mbggenerated
     */
    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveDateAsStr() {
    	if(this.leaveDate!=null) {
			this.leaveDateAsStr = DateUtil.dateFormat(this.leaveDate, DateUtil.DATE_PATTERN);
		}else {
			this.leaveDateAsStr = "";
		}
		return leaveDateAsStr;
	}

	public void setLeaveDateAsStr(String leaveDateAsStr) {
		if(this.leaveDate!=null) {
			this.leaveDateAsStr = DateUtil.dateFormat(this.leaveDate, DateUtil.DATE_PATTERN);
		}else {
			this.leaveDateAsStr = "";
		}
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.days
     *
     * @return the value of i_leave_day.days
     *
     * @mbggenerated
     */
    public Integer getDays() {
        return days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.days
     *
     * @param days the value for i_leave_day.days
     *
     * @mbggenerated
     */
    public void setDays(Integer days) {
        this.days = days;
    }

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.created_by
     *
     * @return the value of i_leave_day.created_by
     *
     * @mbggenerated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.created_by
     *
     * @param createdBy the value for i_leave_day.created_by
     *
     * @mbggenerated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.created_time
     *
     * @return the value of i_leave_day.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.created_time
     *
     * @param createdTime the value for i_leave_day.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.update_time
     *
     * @return the value of i_leave_day.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.update_time
     *
     * @param updateTime the value for i_leave_day.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.update_by
     *
     * @return the value of i_leave_day.update_by
     *
     * @mbggenerated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.update_by
     *
     * @param updateBy the value for i_leave_day.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_leave_day.version
     *
     * @return the value of i_leave_day.version
     *
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_leave_day.version
     *
     * @param version the value for i_leave_day.version
     *
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public IStaff getiStaff() {
		return iStaff;
	}

	public void setiStaff(IStaff iStaff) {
		this.iStaff = iStaff;
	}




	private String createdTimeAsStr;
	private String updateTimeAsStr;

	public String getCreatedTimeAsStr() {
		return DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public void setCreatedTimeAsStr(String createdTimeAsStr) {
		this.createdTimeAsStr = DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public String getUpdateTimeAsStr() {
		if(this.updateTime==null) {
			return "";
		}
		return DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
	}

	public void setUpdateTimeAsStr(String updateTimeAsStr) {
		if(this.updateTime!=null) {
			this.updateTimeAsStr = DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
		}else {
			this.updateTimeAsStr="";
		}
	}
	
	
}