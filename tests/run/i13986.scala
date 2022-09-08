package example

sealed trait Xa[T]
sealed trait Mu[T] extends Xa[T]
object Xa {
  implicit def convertMu[X[x] <: Xa[x], A, B](implicit t: X[A]): X[B] = t.asInstanceOf[X[B]]
}
object Mu {
  implicit def mu: Mu[Int] = new Mu[Int] {}
}

object Test extends App {
  def constrain(a: Mu[Long]): Unit = ()
  constrain(Xa.convertMu)
}