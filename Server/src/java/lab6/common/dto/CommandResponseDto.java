package lab6.common.dto;

import java.io.Serializable;

public class CommandResponseDto<T extends Serializable> implements Serializable {
    private String response;
    private WorkerDto worker;
    private T commandArgs;

    public T getCommandArgs() {
        return commandArgs;
    }

    public void setCommandArgs(T commandArgs) {
        this.commandArgs = commandArgs;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public WorkerDto getWorker() {
        return worker;
    }

    public void setWorker(WorkerDto worker) {
        this.worker = worker;
    }

    public CommandResponseDto(T commandArgs) {
        this.commandArgs = commandArgs;
    }
}
