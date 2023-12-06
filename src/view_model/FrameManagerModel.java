package view_model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FrameManagerModel implements ObserverViewModel{

    private String activeView;
    public static final String OPEN = "OPEN";

    public String getActiveView() {
        return activeView;
    }

    public void setActiveView(String activeView){
        String oldView = this.activeView;
        this.activeView = activeView;
    };

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, activeView);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
