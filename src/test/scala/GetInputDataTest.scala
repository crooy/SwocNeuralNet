package com.crooy

import org.scalatest.FunSuite
import scala.io.Source

class GetInputDataTest extends FunSuite {
  test("Can read files into memory"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    assert(data.getHeight() == 1111)
    assert(data.getWidth() == 1111)
  }
  test("Can read files into pixels"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    val pixels = GetInputData.ConvertToBlackAndWhite(data)
    //expecting 1111 x 1111 image
    assert(1111 * 1111 == pixels.length)
  }
  test("Can read files into pixels that are 1 or 0"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    val pixels = GetInputData.ConvertToBlackAndWhite(data)
    assert(pixels.forall(b => b == 0 || b == 1))
    assert(pixels.count(_ == 1) > 10) // assume that there are more than 10 black pixels
  }


}