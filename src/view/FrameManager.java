package view;

import view_model.FrameManagerModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class FrameManager implements PropertyChangeListener {

    private final FrameManagerModel frameManagerModel;
    private final Map<String, JFrame> frame;

    public FrameManager(FrameManagerModel frameManagerModel, Map<String, JFrame> frames, Map<String, JFrame> frame) {
        this.frameManagerModel = frameManagerModel;
        this.frame = frames;
        frameManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(FrameManagerModel.Open)) {
            String frameName = (String) evt.getNewValue();
            JFrame jFrame = frame.get(frameName);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
            jFrame.toFront();
        }
    }
}