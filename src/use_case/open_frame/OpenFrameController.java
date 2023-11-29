package use_case.open_frame;

public class OpenFrameController {
    private final OpenFrameInputBoundary openFrameInteractor;

    public OpenFrameController(OpenFrameInputBoundary openFrameInteractor) {
        this.openFrameInteractor = openFrameInteractor;
    }

    public void execute(String viewName) {
        openFrameInteractor.execute(viewName);
    }
}
