package view;

import view_model.MainFrameViewModel;
import view_model.MainFrameViewState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainFrame extends JFrame {
    private final MainFrameViewModel mainFrameViewModel;

    public MainFrame(MainFrameViewModel mainFrameViewModel) {
        super(MainFrameViewModel.FRAME_TITLE);
        this.mainFrameViewModel = mainFrameViewModel;
//        mainFrameViewModel.addPropertyChangeListener(this);

        // We can move views-related things here
        // But by SRP, we choose to keep everything related to "hooking everything together"
        // in the Main method.
    }

    public void init() {
        setPreferredSize(new Dimension(1200, 800));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

