package use_case.toggle_display_option;

public class ToggleDisplayOptionOutputData {
    private final int dataBaseIndex;
    private final String entryKey;

    public ToggleDisplayOptionOutputData(int dataBaseIndex, String entryKey) {
        this.dataBaseIndex = dataBaseIndex;
        this.entryKey = entryKey;
    }
}
