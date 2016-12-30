package pl.writeonly.asap.apps.jswt.main

import org.eclipse.swt.widgets.Text
import pl.writeonly.xscalawt.YScalaWT._
import pl.writeonly.asap.apps.jswt.main.bean.MainWindow

object MainLoop extends AppLogging {

  val context = AppContext
  context.main(args)
  context.mainLoop.run
}

class MainLoop extends MainWindow {
  string = "MainLoop"
  implicit def textToString(text: Text) = text.getText
  override def run {
    val window = apply(shellDefault)
    borderLayoutScalars()(window)
    super.run
    mainLoop(window)
  }

}

