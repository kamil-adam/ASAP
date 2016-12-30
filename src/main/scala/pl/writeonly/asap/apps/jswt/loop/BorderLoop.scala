package pl.writeonly.asap.apps.jswt.loop

import pl.writeonly.jswt.scaladsl.XScalaWT.Assignments._
import pl.writeonly.jswt.scaladsl.XScalaWT.button
import pl.writeonly.jswt.scaladsl.XScalaWT.runEventLoop
import pl.writeonly.jswt.scaladsl.XScalaWT.shell
import pl.writeonly.jswt.scaladsl.XScalaWT.string2setText
import pl.writeonly.jswt.scaladsl.layout.BorderData
import pl.writeonly.jswt.scaladsl.YScalaWT.borderLayoutScalars
import pl.writeonly.jswt.scaladsl.YScalaWT.textArea

object BorderLoop extends App {
  new BorderLoop().run
}

class BorderLoop  {
  def run {
    val window = shell(
      "BorderLoop",
      borderLayoutScalars(),
      button("west", layoutData = BorderData.WEST),
      button("east", layoutData = BorderData.EAST),
      button("north", layoutData = BorderData.NORTH),
      button("south", layoutData = BorderData.SOUTH),
      textArea("center"))
    runEventLoop(window)
  }
}

//@Repository, @Service, @Controller
//card
//composite
//controler
//component
//dao
//entity