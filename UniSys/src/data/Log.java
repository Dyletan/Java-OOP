package data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Log implements Serializable {
    private Integer userId;
    private String action;
    private LocalDateTime time;

    public Log() {
    }

    public Log(Integer userId, String action, LocalDateTime time) {
        this.userId = userId;
        this.action = action;
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(userId, log.userId) && Objects.equals(action, log.action) && Objects.equals(time, log.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, action, time);
    }

    @Override
    public String toString() {
        return "Log{" +
                "userId=" + userId +
                ", action='" + action + '\'' +
                ", time=" + time +
                '}';
    }
}
