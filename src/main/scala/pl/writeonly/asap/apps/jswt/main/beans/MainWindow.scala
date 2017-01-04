package pl.writeonly.asap.apps.jswt.main.beans

import org.eclipse.swt.widgets.Shell
import pl.writeonly.jswt.scaladsl.YScalaWT._
import pl.writeonly.jswt.scaladsl.XScalaWT._
import pl.writeonly.jswt.scaladsl.XScalaWT.Assignments._
import com.typesafe.scalalogging.StrictLogging
import javax.inject.Inject
import pl.writeonly.asap.apps.jswt.main.beans.faces.CommandFace


//import pl.writeonly.jswt.scaladsl.XScalaWT._
//import pl.writeonly.jswt.scaladsl.XScalaWT.Assignments._

trait MainWindow extends Runnable with StrictLogging {

  @Inject var mainFace: Facade = _
  @Inject var commandFace: CommandFace = _

  def run() = {

  }

  var string = "MainWindow"

  def apply(parent: Shell) = {
    contentDefault(
            fileDialogOpen(mainFace.open = _),
            fileDialogSave(mainFace.save = _),
      string,
      tabFolder(
        commandFace()
      ))(parent)
  }

}

  /* potrzebne będzie menu, toolbar, stack/card, pasek stanu,
   * karty logowanie/rejstracja, edycja słów, edycja, edycja relacji/tworzenie 
   * 
   * 
   */