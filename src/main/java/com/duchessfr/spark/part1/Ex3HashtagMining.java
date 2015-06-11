package com.duchessfr.spark.part1;

import com.duchessfr.spark.utils.Parse;
import com.duchessfr.spark.utils.Tweet;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.List;

/**
 *  The Java Spark API documentation: http://spark.apache.org/docs/latest/api/java/index.html
 *
 *  Now we use a dataset with 8198 tweets. Here an example of a tweet:
 *
 *  {"id":"572692378957430785",
 *    "user":"Srkian_nishu :)",
 *    "text":"@always_nidhi @YouTube no i dnt understand bt i loved of this mve is rocking",
 *    "place":"Orissa",
 *    "country":"India"}
 *
 *  We want to make some computations on the hashtags. It is very similar to the exercise 2
 *  - Find all the hashtags mentioned on a tweet
 *  - Count how many times each hashtag is mentioned
 *  - Find the 10 most popular hashtag by descending order
 */
public class Ex3HashtagMining {

  private static String pathToFile = "data/reduced-tweets.txt";

  /**
   *  Load the data from the text file and return an RDD of Tweet
   */
  public JavaRDD<Tweet> loadData() {
    // create spark configuration and spark context
    SparkConf conf = new SparkConf()
        .setAppName("Tweet mining")
        .setMaster("local[*]");

    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<Tweet> tweets = sc.textFile(pathToFile)
        .map(line -> Parse.parseJsonToTweet(line));

    return tweets;
  }

  /**
   *  Find all the hashtags mentioned on tweets
   */
  public JavaRDD<String> hashtagMentionedOnTweet() {
    JavaRDD<Tweet> tweets = loadData();

    // Hint: use a regex...
    JavaRDD<String> mentions = null;

    return mentions;

  }

  /**
   *  Count how many times each hashtag is mentioned
   */
  public JavaPairRDD<String,Integer> countMentions() {
    JavaRDD<String> mentions = hashtagMentionedOnTweet();

    // Hint: think about the wordcount example
    JavaPairRDD<String, Integer> counts = null;

    return counts;

  }

  /**
   *  Find the 10 most popular Hashtags by descending order
   */
  public List<Tuple2<Integer, String>> mostMentioned() {
    JavaPairRDD<String, Integer> counts = countMentions();

    // Hint: take a look at the sorting and then the take methods
    List<Tuple2<Integer, String>> mostMentioned = null;

    return mostMentioned;

  }

}