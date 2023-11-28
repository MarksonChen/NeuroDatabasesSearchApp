package use_case.switch_results_panel;

public class SwitchResultsPanelController {

    private final SwitchResultsPanelInputBoundary switchResultsPanelInteractor;

    public SwitchResultsPanelController(SwitchResultsPanelInputBoundary switchResultsPanelInteractor) {
        this.switchResultsPanelInteractor = switchResultsPanelInteractor;
    }


    public void execute(String databaseOption) {
        switchResultsPanelInteractor.execute(databaseOption);
    }
}
