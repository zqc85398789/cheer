package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IPrivilege;
import java.util.List;

public interface IPrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_privilege
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_privilege
     *
     * @mbggenerated
     */
    int insert(IPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_privilege
     *
     * @mbggenerated
     */
    IPrivilege selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_privilege
     *
     * @mbggenerated
     */
    List<IPrivilege> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_privilege
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IPrivilege record);
}