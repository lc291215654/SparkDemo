package org.lc.SparkCore

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

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
    rdd1.persist(StorageLevel.DISK_ONLY);
    rdd1.
    val rdd2 = rdd1.keys
    val rdd3 = rdd1.values
    for (a <- rdd3) {
      println(a)
      System.out.println("adf")
    }
  }
}
