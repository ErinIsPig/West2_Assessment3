package ImprovedQuestion.projo;

import java.util.Date;

public class weather {
    private int id;
    private Date fxDate;
    private int tempMax;
    private int tempMin;
    private String textDay;

    public weather() {
    }

    public weather(int id, Date fxDate, int tempMax, int tempMin, String textDay) {
        this.id = id;
        this.fxDate = fxDate;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFxDate() {
        return fxDate;
    }

    public void setFxDate(Date fxDate) {
        this.fxDate = fxDate;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    @Override
    public String toString() {
        return "weather{" +
                "id=" + id +
                ", fxDate=" + fxDate +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", textDay='" + textDay + '\'' +
                '}';
    }
}
