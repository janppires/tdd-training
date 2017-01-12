package com.janppires.tdd.garbagenotifier;

public class Event {
    private String date;
    private String time;
    private String garbageType;

    public Event(String date, String time, String garbageType) {
        this.date = date;
        this.time = time;
        this.garbageType = garbageType;
    }

    public String getTime() {
        return time;
    }

    public String getGarbageType() {
        return garbageType;
    }

    public String getDate() {
        return date;
    }
}
