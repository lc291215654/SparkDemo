package org.lc.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Hello world!
 *
 */
object App extends Application {
  println( "Hello World!" )
  val conf = new SparkConf().setMaster("local[2]").setAppName("FindError")
  val ssc = new StreamingContext(conf,Seconds(1))
  val lines = ssc.socketTextStream("localhost",7777)
  val errorLines = lines.filter(_.contains("error"))
  errorLines.print()

  ssc.start()
  ssc.awaitTermination()
}
