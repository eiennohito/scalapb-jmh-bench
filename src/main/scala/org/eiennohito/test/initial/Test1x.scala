// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package org.eiennohito.test.initial

import org.eiennohito.test.initial

@SerialVersionUID(0L)
final case class Test1x(
    obj: Seq[Test2] = Nil
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[Test1x] with com.trueaccord.lenses.Updatable[Test1x] {
    @transient
    lazy val serializedSize: Int = {
      var __size = 0
      obj.foreach(obj => __size += 1 + com.google.protobuf.CodedOutputStream.computeRawVarint32Size(obj.serializedSize) + obj.serializedSize)
      __size
    }
    def writeTo(output: com.google.protobuf.CodedOutputStream): Unit = {
      obj.foreach { __v => 
        output.writeTag(1, 2)
        output.writeRawVarint32(__v.serializedSize)
        __v.writeTo(output)
      };
    }
    def mergeFrom(__input: com.google.protobuf.CodedInputStream): Test1x = {
      val __obj = (scala.collection.immutable.Vector.newBuilder[Test2] ++= this.obj)
      var _done__ = false
      while (!_done__) {
        val _tag__ = __input.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __obj += com.trueaccord.scalapb.LiteParser.readMessage(__input, initial.Test2.defaultInstance)
          case tag => __input.skipField(tag)
        }
      }
      initial.Test1x(
          obj = __obj.result()
      )
    }
    def clearObj = copy(obj = Seq.empty)
    def addObj(__vs: Test2*): Test1x = addAllObj(__vs)
    def addAllObj(__vs: TraversableOnce[Test2]): Test1x = copy(obj = obj ++ __vs)
    def withObj(__v: Seq[Test2]): Test1x = copy(obj = __v)
    def getField(__field: com.google.protobuf.Descriptors.FieldDescriptor): scala.Any = {
      __field.getNumber match {
        case 1 => obj
      }
    }
    override def toString: String = com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = initial.Test1x
}

object Test1x extends com.trueaccord.scalapb.GeneratedMessageCompanion[Test1x] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[Test1x] = this
  def fromFieldsMap(__fieldsMap: Map[com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): Test1x = {
    require(__fieldsMap.keys.forall(_.getContainingType() == descriptor), "FieldDescriptor does not match message type.")
    val __fields = descriptor.getFields
    initial.Test1x(
      __fieldsMap.getOrElse(__fields.get(0), Nil).asInstanceOf[Seq[Test2]]
    )
  }
  def descriptor: com.google.protobuf.Descriptors.Descriptor = TestProto.descriptor.getMessageTypes.get(1)
  def messageCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedMessageCompanion[_] = {
    require(__field.getContainingType() == descriptor, "FieldDescriptor does not match message type.")
    var __out: com.trueaccord.scalapb.GeneratedMessageCompanion[_] = null
    __field.getNumber match {
      case 1 => __out = initial.Test2
    }
  __out
  }
  def enumCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__field)
  lazy val defaultInstance = initial.Test1x(
  )
  implicit class Test1xLens[UpperPB](_l: com.trueaccord.lenses.Lens[UpperPB, Test1x]) extends com.trueaccord.lenses.ObjectLens[UpperPB, Test1x](_l) {
    def obj: com.trueaccord.lenses.Lens[UpperPB, Seq[Test2]] = field(_.obj)((c_, f_) => c_.copy(obj = f_))
  }
  final val OBJ_FIELD_NUMBER = 1
}