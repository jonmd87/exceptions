package seminar3.exceptions.dataExceptions;

public class FewArgumentsException extends MyDataExceptions{
    private final int supposed;
    private final int received;

    public FewArgumentsException(String message, int supposed, int received) {
        super(message);
        this.supposed = supposed;
        this.received = received;
    }

    public int getSupposed() {
        return supposed;
    }

    public int getReceived() {
        return received;
    }
}
