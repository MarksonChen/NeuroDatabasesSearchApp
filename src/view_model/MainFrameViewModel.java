package view_model;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFrameViewModel implements ObserverViewModel {
    public static final String VIEW_NAME = "Main Frame";
    public static final String FRAME_TITLE = "Neuro-Databases Search Engine";
    public static final String STARRED_MENU_BUTTON_LABEL = "Starred Data";
    public static final String HISTORY_MENU_BUTTON_LABEL = "Query History";
    public static final String ERROR = "Error";
    public static final Color ACCENT_COLOR = new Color(132,177,205);
    public static final Color TITLE_COLOR = new Color(67, 174, 240);
    public static final Color BACKGROUND_COLOR = Color.white;
    public static final String HELP_REDIRECT_URL = "https://github.com/MarksonChen/NeuroDatabasesSearchApp";

    public final MainFrameViewState state = new MainFrameViewState();

    public MainFrameViewState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
