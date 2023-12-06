package view_model;

public class MainFrameViewState {
    private String errorMessage;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private String ERROR_MESSAGE = "Error";
    public void setERROR_MESSAGE(String errorMessage) {
        this.ERROR_MESSAGE = errorMessage;
    }
    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }
}
