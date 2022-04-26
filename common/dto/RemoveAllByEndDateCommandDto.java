package lab6.common.dto;

import java.util.Date;

public class RemoveAllByEndDateCommandDto extends AbstractDto{
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
     private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
