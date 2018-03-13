package org.lc.sparkStreaming

/**
  * Created by licheng on 1/6/17.
  */
import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds

object SparkStreamingNC {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[1]").setAppName("FindError")
    val ssc = new StreamingContext(conf,Seconds(2))
    val lines = ssc.socketTextStream("192.168.1.217",7777)
    //val errorLines = lines.filter(_.contains("error"))
    //errorLines.print()
    val words = lines.flatMap(line => line.split(" "))

    val ones = words.map(word => (word,1))
    val counts = ones.reduceByKey(_+_)
    counts.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
