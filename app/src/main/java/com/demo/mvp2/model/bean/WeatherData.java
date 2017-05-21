package com.demo.mvp2.model.bean;

import java.util.List;

/**
 * Created by jinxiong on 2017/5/21.
 */

public class WeatherData {


    /**
     * status : OK
     * hourly : [{"text":"多云","code":"4","temperature":"25","time":"2017-05-21T10:00:00+08:00"},{"text":"多云","code":"4","temperature":"26","time":"2017-05-21T11:00:00+08:00"},{"text":"多云","code":"4","temperature":"26","time":"2017-05-21T12:00:00+08:00"},{"text":"多云","code":"4","temperature":"26","time":"2017-05-21T13:00:00+08:00"},{"text":"多云","code":"4","temperature":"27","time":"2017-05-21T14:00:00+08:00"},{"text":"多云","code":"4","temperature":"26","time":"2017-05-21T15:00:00+08:00"},{"text":"多云","code":"4","temperature":"25","time":"2017-05-21T16:00:00+08:00"},{"text":"多云","code":"4","temperature":"25","time":"2017-05-21T17:00:00+08:00"},{"text":"多云","code":"4","temperature":"24","time":"2017-05-21T18:00:00+08:00"},{"text":"多云","code":"4","temperature":"21","time":"2017-05-21T19:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-21T20:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-21T21:00:00+08:00"},{"text":"多云","code":"4","temperature":"21","time":"2017-05-21T22:00:00+08:00"},{"text":"多云","code":"4","temperature":"21","time":"2017-05-21T23:00:00+08:00"},{"text":"多云","code":"4","temperature":"21","time":"2017-05-22T00:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-22T01:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-22T02:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-22T03:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-22T04:00:00+08:00"},{"text":"多云","code":"4","temperature":"20","time":"2017-05-22T05:00:00+08:00"},{"text":"多云","code":"4","temperature":"21","time":"2017-05-22T06:00:00+08:00"},{"text":"多云","code":"4","temperature":"23","time":"2017-05-22T07:00:00+08:00"},{"text":"多云","code":"4","temperature":"25","time":"2017-05-22T08:00:00+08:00"},{"text":"多云","code":"4","temperature":"26","time":"2017-05-22T09:00:00+08:00"}]
     */

    private String status;
    private List<HourlyBean> hourly;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<HourlyBean> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyBean> hourly) {
        this.hourly = hourly;
    }

    public static class HourlyBean {
        /**
         * text : 多云
         * code : 4
         * temperature : 25
         * time : 2017-05-21T10:00:00+08:00
         */

        private String text;
        private String code;
        private String temperature;
        private String time;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
