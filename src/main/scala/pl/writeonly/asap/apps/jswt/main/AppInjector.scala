package pl.writeonly.asap.apps.jswt.main

import pl.writeonly.asap.apps.jswt.main.bean.FacadeBean
import com.google.inject.Guice
import com.google.inject.AbstractModule
import com.google.inject.Scopes;


object AppInjector extends AppLogging {
  val injector = Guice.createInjector(new AppModule())
  val facade = injector.getInstance(classOf[FacadeBean])
}

class AppModule extends AbstractModule {
  /**
   * Konfiguracja modułu.
   */
  def configure = {
//    bind(classOf[RecordBean]).to(classOf[RecordBean]).in(Scopes.SINGLETON);
    //bind(classOf[Dao]).to(classOf[DaoJdo]).in(Scopes.SINGLETON);
  }
}