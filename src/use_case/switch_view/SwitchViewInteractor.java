package use_case.switch_view;

public class SwitchViewInteractor implements SwitchViewInputBoundary{
    private final SwitchViewOutputBoundary switchViewPresenter;

    public SwitchViewInteractor(SwitchViewOutputBoundary switchViewPresenter) {
        this.switchViewPresenter = switchViewPresenter;
    }


    /**
     * Switch to the target panel in the MainFrame.
     *
     * @param viewName The view name of the panel in the MainFrame to switch to.
     *                 The view name should be gotten as a static attribute from the
     *                 View Model of the panel to switch to.
     */
    @Override
    public void execute(String viewName) {
        switchViewPresenter.switchToView(viewName);
    }
}
