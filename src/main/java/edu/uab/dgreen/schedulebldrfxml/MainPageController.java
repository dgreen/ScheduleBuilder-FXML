/*
 * File: MainPageController.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  schedulebldrfxml - EE333 Fall 2019
 * Vers: 1.0.0 10/22/2019 dgg - initial coding
 */
package edu.uab.dgreen.schedulebldrfxml;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class MainPageController extends BorderPane {

    private Dispatch dispatch = new Dispatch();
    
    private String path;
    private String course;
    private String semester;
    
    // map to GUI controls in fxml file
    @FXML private TextField pathField;
    @FXML private TextField courseField;
    @FXML private TextField semesterField;

    
    @FXML private Button createEditButton;
    @FXML private Button editTemplateButton;
    @FXML private Button mergeButton;
    @FXML private Button touchUpButton;
    @FXML private Button viewButton;
    @FXML private Button exportHTMLButton;


    public MainPageController() {
    }

    @FXML
    public void initialize() {
        enableReadyButtons();
        App.getStage().focusedProperty().addListener( (ObservableValue<? extends Boolean> obj,Boolean oldVal,Boolean newVal) -> {
            // This listener reviews button status when
            // window gets input focus.
        if (newVal) { // The window has gained focus.
            enableReadyButtons();
        }
    });

    }

    /**
     * Update which buttons are enabled based on the state of the system
     */
    public final void enableReadyButtons() {
        copyConfigInfo();
        createEditButton.setDisable(  ! dispatch.readyForCreateEdit());
        editTemplateButton.setDisable(! dispatch.readyForEditTemplate());
        mergeButton.setDisable(       ! dispatch.readyForMerge());
        touchUpButton.setDisable(     ! dispatch.readyForTouchUp());
        viewButton.setDisable(        ! dispatch.readyForView());
        exportHTMLButton.setDisable(  ! dispatch.readyForExport());
    }
    
    /**
     * GUI side of action associated with Create/Edit button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void createEditClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.createEditSchedule();
        enableReadyButtons();
    }
    
    
    /**
     * GUI side of action associated with Edit Template button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void editTemplateClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.editTemplate();
        enableReadyButtons();
    }

    /**
     * GUI side of action associated with Merge button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void mergeClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.mergeSchedule();
        enableReadyButtons();
    }
    
    /**
     * GUI side of action associated with Touch Up button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void touchUpClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.touchUpResult();        
        enableReadyButtons();
    }
    
    /**
     * GUI side of action associated with View button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void viewClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.viewResult();        
        enableReadyButtons();
    }
    
    /**
     * GUI side of action associated with Export HTML button click
     * Set up config info and call code in dispatch.
     * TBD: update GUI State
     */
    @FXML
    public void exportHTMLClicked() {
        copyConfigInfo();                           // ensure it is current
        dispatch.exportResult();
        enableReadyButtons();
    }

    // Copy the config out of text fields into private String variables
    // and convey this info to the dispatch object
    private void copyConfigInfo() {
        path     = pathField.getText();
        course   = courseField.getText();
        semester = semesterField.getText();
        dispatch.setFullPath(path, course, semester);
    }
    
}
