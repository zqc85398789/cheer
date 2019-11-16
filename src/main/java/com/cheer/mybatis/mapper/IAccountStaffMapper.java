package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IAccountStaff;
import java.util.List;

public interface IAccountStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_account_staff
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_account_staff
     *
     * @mbggenerated
     */
    int insert(IAccountStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_account_staff
     *
     * @mbggenerated
     */
    IAccountStaff selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_account_staff
     *
     * @mbggenerated
     */
    List<IAccountStaff> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_account_staff
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IAccountStaff record);
}