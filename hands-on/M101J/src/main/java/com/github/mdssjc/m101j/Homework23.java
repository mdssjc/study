package com.github.mdssjc.m101j;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

public class Homework23 {

  public static void main(String[] args) {
    MongoClient client = new MongoClient();

    MongoDatabase database = client.getDatabase("students");
    final MongoCollection<Document> grades = database.getCollection("grades");

    FindIterable<Document> docs = grades
        .find(new Document("type", "homework"))
        .sort(Sorts.orderBy(new Document("student_id", 1),
                            new Document("score", 1)));

    MongoCursor<Document> iterator = docs.iterator();
    Document d;
    while (iterator.hasNext()) {
      d = iterator.next();
      System.out.println("RM: " + d);
      grades.deleteOne(new Document("_id", d.getObjectId("_id")));

      d = iterator.next();
      System.out.println("OK: " + d);
    }
  }
}
