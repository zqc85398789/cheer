package com.cheer.mybatis.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.cheer.util.DateUtil;
import com.cheer.validator.annotation.IsEmpno;
import com.cheer.validator.annotation.IsIdCard;
import com.cheer.validator.annotation.IsTelephone;

public class IStaff implements Serializable{
    private Integer id;

    @NotBlank(message="{staff.staffName.empty}")
    private String staffName;

    @NotNull(message="{staff.birthDate.empty}")
	@Past(message="{staff.birthDate.past}")
    private Date birthDate;
    
    private String birthDateAsStr;

    @NotBlank(message="{staff.telephoneNo.empty}")
	@IsTelephone(message="{staff.telephoneNo.pattern}")
    private String telephoneNo;

    @NotBlank(message="{staff.idCard.empty}")
	@IsIdCard(message="{staff.idCard.pattern}")
    private String idCard;

    private String gender;

    private String emergencyContact;

    private String emergencyTel;

    @NotBlank(message="{staff.empno.empty}")
	@IsEmpno(message="{staff.empno.pattern}")
    private String empno;

    private Date createdTime;

    private String createdBy;

    private Date updateTime;

    private String updateBy;

    private Integer version;

    private String isActive;

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.id
     *
     * @param id the value for i_staff.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.staff_name
     *
     * @return the value of i_staff.staff_name
     *
     * @mbggenerated
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.staff_name
     *
     * @param staffName the value for i_staff.staff_name
     *
     * @mbggenerated
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.birth_date
     *
     * @return the value of i_staff.birth_date
     *
     * @mbggenerated
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.birth_date
     *
     * @param birthDate the value for i_staff.birth_date
     *
     * @mbggenerated
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateAsStr() {
    	if(this.birthDate != null) {
			this.birthDateAsStr = DateUtil.dateFormat(this.birthDate, DateUtil.DATE_PATTERN);
		}else {
			this.birthDateAsStr = "";
		}
		return this.birthDateAsStr;
	}

	public void setBirthDateAsStr(String birthDateAsStr) {
		if(this.birthDate != null) {
			this.birthDateAsStr = DateUtil.dateFormat(this.birthDate, DateUtil.DATE_PATTERN);
		}else {
			this.birthDateAsStr = "";
		}
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.telephone_no
     *
     * @return the value of i_staff.telephone_no
     *
     * @mbggenerated
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.telephone_no
     *
     * @param telephoneNo the value for i_staff.telephone_no
     *
     * @mbggenerated
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.id_card
     *
     * @return the value of i_staff.id_card
     *
     * @mbggenerated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.id_card
     *
     * @param idCard the value for i_staff.id_card
     *
     * @mbggenerated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.gender
     *
     * @return the value of i_staff.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.gender
     *
     * @param gender the value for i_staff.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.emergency_contact
     *
     * @return the value of i_staff.emergency_contact
     *
     * @mbggenerated
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.emergency_contact
     *
     * @param emergencyContact the value for i_staff.emergency_contact
     *
     * @mbggenerated
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.emergency_tel
     *
     * @return the value of i_staff.emergency_tel
     *
     * @mbggenerated
     */
    public String getEmergencyTel() {
        return emergencyTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.emergency_tel
     *
     * @param emergencyTel the value for i_staff.emergency_tel
     *
     * @mbggenerated
     */
    public void setEmergencyTel(String emergencyTel) {
        this.emergencyTel = emergencyTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.empno
     *
     * @return the value of i_staff.empno
     *
     * @mbggenerated
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.empno
     *
     * @param empno the value for i_staff.empno
     *
     * @mbggenerated
     */
    public void setEmpno(String empno) {
        this.empno = empno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.created_time
     *
     * @return the value of i_staff.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.created_time
     *
     * @param createdTime the value for i_staff.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.created_by
     *
     * @return the value of i_staff.created_by
     *
     * @mbggenerated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.created_by
     *
     * @param createdBy the value for i_staff.created_by
     *
     * @mbggenerated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.update_time
     *
     * @return the value of i_staff.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.update_time
     *
     * @param updateTime the value for i_staff.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.update_by
     *
     * @return the value of i_staff.update_by
     *
     * @mbggenerated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.update_by
     *
     * @param updateBy the value for i_staff.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.version
     *
     * @return the value of i_staff.version
     *
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.version
     *
     * @param version the value for i_staff.version
     *
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column i_staff.is_active
     *
     * @return the value of i_staff.is_active
     *
     * @mbggenerated
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column i_staff.is_active
     *
     * @param isActive the value for i_staff.is_active
     *
     * @mbggenerated
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
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