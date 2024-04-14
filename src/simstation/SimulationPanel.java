package simstation;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimulationPanel extends AppPanel {

    public SimulationPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);
        controlPanel.add(startButton);

        JButton suspendButton = new JButton("Suspend");
        suspendButton.addActionListener(this);
        controlPanel.add(suspendButton);

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(this);
        controlPanel.add(resumeButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        controlPanel.add(stopButton);

        JButton statsButton = new JButton("Stats");
        statsButton.addActionListener(this);
        controlPanel.add(statsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Simulation simulation = (Simulation) model;
        if ((command == "Save" || command == "SaveAs") && simulation.running() && !simulation.suspended()) {
            Utilities.error("Simulation must be suspended before saving");
            return;
        }
        super.actionPerformed(e);
    }

}
