package com.wxq.apsv.controller;

import com.intellij.uiDesigner.core.GridConstraints;
import com.wxq.apsv.interfaces.*;
import com.wxq.apsv.model.*;
import com.wxq.apsv.view.*;
import com.wxq.apsv.enums.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskStatusController extends JPanel implements TabController {
    private final static Logger logger = LoggerFactory.getLogger(TaskStatusController.class);

    private JButton button1;

    public TaskStatusController() {
        this.InitListeners();
    }

    @Override
    public WinTab getTabType() {
        return WinTab.TASKSTATUS;
    }

    private void InitListeners() {
        // Test
        JPanel taskListPane = new TaskListPane();
        TaskListModel taskListModel = new TaskListModel();
        taskListModel.RegisterObserver((Observer) taskListPane);

        button1 = new JButton();
        button1.setText("Button");
        this.add(button1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 30), new Dimension(100, 30), new Dimension(100, 30), 1, false));


        button1.addActionListener((ActionEvent e) -> {
            logger.debug("Button1 clicked");
            taskListModel.AddTask(new ApsvTask((int)Math.floor(Math.random() * 100)));
        });
    }
}