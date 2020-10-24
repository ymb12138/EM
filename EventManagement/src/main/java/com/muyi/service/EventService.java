package com.muyi.service;

import com.muyi.mapper.EventMapper;
import com.muyi.pojo.Event;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/10/21 0021.
 */
@Service
@Transactional
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public List<Event> find(){
        List<Event> events = eventMapper.find();
        if (events != null){
            for (Event e: events
                    ) {
                long Ndate = new Date().getTime();
                long Edate = e.getEndDate().getTime();
                if (Edate <= Ndate){
                    e.setStatus("已超时");
                }else {
                    e.setStatus("未超时");
                }
            }
            return events;
        }else {
        return null;}
    }

    public List<Event> findByEvent(String event) {
        List<Event> events = eventMapper.findByEvent(event);
        return events;
    }

    public void addEvent(Event event) {
        Date date = new Date();
        event.setStartDate(date);
        eventMapper.addEvent(event);
    }

    public void alterEvent(Event event) {
        event.setStartDate(new Date());

        eventMapper.alterEvent(event);
    }

    public void deleteEvent(long id) {
        eventMapper.deleteEvent(id);
    }

    public List<Event> remind(Long time){
        List<Event> events = this.find();
        List<Event> list = new ArrayList<Event>();
        for (Event e: events
             ) {
          long Ndate = new Date().getTime();
          long Edate = e.getEndDate().getTime();
          long between =  (Edate - Ndate)/1000/60/60;
          if(between >=0){
              if (between < time){
                  e.setRdate(String.valueOf(between));
                  list.add(e);
              }
          }
        }
        return list;
    }
    @Test
    public void t(){

        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
       // C:/Users/Administrator/Desktop/待办事项.xls";
        String name = desktopDir.getPath();
        String desktopPath = desktopDir.getAbsolutePath();
        System.out.print(name);
        String s = name.replace("\\","/");
        System.out.print(s);
    }
}
