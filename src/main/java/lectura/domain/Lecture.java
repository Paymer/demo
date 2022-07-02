package lectura.domain;

public class Lecture {

    private String userId;

    private int lecture;

    private String period;

    private boolean isSuspicious;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLecture() {
        return lecture;
    }

    public void setLecture(int lecture) {
        this.lecture = lecture;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public boolean isSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }
}
