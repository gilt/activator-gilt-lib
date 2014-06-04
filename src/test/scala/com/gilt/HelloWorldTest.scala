package com.gilt

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar

class HelloWorldTest extends FlatSpec with ShouldMatchers with MockitoSugar {

  ignore should "be an ignored test for an example" in {
    true should be === true
  }

  "logger" should "just print to STDOUT as an example" in {
    HelloWorld.main(Array.empty[String])
  }

}
