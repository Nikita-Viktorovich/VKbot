package com.example.VKBot.model;

import java.util.Objects;

public class Request {
    private String type;
    private Message object;
    private int group_id;
    private String event_id;

    public Request(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Message getObject() {
        return object;
    }

    public void setObject(Message object) {
        this.object = object;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return group_id == request.group_id && Objects.equals(type, request.type) && Objects.equals(object, request.object) && Objects.equals(event_id, request.event_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, object, group_id, event_id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", object=" + object +
                ", group_id=" + group_id +
                ", event_id='" + event_id + '\'' +
                '}';
    }
}
