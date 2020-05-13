package eurica.mei.cheers;

import com.google.firebase.Timestamp;

public class Status {
    private String user;
    private String status;
    private String time;

    public Status(String user, String status, String time) {
        this.user = user;
        this.status = status;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
