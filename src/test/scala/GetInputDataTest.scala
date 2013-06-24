package com.crooy

import org.scalatest.FunSuite
import scala.io.Source

class GetInputDataTest extends FunSuite {
  test("test get image"){
    val data = GetInputData.ReadFile(getClass.getResource("/sun.png"))
    //expecting 1111 x 1111 image
    assert(1111 * 1111 == data.size)
  }
}