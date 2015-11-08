package io.cenet.scala.entity

import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Cache
import com.googlecode.objectify.annotation.Id

@Entity
@Cache
class EntityId {
  
  @Id
  var id: java.lang.Long = null
}
