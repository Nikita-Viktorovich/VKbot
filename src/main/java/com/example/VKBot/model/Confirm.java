package com.example.VKBot.model;

import java.util.Objects;

public class Confirm {
    private String type;
    private int groupId;

    public Confirm(String type, int groupId){
        setGroupId(groupId);
        setType(type);
    }

    public int getGroupId() {
        return groupId;
    }

    public String getType() {
        return type;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confirm confirm = (Confirm) o;
        return groupId == confirm.groupId && Objects.equals(type, confirm.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, groupId);
    }

    @Override
    public String toString() {
        return "Confirm{" +
                "type='" + type + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
