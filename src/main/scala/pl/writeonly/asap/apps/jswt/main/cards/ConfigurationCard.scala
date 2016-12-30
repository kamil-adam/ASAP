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

import pl.writeonly.asap.apps.jswt.main.beans.faces.ConfigurationFace
import pl.writeonly.xscalawt.YScalaWT.textToString

object ConfigurationCard {
  def apply(configuration: ConfigurationFace) = {

    //config
    var username: Text = null
    var password: Text = null
    var confirm: Text = null
    var state: Label = null

    composite(
      tabItem("Configuration"),
      composite(
        fillLayout(vertical),
        composite(
          fillLayout(),
          label("username"),
          text(username = _),
          label("password"),
          textPasswd(password = _),
          label("confirm"),
          textPasswd(confirm = _)),
        composite(
          fillLayout(),
          button("register", { e: SelectionEvent => configuration.register(username, password, confirm) }),
          button("login", { e: SelectionEvent => configuration.login(username, password) }),
          button("logout", { e: SelectionEvent => configuration.logout }),
          button("update", { e: SelectionEvent => configuration.merge })),
        composite(label(state = _))))

  }
}