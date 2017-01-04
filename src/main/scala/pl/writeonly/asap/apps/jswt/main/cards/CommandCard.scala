package pl.writeonly.asap.apps.jswt.main.cards

import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text

import pl.writeonly.jswt.scaladsl.XScalaWT.button
import pl.writeonly.jswt.scaladsl.XScalaWT.composite
import pl.writeonly.jswt.scaladsl.XScalaWT.fillLayout
import pl.writeonly.jswt.scaladsl.XScalaWT.label
import pl.writeonly.jswt.scaladsl.XScalaWT.onSelectionImplicit
import pl.writeonly.jswt.scaladsl.XScalaWT.string2setText
import pl.writeonly.jswt.scaladsl.XScalaWT.tabItem
import pl.writeonly.jswt.scaladsl.XScalaWT.text
import pl.writeonly.jswt.scaladsl.XScalaWT.textPasswd
import pl.writeonly.jswt.scaladsl.XScalaWT.vertical

import pl.writeonly.asap.apps.jswt.main.beans.faces.CommandFace
import pl.writeonly.xscalawt.YScalaWT.textToString

object CommandCard {
  def apply(command: CommandFace) = {

    //config
    var state: Label = null

    composite(
      tabItem("Command"),
      composite(
        fillLayout(vertical),
        composite(
          fillLayout(),
          button("ok", { e: SelectionEvent => command.ok }),
          button("error", { e: SelectionEvent => command.error }),
          button("okFuture", { e: SelectionEvent => command.okFuture }),
          button("errorFuture", { e: SelectionEvent => command.errorFuture }),
          button("okActor", { e: SelectionEvent => command.okActor }),
          button("errorActor", { e: SelectionEvent => command.errorActor })),
        composite(label(state = _))))

  }
}