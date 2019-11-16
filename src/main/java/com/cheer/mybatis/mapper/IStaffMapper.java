package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IStaff;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_staff
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_staff
     *
     * @mbggenerated
     */
    int insert(IStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_staff
     *
     * @mbggenerated
     */
    IStaff selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_staff
     *
     * @mbggenerated
     */
    List<IStaff> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_staff
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IStaff record);

	List<IStaff> queryIStaffInPage(@Param("iStaff")IStaff iStaff, @Param("start")int start, @Param("quantity")int quantity);

	Long countIStaff(IStaff iStaff);
	
	public List<IStaff> queryIStaffByEmpno(IStaff iStaff);
	
	public int changeStatus(IStaff iStaff);

}