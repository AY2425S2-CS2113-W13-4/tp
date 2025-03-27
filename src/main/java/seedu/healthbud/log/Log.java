package seedu.healthbud.log;

public class Log {

    private String logType;
    private String date;

    public Log(String date, String logType) {
        this.date = date;
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }

    public String getDate() {
        return date;
    }

}
