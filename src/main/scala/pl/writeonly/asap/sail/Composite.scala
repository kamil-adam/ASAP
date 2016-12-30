package pl.writeonly.asap.sail



//algorytmy
trait CompositeTraversable[A] {

  def foreach(composite: A, cb: CompositeCallback[A, Any]) {
    cb.traversable(composite).foreach(it => {
      cb.pre(it)
      foreach(it, cb)
      cb.post(it)
    })
  }
  def foldLeft[B](composite: A, cb: CompositeCallback[A, B]) {
    cb.
      apply(composite).foldLeft(cb)((cb, it) => {
        cb.pre(it)
        foldLeft(it, cb)
        cb.post(it)
        cb
      })
  }
}

trait CompositeWrapper {
  implicit def implicitCompositeWrapper[A](t: A) = new AnyRef with CompositeTraversable[A]
}

//lambdy
trait CompositeCallback[A, B] extends ToBoolean {
  def traversable(composite: A): Traversable[A]
  def isLeaf(composite: A)
  def pre(composite: A)
  def post(composite: A)
  def apply(composite: A): Traversable[A] = {
    val child = traversable(composite)
    if (child) {
      child
    } else {
      isLeaf(composite)
      List[A]()
    }
  }
}
abstract class AbstractCompositeCallback[A, B](val result: B) {

}



