package com.test

import scala.util.Random

case class Texto(val id:Int, val texto:String)

class RestDB {

  private[this] var db = Map[Int,Texto]()
  
  def all = db.values
  
  def get(id:Int) = db.get(id)
  
  def create(text:String) = {
    val t = new Texto(math.abs(new Random() nextInt), text)
    
    db += (t.id -> t)
    
    t
  } 
  
  def set(existent:Texto, text:String) = {
    val t = new Texto(existent.id, text)
    
    db += (t.id -> t)
    
    t
  }
  
}