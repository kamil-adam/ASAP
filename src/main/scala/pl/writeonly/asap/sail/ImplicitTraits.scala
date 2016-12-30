package pl.writeonly.asap.sail

//import scala.util.logging.Logged

trait ToBoolean {
  implicit def toBoolean(it: Int) = (it != 0)
  implicit def toBoolean(it: Long) = (it != 0)
  //implicit def toBoolean(it: Any) = (it != 0)

  implicit def toBoolean(it: String) = (it != null && it != "")

  //implicit def toBoolean(it: AnyRef) = (it != 0)
  implicit def toBoolean(it: Any) = (it != null)
}

trait PerlBool {
  implicit def implicitPerlBool[T](t: T) = new {
    def or[A >: T](a: () => A) = if (t != null) t else a.apply
    def or[A >: T](a: A) = if (t != null) t else a
    def orThrow(a: Throwable) = if (t != null) t else throw a
    def and(a: () => Any) = if (t != null) a.apply else null
    def and[A >: T](a: A) = if (t != null) a else null
  }
}

trait Genie {
  implicit def implicitGenie[T](alt: T) = new {
    def ??[A >: T](pred: () => A) = if (alt != null) alt else pred.apply
    def ??[A >: T](pred: A) = if (alt != null) alt else pred
  }
}

trait At {
  implicit def implicitAt[T](alt: Array[T]) = new {
          def at(i : Int) = (if (i < alt.length ) alt(i) else null).asInstanceOf[T]
//    def at(i: Int) = (if (i < alt.length) {
//      println ("alt(i) => " + alt(i)) 
//      alt(i)
//    } else {
//      println ("alt(i) == null") 
//      null
//    }).asInstanceOf[T]
  }
}

//object OrElse {
//  implicit def implicitOrElse[T](alt: T) = new {
//    def orElse[A >: T](pred: () => A) = if (pred == null) alt else pred.apply
//    def orElse[A >: T](pred: A) = if (pred == null) alt else pred
//    def orThrow(pred: Throwable) = if (pred == null) alt else throw pred
//  }
//}

trait OrElse {
  implicit def implicitOrElse[T](alt: T) = new {
    def orElse[A >: T](pred: () => A) = if (pred == null) alt else pred.apply
    def orElse[A >: T](pred: A) = if (pred == null) alt else pred
    def orThrow(pred: Throwable) = if (pred == null) alt else throw pred
  }
}

