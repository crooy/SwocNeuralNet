package com.crooy

object GetInputData {
  import java.io._
  import java.net.URL
  import javax.imageio.ImageIO
  import java.awt.image._
 
  def ReadFile(file:URL)={
	ImageIO.read(file).getData();
  } 

  def ConvertToBlackAndWhite(bufImg:Raster)={
    val width = bufImg.getWidth();val height = bufImg.getHeight();
    for(x <- 0 until width; y <- 0 until height) yield{
    	val pixel = bufImg.getPixel(x, y, new Array[Int](3))
        if (pixel(0) + pixel(1) + pixel(2) > 384) 1 
        else 0 	
    }
  }
}