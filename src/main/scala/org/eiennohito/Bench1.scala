package org.eiennohito

import org.eiennohito.test.Test1
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

/**
  * @author eiennohito
  * @since 2016/05/17
  */
class Bench1 {

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  def copyOnly(st: ProtoState, bh: Blackhole) = {
    bh.consume(st.copyState)
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  def copyAndSize(st: ProtoState, bh: Blackhole) = {
    bh.consume(st.copyState.serializedSize)
  }

}

@State(Scope.Thread)
class ProtoState {
  private val prototype = Test1("a string", 5, 6, 1.2)

  def copyState = prototype.copy()
}
