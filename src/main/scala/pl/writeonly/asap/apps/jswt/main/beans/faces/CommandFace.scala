package pl.writeonly.asap.apps.jswt.main.beans.faces

import pl.writeonly.asap.apps.jswt.main.beans.Facade
import javax.inject.Inject
import pl.writeonly.asap.apps.jswt.main.cards.CommandCard
import pl.writeonly.asap.apps.jswt.main.beans.Face


class CommandFace extends Face {
//  @Inject var commandService: CommandBean = _
  @Inject var facade: Facade = _
  
  def apply = CommandCard(this) 
  
  def ok = {}

  def error = {}

  def okFuture = {}

  def errorFuture = {}  
  def okActor = {}

  def errorActor = {}  





}