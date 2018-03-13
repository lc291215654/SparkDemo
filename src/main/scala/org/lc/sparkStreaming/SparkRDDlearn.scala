package org.lc.sparkStreaming

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.ClassificationModel

/**
  * Created by licheng on 2/27/17.
  */
object SparkRDDlearn {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD").setMaster("local[1]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize({
      List((1, 2), (2, 3), (3, 4))
    })
    val rdd2 = rdd1.keys
    val rdd3 = rdd1.values
    for (a <- rdd3) {
      println(a)
      System.out.println("adf")
    }
  }


}
