package view_model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FrameManagerModel implements ObserverViewModel{


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(String propertyName) {
        // TODO: OpenFrame use case
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
