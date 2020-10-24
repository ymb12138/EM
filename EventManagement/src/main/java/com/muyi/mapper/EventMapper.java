package com.muyi.mapper;

import com.muyi.pojo.Event;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/10/21 0021.
 */
public interface EventMapper {
    @Select("select* from event ORDER BY level asc")
    List<Event> find();

    @Select("select* from event where event like '%' #{event} '%'")
    List<Event> findByEvent(String event);

    @Insert("insert into event(event,level,startDate,endDate) values(#{event},#{level},#{startDate},#{endDate})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void addEvent(Event event);

    @Update("update event set event = #{event},level = #{level},startDate " +
            "= #{startDate},endDate = #{endDate} where id = #{id}")
    void alterEvent(Event event);

    @Delete("delete from event where id = #{id}")
    void deleteEvent(long id);
}
