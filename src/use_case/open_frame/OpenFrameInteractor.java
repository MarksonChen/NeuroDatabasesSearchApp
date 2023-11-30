package use_case.open_frame;

public class OpenFrameInteractor implements OpenFrameInputBoundary {

    private final OpenFrameOutputBoundary openFramePresenter;

    public OpenFrameInteractor(OpenFrameOutputBoundary openFramePresenter) {
        this.openFramePresenter = openFramePresenter;
    }

    @Override
    public void execute(String viewName) {
        openFramePresenter.openFrame(viewName);
    }
}
