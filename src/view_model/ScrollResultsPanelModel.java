package view_model;

import data_access.Database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScrollResultsPanelModel implements ObserverViewModel{
    public static final String REFRESH_ALL = "Refresh All";
    private final Database database;
    private final ScrollResultsPanelState state = new ScrollResultsPanelState();

    public static final String REFRESH_STAR_STATES = "Refresh Star States";

    public ScrollResultsPanelModel(Database database) {
        this.database = database;
    }
    public ScrollResultsPanelState getState() {
        return state;
    }

    public Database getDatabase() {
        return database;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
