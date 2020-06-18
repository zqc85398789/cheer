package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.ICode;
import java.util.List;

public interface ICodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_code
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_code
     *
     * @mbggenerated
     */
    int insert(ICode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_code
     *
     * @mbggenerated
     */
    ICode selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_code
     *
     * @mbggenerated
     */
    List<ICode> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_code
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ICode record);
}