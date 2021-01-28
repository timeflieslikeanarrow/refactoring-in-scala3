package com.videorentals

import scala.collection.mutable.ArrayBuffer

class Customer (val name: String):
  private val _rentals = ArrayBuffer[Rental]()
  
  def addRental(arg: Rental) = _rentals.addOne(arg)
  def totalCharge: Double = _rentals.map(_.charge).sum
  def totalFrequentRenterPoints: Int = _rentals.map(_.frequentRenterPoints).sum
  
  def statement: String =
    var result = s"Rental Record for $name\n"
    for each <- _rentals do
      result += s"\t${each.movie.title}\t${each.charge}\n"

    result += s"Amount owed is ${totalCharge}\n"
    result += s"You earned ${totalFrequentRenterPoints} frequent renter points"
    result
  
  def htmlStatement: String =
    var result = s"<H1>Rentals for <EM>$name</EM></H1><P>\n"
    for each <- _rentals do
      result += s"${each.movie.title}: ${each.charge}<BR>\n"

    result += s"<P>You owe <EM>${totalCharge}</EM><P>\n"
    result += s"On this rental you earned <EM>${totalFrequentRenterPoints}</EM> frequent renter points<P>"
    result
    
