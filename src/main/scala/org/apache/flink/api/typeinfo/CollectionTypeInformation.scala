package org.apache.flink.api.typeinfo

import org.apache.flink.api.common.ExecutionConfig
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.api.common.typeutils.TypeSerializer

import scala.reflect.{ClassTag, classTag}

case class CollectionTypeInformation[T: ClassTag](serializer: TypeSerializer[T]) extends TypeInformation[T] {
  val clazz                                                                 = classTag[T].runtimeClass.asInstanceOf[Class[T]]
  override def createSerializer(config: ExecutionConfig): TypeSerializer[T] = serializer
  override def isBasicType: Boolean                                         = false
  override def isTupleType: Boolean                                         = false
  override def isKeyType: Boolean                                           = false
  override def getTotalFields: Int                                          = 1
  override def getTypeClass: Class[T]                                       = clazz
  override def getArity: Int                                                = 1
}
