package seedu.healthbud;

import seedu.healthbud.log.Log;
import java.util.ArrayList;
import java.util.List;

public class LogList {

    private List<Log> logs;

    public LogList(){
        logs = new ArrayList<>();
    }


    public Log getLog(int index){
        return logs.get(index);
    }


    public int getSize() {
        return logs.size();
    }

    public boolean isEmpty() {
        return logs.isEmpty();
    }

    public void addlog(Log log) {
        logs.add(log);
    }

}

