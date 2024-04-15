package simstation;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimulationPanel extends AppPanel {

    public SimulationPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(this);
        controlPanel.add(startButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton suspendButton = new JButton("Suspend");
        suspendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        suspendButton.addActionListener(this);
        controlPanel.add(suspendButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton resumeButton = new JButton("Resume");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeButton.addActionListener(this);
        controlPanel.add(resumeButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton stopButton = new JButton("Stop");
        stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stopButton.addActionListener(this);
        controlPanel.add(stopButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton statsButton = new JButton("Stats");
        statsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        statsButton.addActionListener(this);
        controlPanel.add(statsButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Simulation simulation = (Simulation) model;
        if ((command.equals("Save") || command.equals("SaveAs")) && simulation.running() && !simulation.suspended()) {
            Utilities.error("Simulation must be suspended before saving");
            return;
        }
        super.actionPerformed(e);
    }

}
