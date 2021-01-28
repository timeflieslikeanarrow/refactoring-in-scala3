package com.videorentals

import scala.collection.mutable.ArrayBuffer

class Customer (val name: String):
  private val _rentals = ArrayBuffer[Rental]()
  
  def addRental(arg: Rental) = _rentals.addOne(arg)
  
  def statement: String =
    var totalAmount = 0.0
    var frequentRenterPoints = 0
    var result = s"Rental Record for $name\n"
    for each <- _rentals do
      var thisAmount = 0.0
      each.movie.priceCode match
        case Movie.REGULAR =>
          thisAmount += 2
          if each.daysRented > 0 then
            thisAmount += (each.daysRented - 2) * 1.5
        case Movie.NEW_RELEASE =>
          thisAmount += each.daysRented * 3
        case Movie.CHILDRENS =>
          thisAmount += 1.5
          if each.daysRented > 3 then
            thisAmount += (each.daysRented - 3) * 1.5
    
      frequentRenterPoints += 1
      if each.movie.priceCode == Movie.NEW_RELEASE && each.daysRented > 1 then 
        frequentRenterPoints += 1
      
      result += s"\t${each.movie.title}\t${thisAmount}\n"
      totalAmount += thisAmount

    result += s"Amount owed is ${totalAmount}\n"
    result += s"You earned ${frequentRenterPoints} frequent renter points"
    result
    
