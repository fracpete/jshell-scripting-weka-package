/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * JShellScripting.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package weka.gui;

import com.github.fracpete.jshell.JShellPanel;
import weka.gui.GUIChooser.GUIChooserMenuPlugin;

import javax.swing.JMenuBar;

/**
 * JShell scripting dialog.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class JShellScripting
  extends JShellPanel
  implements GUIChooserMenuPlugin {

  private static final long serialVersionUID = 7660522785301462779L;

  /**
   * Get the name to display in title bar of the enclosing JFrame for the
   * plugin
   *
   * @return the name to display in the title bar
   */
  @Override
  public String getApplicationName() {
    return "JShell scripting";
  }

  /**
   * Get the menu that the plugin is to be listed in
   *
   * @return the menu that the plugin is to be listed in
   */
  @Override
  public Menu getMenuToDisplayIn() {
    return Menu.TOOLS;
  }

  /**
   * Get the text entry to appear in the menu
   *
   * @return the text entry to appear in the menu
   */
  @Override
  public String getMenuEntryText() {
    return "JShell scripting";
  }

  /**
   * Return the menu bar for this plugin
   *
   * @return the menu bar for this plugin or null if it does not use a menu
   *         bar
   */
  @Override
  public JMenuBar getMenuBar() {
    return null;
  }
}
