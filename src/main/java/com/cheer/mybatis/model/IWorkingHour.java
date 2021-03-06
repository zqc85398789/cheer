package com.cheer.mybatis.model;

import java.io.Serializable;
import java.util.Date;

import com.cheer.util.DateUtil;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table i_working_hour
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class IWorkingHour implements Serializable{
    /**
     * id
    */
    private Integer id;

    /**
     * working_date
    */
    private Date workingDate;
    
    private String workingDateAsStr;

    /**
     * duration
    */
    private Integer duration;
    
    private Integer yearDuration;
    
	private Integer monthDuration;
	
	private IStaff iStaff;

    /**
     * created_by
    */
    private String createdBy;

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

    /**
     * empno
    */
    private String empno;

    /**
     * created_time
    */
    private Date createdTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.id
     *
     * @return the value of i_working_hour.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.id
     *
     * @param id the value for i_working_hour.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.working_date
     *
     * @return the value of i_working_hour.working_date
     *
     * @mbggenerated
     */
    public Date getWorkingDate() {
        return workingDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.working_date
     *
     * @param workingDate the value for i_working_hour.working_date
     *
     * @mbggenerated
     */
    public void setWorkingDate(Date workingDate) {
        this.workingDate = workingDate;
    }
    
    

    public String getWorkingDateAsStr() {
    	if(this.workingDate==null) {
			this.workingDateAsStr = "";
		}else {
			this.workingDateAsStr = DateUtil.dateFormat(this.workingDate, DateUtil.DATE_PATTERN);
		}
		return workingDateAsStr;
	}

	public void setWorkingDateAsStr(String workingDateAsStr) {
		if(this.workingDate==null) {
			this.workingDateAsStr = "";
		}else {
			this.workingDateAsStr = DateUtil.dateFormat(this.workingDate, DateUtil.DATE_PATTERN);
		}
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.duration
     *
     * @return the value of i_working_hour.duration
     *
     * @mbggenerated
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.duration
     *
     * @param duration the value for i_working_hour.duration
     *
     * @mbggenerated
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    

    public Integer getYearDuration() {
		return yearDuration;
	}

	public void setYearDuration(Integer yearDuration) {
		this.yearDuration = yearDuration;
	}

	public Integer getMonthDuration() {
		return monthDuration;
	}

	public void setMonthDuration(Integer monthDuration) {
		this.monthDuration = monthDuration;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.created_by
     *
     * @return the value of i_working_hour.created_by
     *
     * @mbggenerated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.created_by
     *
     * @param createdBy the value for i_working_hour.created_by
     *
     * @mbggenerated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.update_time
     *
     * @return the value of i_working_hour.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.update_time
     *
     * @param updateTime the value for i_working_hour.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.update_by
     *
     * @return the value of i_working_hour.update_by
     *
     * @mbggenerated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.update_by
     *
     * @param updateBy the value for i_working_hour.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.version
     *
     * @return the value of i_working_hour.version
     *
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.version
     *
     * @param version the value for i_working_hour.version
     *
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.empno
     *
     * @return the value of i_working_hour.empno
     *
     * @mbggenerated
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.empno
     *
     * @param empno the value for i_working_hour.empno
     *
     * @mbggenerated
     */
    public void setEmpno(String empno) {
        this.empno = empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_working_hour.created_time
     *
     * @return the value of i_working_hour.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_working_hour.created_time
     *
     * @param createdTime the value for i_working_hour.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

	public IStaff getiStaff() {
		return iStaff;
	}

	public void setiStaff(IStaff iStaff) {
		this.iStaff = iStaff;
	}
	
}