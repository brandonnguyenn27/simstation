package simstation;

import mvc.*;

import javax.swing.*;
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
//<<<<<<< HEAD
//        if ("Start".equals(command)) {
//            Command startCommand = factory.makeEditCommand(model, "Start", this);
//            startCommand.execute();
//        } else if ("Suspend".equals(command)) {
//            Command suspendCommand = factory.makeEditCommand(model, "Suspend", this);
//            suspendCommand.execute();
//        } else if ("Resume".equals(command)) {
//            Command resumeCommand =git factory.makeEditCommand(model, "Resume", this);
//            resumeCommand.execute();
//        } else if ("Stop".equals(command)) {
//            Command stopCommand = factory.makeEditCommand(model, "Stop", this);
//            stopCommand.execute();
//        } else if ("Stats".equals(command)) {
//            Command statsCommand = factory.makeEditCommand(model, "Stats", this);
//            statsCommand.execute();
//=======
        Simulation simulation = (Simulation) model;
        if ((command.equals("Save") || command.equals("SaveAs")) && simulation.running() && !simulation.suspended()) {
            Utilities.error("Simulation must be suspended before saving");
            return;
        }
        super.actionPerformed(e);
    }

}
