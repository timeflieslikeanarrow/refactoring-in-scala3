package com.videorentals

import com.videorentals.Movie.{CHILDRENS, NEW_RELEASE, REGULAR}

abstract class Price:
  def priceCode: Int
  def charge(daysRented: Int): Double
  def frequentRenterPoints(daysRented: Int): Int = 1
  
class ChildrensPrice extends Price:
  override def priceCode: Int = Movie.CHILDRENS
  override def charge(daysRented: Int): Double =
    var result = 1.5
    if daysRented > 3 then
      result += (daysRented - 3) * 1.5
    result

class NewReleasePrice extends Price:
  override def priceCode: Int = Movie.NEW_RELEASE
  override def charge(daysRented: Int): Double = daysRented * 3.0
  override def frequentRenterPoints(daysRented: Int): Int =
    if daysRented > 1 then 2 else 1
  
class RegularPrice extends Price:
  override def priceCode: Int = Movie.REGULAR
  override def charge(daysRented: Int): Double =
    var result = 2.0
    if daysRented > 0 then
          result += (daysRented - 2) * 1.5
    result

class Movie (val title: String, _priceCode: Int):
  var _price: Price = null
  def priceCode: Int = _price.priceCode
  def priceCode_=(_priceCode: Int): Unit = setPriceCode(_priceCode)

  def setPriceCode(arg: Int): Unit =
    _price = arg match
      case REGULAR => RegularPrice()
      case CHILDRENS => ChildrensPrice()
      case NEW_RELEASE => NewReleasePrice()
  
  setPriceCode(_priceCode)
  
  def charge(daysRented: Int): Double = _price.charge(daysRented)

  def frequentRenterPoints(daysRented: Int): Int =
    _price.frequentRenterPoints(daysRented)
    
object Movie:
  val CHILDRENS = 2
  val REGULAR = 0
  val NEW_RELEASE = 1

//  def apply(title: String, priceCode: Int): Movie =
//    val movie = new Movie(title)
//    movie.setPriceCode(priceCode)
//    movie
