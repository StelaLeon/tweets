package exercise

/**
 * Created by sleon on 6/19/16.
 */

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}
object Zero extends Nat{
  override def isZero: Boolean = true

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = throw new Error("subtracting from zero will generate a non-natural number")

  override def predecessor: Nat = throw new Error("Natural number")
}


class Succ(n: Nat) extends Nat{
  override def isZero: Boolean = false

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(that + n)

  override def -(that: Nat): Nat = n - that.predecessor

  override def predecessor: Nat = n
}


