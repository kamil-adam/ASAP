package pl.writeonly.asap.apps.jswt.main.beans

import org.eclipse.swt.widgets.Composite


import javax.annotation.Resource
//import pl.writeonly.babel.remote.JmsDestination
import com.typesafe.scalalogging.StrictLogging

trait Face extends StrictLogging {
//  @Resource var jmsDestination: JmsDestination = _
  def apply(): Composite => Composite
  def runtime(e: RuntimeException) {
    logger debug "runtime"
    logger error (e.getMessage, e);
//    logger debug "runtime jmsDestination " + jmsDestination
//    jmsDestination ! e.getMessage
  }
}