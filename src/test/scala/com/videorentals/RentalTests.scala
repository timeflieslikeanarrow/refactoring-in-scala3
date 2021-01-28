package com.videorentals

import org.scalatest.funsuite.AnyFunSuite

class RentalTests extends AnyFunSuite:
  test("one movie") {
    val movie = Movie("Mulan", Movie.REGULAR)
    val rental = Rental(movie, 3)
    val customer = Customer("John")
    customer.addRental(rental)
    info("original statement")
    val statement = customer.statement
    assert(s"""
        |Rental Record for ${customer.name}
        |\t${movie.title}\t3.5
        |Amount owed is 3.5
        |You earned 1 frequent renter points
        |""".stripMargin.trim() === statement)
    
    info("html statements")
    val htmlStatement = customer.htmlStatement
    assert(s"""
              |<H1>Rentals for <EM>${customer.name}</EM></H1><P>
              |${movie.title}: 3.5<BR>
              |<P>You owe <EM>3.5</EM><P>
              |On this rental you earned <EM>1</EM> frequent renter points<P>
              |""".stripMargin.trim() === htmlStatement)
  }
