package pl.writeonly.asap.apps.jswt.main

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import pl.writeonly.asap.apps.jswt.main.bean.FacadeBean
import org.springframework.jms.core.JmsTemplate
import javax.jms.ConnectionFactory
import org.springframework.jms.connection.SingleConnectionFactory
import org.apache.activemq.ActiveMQConnectionFactory
import pl.writeonly.asap.apps.jswt.main.bean.Facade
import pl.writeonly.asap.apps.jswt.main.bean.AppJmsListener

object AppContext extends AppLogging {
  //  val context: ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")
  val context: ApplicationContext = new AnnotationConfigApplicationContext(classOf[AppConfig], classOf[JmsConfig])

  def appWindow = context.getBean("AppWindow").asInstanceOf[AppWindow]
  def mainLoop = context.getBean("MainLoop").asInstanceOf[MainLoop]
}

@Configuration
class AppConfig {
  @Bean
  def AppWindow: AppWindow = new AppWindow

  @Bean
  def MainLoop: MainLoop = new MainLoop

  @Bean
  def FacadeBean: FacadeBean = new FacadeBean

  @Bean
  def Facade: Facade = new Facade

  @Bean
  def AppJmsListener: AppJmsListener = new AppJmsListener
}

@Configuration
class JmsConfig {

  @Bean
  def consumerJmsTemplate = {
    val template = new JmsTemplate()
    template.setConnectionFactory(connectionFactory)
    template
  }

  @Bean
  def connectionFactory = {
    val factory = new SingleConnectionFactory
    factory.setTargetConnectionFactory(targetConnectionFactory)
    factory
  }

  @Bean
  def targetConnectionFactory = new ActiveMQConnectionFactory("vm://localhost")

}

