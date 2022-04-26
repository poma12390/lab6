package lab6.common.dto;

import java.util.Date;
import java.util.List;

public class PrintFieldDescendingEndDateCommandDto extends AbstractDto{
    private List<Date> dates;

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
