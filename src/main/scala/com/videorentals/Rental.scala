package com.videorentals

class Rental (val movie: Movie, val daysRented: Int):
  def charge: Double = movie.charge(daysRented)
  def frequentRenterPoints: Int = movie.frequentRenterPoints(daysRented)