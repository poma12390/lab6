package lab6.common.dto;

public class AddCommandDto extends AbstractDto {
    private WorkerDto bum;

    public WorkerDto getBum() {
        return bum;
    }

    public void setBum(WorkerDto bum) {
        this.bum = bum;
    }
}
