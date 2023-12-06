package use_case.toggle_display_option;

public class ToggleDisplayOptionInputData {
    private final int dataBaseIndex;
    private final String entryKey;


    public ToggleDisplayOptionInputData(int dataindex, String entryKey) {
        this.dataBaseIndex = dataindex;
        this.entryKey = entryKey;
    }

    public int getDataBaseIndex() {
        return dataBaseIndex;
    }
    public String getEntryKey(){
        return entryKey;
    }
}
