package use_case.open_frame;

public class OpenFrameController {
    private final OpenFrameInputBoundary openFrmeInteractor;

    public OpenFrameController(OpenFrameInputBoundary openFrmeInteractor) {
        this.openFrmeInteractor = openFrmeInteractor;
    }

    public void execute(String viewName) {
        openFrmeInteractor.execute(viewName);
    }
}
