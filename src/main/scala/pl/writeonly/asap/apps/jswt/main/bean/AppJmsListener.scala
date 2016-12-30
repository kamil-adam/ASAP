package pl.writeonly.asap.apps.jswt.main.bean

import javax.jms.BytesMessage
import javax.jms.MapMessage
import javax.jms.Message
import javax.jms.MessageListener
import javax.jms.ObjectMessage
import javax.jms.StreamMessage
import javax.jms.TextMessage
import com.typesafe.scalalogging.StrictLogging
import pl.writeonly.asap.sail.ToBoolean
import org.springframework.jms.annotation.JmsListener

class AppJmsListener extends MessageListener with StrictLogging with ToBoolean {

//  @Inject var relationFace: RelationFace = _
  var textResiver: TextMessage => Unit = _
  
  logger debug "init"

  
  @JmsListener(destination = "mailbox", containerFactory = "myFactory")
  override def onMessage(message: Message) {
    message match {
      case bytes: BytesMessage   => logger info "bytes => " + bytes
      case map: MapMessage       => logger info "map => " + map
      case stream: StreamMessage => logger info "stream => " + stream
      case text: TextMessage     => if (textResiver) textResiver(text) else logger error "onMessage text => " + text
      case serializable: ObjectMessage => {
        logger debug "onMessage serializable => " + serializable
//        serializable.getObject() match {
          //case ralations: List[Relation] => relationFace.viewer.add(ralations); logger debug "ralations => " + ralations
//          case relations: List[Relation] => relationFace.addAll(relations)
//        }
      }
    }

    message.acknowledge ();
  }

}