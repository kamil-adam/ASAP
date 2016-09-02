/*******************************************************************************
 * Copyright (c) 2009 David Orme and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Orme - initial API and implementation
 *******************************************************************************/
package pl.writeonly.xscalawt
package examples.binding

import org.eclipse.swt.widgets.Display
import org.eclipse.jface.databinding.swt.SWTObservables
import org.eclipse.core.databinding.observable.Realm
import XScalaWT._
import XScalaWTBinding._
import pl.writeonly.xscalawt.XScalaWTBinding
import pl.writeonly.xscalawt.XScalaWT

object DataBindingMain {
  def main(args : Array[String]) = {
    val loginData = new LoginViewModel()
    val display = new Display()
    runWithDefaultRealm {
      val loginView = new LoginView(loginData)
      runEventLoop(loginView.createDialog())
    }
    println("Username:  " + loginData.username)
    println("Password:  " + loginData.password)
    println("Logged in: " + loginData.loggedIn)
  }
}
