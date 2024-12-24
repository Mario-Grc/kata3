package software.ulpgc.kata3;

import software.ulpgc.kata3.control.Command;
import software.ulpgc.kata3.view.JFreeBarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay barchartDisplay;

    public MainFrame() {
        this.commands = new HashMap<>();
        this.setTitle("Kata3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(barchartDisplay = statisticPanel());
    }

    public JFreeBarchartDisplay getBarchartDisplay() {
        return barchartDisplay;
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }

    private Component toolbar() {
        Panel panel = new Panel();
        panel.add(toggle());
        return panel;
    }

    private JButton toggle() {
        JButton button = new JButton("Toggle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    commands.get("toggle").execute();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return button;
    }

    public JFrame put(String name, Command command) {
        commands.put(name, command);
        return this;
    }
}