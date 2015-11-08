package io.cenet.gae.scala;

import javax.servlet.Filter
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import io.cenet.scala.datastore.Objectify
import io.cenet.scala.entity.EntityId
import com.google.gson.Gson

class ScalaFilter extends Filter {
  
  
  override def init(config: FilterConfig) = {}
  
  override def destroy = {}
  
  override def doFilter(req : ServletRequest, res : ServletResponse, chain : FilterChain) = {
    val request = req.asInstanceOf[HttpServletRequest]
    val response = res.asInstanceOf[HttpServletResponse]
    
    if (request.getRequestURI().startsWith("/scala")) {
      
      val json = """{"key":"value","number":1,"checkbox":true,"array":["first","second"]}""";
      
      response.getWriter().println(json);
    } else if (request.getRequestURI().startsWith("/api") && "POST".equals(request.getMethod())) {
      Objectify.save.entity(new EntityId).now()
      response.setStatus(200)
    } else if (request.getRequestURI().startsWith("/api") && "GET".equals(request.getMethod())) {
      val gson = new Gson()
      // Note the necessary scala escape for java keyword type and class
      response.getWriter().println(gson.toJson(Objectify.load.`type`(classOf[EntityId]).list))
    }
  }
}