package pl.writeonly.asap.apps.jswt.main

import org.eclipse.jface.action.Action
import org.eclipse.jface.action.IAction
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.action.StatusLineManager
import org.eclipse.jface.action.ToolBarManager
import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Display
import pl.writeonly.jswt.scaladsl.XScalaWT._
import pl.writeonly.jswt.scaladsl.XScalaWT.Assignments._
import com.typesafe.scalalogging.StrictLogging
import javax.annotation.PostConstruct
import javax.jms.TextMessage
import org.eclipse.swt.widgets.Shell

//import pl.writeonly.jswt.scaladsl.XScalaWT._
//import pl.writeonly.jswt.scaladsl.XScalaWT.Assignments._
import com.typesafe.scalalogging.StrictLogging

import com.typesafe.scalalogging.StrictLogging
import pl.writeonly.asap.apps.jswt.main.bean.MainWindow

object AppWindow extends AppLogging {
  val context = AppContext
  context.main(args)
  //  val loop = context.mainLoop
  //  val app = new AppWindow(loop)
  val app = context.appWindow

  app.setBlockOnOpen(true);
  app.open();
  Display.getCurrent().dispose();
}
//window: MainWindow
@org.springframework.stereotype.Controller
class AppWindow() extends ApplicationWindow(null) with MainWindow {
  val slm = new StatusLineManager()
  val status_action = new StatusAction(slm);
  //string = "AppWindow"

  addStatusLine();
  addMenuBar();
  addToolBar(SWT.FLAT | SWT.WRAP);

  @PostConstruct
  def init() {
    //   consumer.listener.textResiver = (text:TextMessage) => slm.setMessage(text.getText())
//    consumer.listener.textResiver = (text: TextMessage) => {
//      logger debug " init textResiver" + text.getText
//      slm.setMessage(text.getText())
//    }
  }

  override def createStatusLineManager(): StatusLineManager = slm;

  override def createToolBarManager(style: Int): ToolBarManager = {
    val tool_bar_manager = new ToolBarManager(style);
    tool_bar_manager.add(status_action);
    tool_bar_manager;
  }

  override def createMenuManager(): MenuManager = {
    val main_menu = new MenuManager(null);
    val action_menu = new MenuManager("Menu");
    action_menu.add(status_action);
    main_menu.add(action_menu);
    main_menu;
  }

  override def createContents(parent: Composite) = apply(parent.asInstanceOf[Shell])

}

class StatusAction(val slm: StatusLineManager)
    extends Action("&Trigger@Ctrl+T", IAction.AS_PUSH_BUTTON)
    with StrictLogging {
  var triggercount: Int = 0

  //setImageDescriptor (ImageDescriptor.createFromFile (this.getClass (), "_.gif"));
  setToolTipText("Trigger the Action");
  slm.setMessage("message");

  override def run() = {
    triggercount += 1
    val message = "The status action has fired. Count: " + triggercount
    slm.setMessage(message);
    logger debug message
  }
}


