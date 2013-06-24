package com.crooy

import java.awt.Image
import java.io._
import java.net.URL
import javax.imageio.ImageIO
import java.awt.image._

object GetInputData {
 
  def ReadFile(file:URL)={
	ImageIO.read(file)
  } 
  
  def Scale(image:BufferedImage, size:Int)={
    val scaled = image.getScaledInstance(size, -1, Image.SCALE_SMOOTH)
	val buffered = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null), BufferedImage.TYPE_INT_RGB);
	buffered.getGraphics().drawImage(image, 0, 0 , null);
	buffered
  }

  def ConvertToBlackAndWhite(bufImg:Raster)={
    val width = bufImg.getWidth();val height = bufImg.getHeight();
    for(x <- 0 until width; y <- 0 until height) yield{
    	val pixel = bufImg.getPixel(x, y, new Array[Int](3))
    	val sumPixel = pixel(0) + pixel(1) + pixel(2)
        if (sumPixel < 200) 1  //the magic number that seperates black from white
        else 0 	
    }
  }
}