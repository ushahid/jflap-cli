/*
 *  JFLAP - Formal Languages and Automata Package
 * 
 * 
 *  Susan H. Rodger
 *  Computer Science Department
 *  Duke University
 *  August 27, 2009

 *  Copyright (c) 2002-2009
 *  All rights reserved.

 *  JFLAP is open source software. Please see the LICENSE for terms.
 *
 */





package edu.duke.cs.jflap.gui.action;

import edu.duke.cs.jflap.file.Codec;
import edu.duke.cs.jflap.file.DataException;
import edu.duke.cs.jflap.file.ParseException;
import edu.duke.cs.jflap.gui.environment.Environment;
import edu.duke.cs.jflap.gui.environment.EnvironmentFrame;
import edu.duke.cs.jflap.gui.environment.FrameFactory;
import edu.duke.cs.jflap.gui.environment.Universe;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import edu.duke.cs.jflap.automata.Automaton;
import edu.duke.cs.jflap.automata.turing.TuringMachine;

/**
* The <CODE>TestTuringAction</CODE> is an action to load a structure from a file,
* and create a new environment with that object.
* 
* @author Stephen Reading
*/

public class FATestAction extends  TestAction{

    /**
     * Instantiates a new <CODE>Turing Test Action</CODE>.
     */
    public FATestAction() {
        //super("Test Turing Machines", null);
        super("Test Finite Automata", KeyEvent.VK_A);       

    }
    
    protected void displayMultipleRunPane(Environment env){
    		MultipleSimulateAction act = new MultipleSimulateAction((Automaton)myObjects.get(0),env);
    		act.performAction(env);
   	
    }

}
