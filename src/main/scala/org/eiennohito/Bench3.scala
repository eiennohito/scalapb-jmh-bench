package org.eiennohito

import java.util.concurrent.TimeUnit

import com.google.protobuf.CodedOutputStream
import org.eiennohito.test.opt.{Test1x, Test2, Test3}
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

/**
  * @author eiennohito
  * @since 2016/05/17
  */
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
class Bench3 {

  val prototype = {
    val t3 = (0 until 50).map { o => Test3(o.toString) }
    val t2 = (0 until 10).map { _ => Test2(t3) }
    Test1x(t2)
  }

  val arr = new Array[Byte](prototype.serializedSize + 6)

  def deepCopy = prototype.copy(obj = prototype.obj.map(x => x.copy(x.obj.map(y => y.copy()))))

  @Benchmark
  def copyOnly(bh: Blackhole) = {
    bh.consume(deepCopy)
  }

  @Benchmark
  def copyAndSize(bh: Blackhole) = {
    bh.consume(deepCopy.serializedSize)
  }

  @Benchmark
  def copyAndSerialize(bh: Blackhole) = {
    val out = CodedOutputStream.newInstance(arr)
    val copied = deepCopy
    out.writeUInt32NoTag(copied.serializedSize)
    copied.writeTo(out)
    bh.consume(out.spaceLeft())
  }

}


