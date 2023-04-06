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

import edu.duke.cs.jflap.gui.editor.EditorPane;
import edu.duke.cs.jflap.gui.environment.AutomatonEnvironment;
import edu.duke.cs.jflap.gui.environment.Environment;
import edu.duke.cs.jflap.gui.viewer.AutomatonPane;
import edu.duke.cs.jflap.gui.viewer.SelectionDrawer;
import edu.duke.cs.jflap.gui.environment.Universe;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.filechooser.FileFilter;

/**
 * The <CODE>SaveGraphPNGAction</CODE> is an action to save the graph in window
 * to a PNG image file always using a dialog box.
 * 
 * @author Jonathan Su
 */

public class SaveGraphPNGAction extends RestrictedAction{
	/** The environment that this save action gets it's object from. */
	protected Environment environment;
	protected JMenu myMenu;
	
	/**
	 * Instantiates a new <CODE>SaveGraphPNGAction</CODE>.
	 * 
	 * @param environment
	 *            the environment that holds the action
	 */
	public SaveGraphPNGAction(Environment environment, JMenu menu) {
		super("Save Graph as PNG", null);
		this.environment = environment;
		this.myMenu = menu;
	}

	/**
	 * Displays JFileChooser for location to save the graph canvas as png image.
	 * 
	 * @param arg0
	 *            the action event
	 */
	public void actionPerformed(ActionEvent arg0) {

           Component apane = environment.tabbed.getSelectedComponent();
           JComponent c=(JComponent)environment.getActive();
           SaveGraphUtility.saveGraph(apane, c,"PNG files", "png"); 
    }  
}
