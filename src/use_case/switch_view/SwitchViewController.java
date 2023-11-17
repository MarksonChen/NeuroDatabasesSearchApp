package use_case.switch_view;

public class SwitchViewController {
    private final SwitchViewInputBoundary switchViewInteractor;

    public SwitchViewController(SwitchViewInputBoundary switchViewInteractor) {
        this.switchViewInteractor = switchViewInteractor;
    }

    /**
     * Switch to the target panel in the MainFrame.
     *
     * @param viewName The view name of the panel in the MainFrame to switch to.
     *                 The view name should be gotten as a static attribute from the
     *                 View Model of the panel to switch to.
     */
    public void execute(String viewName) {
        switchViewInteractor.execute(viewName);
    }
}
