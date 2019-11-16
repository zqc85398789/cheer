package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IWorkingHour;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IWorkingHourMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_working_hour
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_working_hour
     *
     * @mbggenerated
     */
    int insert(IWorkingHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_working_hour
     *
     * @mbggenerated
     */
    IWorkingHour selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_working_hour
     *
     * @mbggenerated
     */
    List<IWorkingHour> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table i_working_hour
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IWorkingHour record);
    
    /**
     * 根据起始时间获取工时总数，起始时间通过DateUtil获取
     * @param empno
     * @param startDate
     * @return
     */
    BigDecimal querySumDurationByEmpno(@Param("empno")String empno,@Param("startDate")String startDate);
    
    IWorkingHour queryWorkingHourToday(IWorkingHour iWorkingHour);
    
    int updateIWorkingHourByEmpno(IWorkingHour iWorkingHour);
}