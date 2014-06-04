package com.gilt

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.mock.MockitoSugar

class HelloWorldTest extends FlatSpec with Matchers with MockitoSugar {

  ignore should "be an ignored test for an example" in {
    true shouldEqual true
  }

  "logger" should "just print to STDOUT as an example" in {
    HelloWorld.main(Array.empty[String])
  }

}
