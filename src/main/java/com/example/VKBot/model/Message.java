package com.example.VKBot.model;

import java.util.Arrays;
import java.util.Objects;

public class Message {
    private int id;
    private long date;
    private int out;
    private long user_id;
    private int read_state;
    private String title;
    private String body;
    private long[] owner_ids;

    public Message(){}

    public Message(int id, long date, int out, long user_id, int read_state, String title, String body, long[] owner_ids) {
       setId(id);
       setDate(date);
       setOut(out);
       setUser_id(user_id);
       setRead_state(read_state);
       setTitle(title);
       setBody(body);
       setOwner_ids(owner_ids);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getRead_state() {
        return read_state;
    }

    public void setRead_state(int read_state) {
        this.read_state = read_state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long[] getOwner_ids() {
        return owner_ids;
    }

    public void setOwner_ids(long[] owner_ids) {
        this.owner_ids = owner_ids;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", out=" + out +
                ", user_id=" + user_id +
                ", read_state=" + read_state +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", owner_ids=" + Arrays.toString(owner_ids) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && date == message.date && out == message.out && user_id == message.user_id && read_state == message.read_state && Objects.equals(title, message.title) && Objects.equals(body, message.body) && Arrays.equals(owner_ids, message.owner_ids);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, date, out, user_id, read_state, title, body);
        result = 31 * result + Arrays.hashCode(owner_ids);
        return result;
    }


}
