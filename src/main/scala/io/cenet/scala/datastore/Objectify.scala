package io.cenet.scala.datastore

import scala.scalajs.js.annotation.JSExportAll

import com.googlecode.objectify.ObjectifyService

import io.cenet.scala.entity.EntityId

object Objectify {
  
  ObjectifyService.register(classOf[EntityId])
  
  def load = ObjectifyService.ofy().load()
  
  def save = ObjectifyService.ofy().save()
  
  def delete = ObjectifyService.ofy().delete()
}