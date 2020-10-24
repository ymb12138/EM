package com.muyi.controller;

import com.muyi.pojo.Event;
import com.muyi.service.EventService;
import com.muyi.util.DateFormat;
import com.muyi.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
/**
 *@author         muyi
 * @exception
 * @date        020/10/21 0021.
 * @description eventController
 */
@Controller
public class controller {
    @Autowired
    private EventService eventService;

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 查询全部事项信息按level升序排序
     */
    @RequestMapping("/find")
    public ModelAndView find(@RequestParam(value = "time",defaultValue = "24") Long time){
        List<Event> events = eventService.find();
        List<Event> list = eventService.remind(time);
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("events",events);
        mav.addObject("list",list);
        mav.addObject("t",time);
        return mav;
    }

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 通过内容关键字进行模糊查询
     */
    @RequestMapping("/findByEvent")
    public ModelAndView findByEvent(@RequestParam("event") String event){
        List<Event> events = eventService.findByEvent(event);
        for (Event e:events
             ) {
            if ((e.getEndDate().getTime() - new Date().getTime()) > 0){
                e.setStatus("未过期");
            }else {
                e.setStatus("已过期");
            }
        }
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("events",events);
        return mav;
    }

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 添加事项
     */
    @RequestMapping("/addEvent")
    public ModelAndView addEvent(@RequestParam("event") String event ,
                                 @RequestParam("level") String level ,
                                 @RequestParam("endDateStr") String endDateStr) throws Exception{
        String date = endDateStr.replace("T"," ");
        Event Event = new Event();
        Event.setEvent(event);
        Event.setLevel(Integer.valueOf(level));
        Event.setEndDate(DateFormat.StringToDate(date));
        eventService.addEvent(Event);
        return new ModelAndView("redirect:/find");
    }

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 修改事项
     */
    @RequestMapping("/alterEvent")
    public ModelAndView alterEvent(@RequestParam("event") String event ,
                                   @RequestParam("level") String level ,
                                   @RequestParam("id") Long id ,
                                   @RequestParam("endDateStr") String endDateStr) throws Exception{
        Event ev = new Event();
        ev.setId(id);
        ev.setEvent(event);
        ev.setLevel(Integer.valueOf(level));
        ev.setEndDate(DateFormat.StringToDate(endDateStr.replace("T"," ")));
        eventService.alterEvent(ev);
        return new ModelAndView("redirect:/find");
    }

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 删除事项
     */
    @RequestMapping("/deleteEvent")
    public ModelAndView deleteEvent(@RequestParam("id") long id){
        eventService.deleteEvent(id);
        return new ModelAndView("redirect:/find");
    }

    /**
     *@author         muyi
     * @exception
     * @date        020/10/21 0021.
     * @description 下载事项至桌面
     */
    @RequestMapping("/download")
    public ModelAndView download() {
        List<Event> list = eventService.find();
        util.WriteExcel(list);
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("message","文件已下载至您的桌面");
        mav.addObject("events",list);
        return mav;
    }
}
