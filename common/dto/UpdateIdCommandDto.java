package lab6.common.dto;

public class UpdateIdCommandDto extends AbstractDto{
    private int workerId;

    private WorkerDto workerDto;

    public WorkerDto getWorkerDto() {
        return workerDto;
    }

    public void setWorkerDto(WorkerDto workerDto) {
        this.workerDto = workerDto;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
