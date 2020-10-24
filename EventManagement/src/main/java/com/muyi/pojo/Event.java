package com.muyi.pojo;

import com.muyi.util.DateFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2020/10/21 0021.
 */
@Data
public class Event {
    private Long id; //事项编号
    private String event;//事项内容
    private int level;//事项级别
    private Date startDate;//录入时间
    private Date endDate;//事项截止时间
    private String startDateStr;//录入时间字符串
    private String endDateStr;//截止时间字符串
    private String levelStr;//级别字符串
    private String Rdate ;//记录查询时间与截止时间差值
    private String status;//记录事项状态信息

    public String getStartDateStr() {
        if(startDate !=null){
            startDateStr = DateFormat.DateToString(this.startDate);
        }
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        if(endDate !=null){
            endDateStr = DateFormat.DateToString(this.endDate);
        }
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getLevelStr() {
        if (level+"" != null){
            if(level == 1){
                levelStr = "紧急";
            }else if (level == 2){
                levelStr = "重要";
            }else if(level == 3){
                levelStr = "一般";
            }
        }
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getRdate() {
        return Rdate;
    }

    public void setRdate(String rdate) {
        Rdate = rdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", level=" + level +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startDateStr='" + startDateStr + '\'' +
                ", endDateStr='" + endDateStr + '\'' +
                '}';
    }
}
