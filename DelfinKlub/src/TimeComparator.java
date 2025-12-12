import java.util.Comparator;

public class TimeComparator implements Comparator<Competition> {

    public int compare(Competition time1, Competition time2) {
        return time1.getRaceTime().compareTo(time2.getRaceTime());
    }
}

