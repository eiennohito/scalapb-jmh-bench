// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package org.eiennohito.test.opt


@SerialVersionUID(0L)
final case class Test3(
  s1: String = ""
) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[Test3] with com.trueaccord.lenses.Updatable[Test3] {
  @transient
  lazy val serializedSize: Int = {
    var __size = 0
    if (s1 != "") {
      __size += com.google.protobuf.CodedOutputStream.computeStringSize(1, s1)
    }
    __size
  }

  def writeTo(output: com.google.protobuf.CodedOutputStream): Unit = {
    {
      val __v = s1
      if (__v != "") {
        output.writeString(1, __v)
      }
    };
  }

  def mergeFrom(__input: com.google.protobuf.CodedInputStream): Test3 = {
    var __s1 = this.s1
    var _done__ = false
    while (!_done__) {
      val _tag__ = __input.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __s1 = __input.readString()
        case tag => __input.skipField(tag)
      }
    }
    Test3(
      s1 = __s1
    )
  }

  def withS1(__v: String): Test3 = copy(s1 = __v)

  def getField(__field: com.google.protobuf.Descriptors.FieldDescriptor): scala.Any = {
    __field.getNumber match {
      case 1 => {
        val __t = s1
        if (__t != "") __t else null
      }
    }
  }

  override def toString: String = com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)

  def companion = Test3
}

object Test3 extends com.trueaccord.scalapb.GeneratedMessageCompanion[Test3] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[Test3] = this

  def fromFieldsMap(__fieldsMap: Map[com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): Test3 = {
    require(__fieldsMap.keys.forall(_.getContainingType() == descriptor), "FieldDescriptor does not match message type.")
    val __fields = descriptor.getFields
    Test3(
      __fieldsMap.getOrElse(__fields.get(0), "").asInstanceOf[String]
    )
  }

  def descriptor: com.google.protobuf.Descriptors.Descriptor = TestProto.descriptor.getMessageTypes.get(3)

  def messageCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__field)

  def enumCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__field)

  lazy val defaultInstance = Test3(
  )

  implicit class Test3Lens[UpperPB](_l: com.trueaccord.lenses.Lens[UpperPB, Test3]) extends com.trueaccord.lenses.ObjectLens[UpperPB, Test3](_l) {
    def s1: com.trueaccord.lenses.Lens[UpperPB, String] = field(_.s1)((c_, f_) => c_.copy(s1 = f_))
  }

  final val S1_FIELD_NUMBER = 1
}
