package com.videorentals

import org.scalatest.funsuite.AnyFunSuite

class RentalTests extends AnyFunSuite:
  test("one movie") {
    val movie = Movie("Mulan", Movie.REGULAR)
    val rental = Rental(movie, 3)
    val customer = Customer("John")
    customer.addRental(rental)
    val statement = customer.statement
    assert(s"""
        |Rental Record for ${customer.name}
        |\t${movie.title}\t3.5
        |Amount owed is 3.5
        |You earned 1 frequent renter points
        |""".stripMargin.trim() === statement)
  }
