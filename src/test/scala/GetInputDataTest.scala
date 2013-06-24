package com.crooy

import org.scalatest.FunSuite
import scala.io.Source

class GetInputDataTest extends FunSuite {
  test("test get image"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    assert(data.getHeight() == 1111)
    assert(data.getWidth() == 1111)
  }
  test("test get image as 1's and 0's"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    val pixels = GetInputData.ConvertToBlackAndWhite(data)
    println(pixels.length)
    //expecting 1111 x 1111 image
    assert(1111 * 1111 == pixels.length)
  }

}