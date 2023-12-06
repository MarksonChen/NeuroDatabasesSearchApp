package use_case.toggle_display_option;

public class ToggleDisplayOptionController {
    private final ToggleDisplayOptionInputBoundary toggleDisplayOptionInteractor;

    public ToggleDisplayOptionController(ToggleDisplayOptionInputBoundary toggleDisplayOptionInteractor) {
        this.toggleDisplayOptionInteractor = toggleDisplayOptionInteractor;
    }

    public void execute(int databaseIndex, String entryKey) {
        toggleDisplayOptionInteractor.execute(new ToggleDisplayOptionInputData(databaseIndex, entryKey));

    }
}
