package use_case.open_website;

public class OpenWebsiteInteractor implements OpenWebsiteInputBoundary{

    private final OpenWebsiteOutputBoundary openWebsitePresenter;

    public OpenWebsiteInteractor(OpenWebsiteOutputBoundary openWebsitePresenter) {
        this.openWebsitePresenter = openWebsitePresenter;
    }

    @Override
    public void execute(String url) {

    }
}
