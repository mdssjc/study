package com.github.mdssjc.m101j;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class Homework31 {

  public static void main(String[] args) {
    MongoClient client = new MongoClient();

    MongoDatabase database = client.getDatabase("school");
    final MongoCollection<Document> students = database.getCollection(
        "students");

    MongoCursor<Document> iterator =
        students.find(new Document("scores.type", "homework"))
                .iterator();

    while (iterator.hasNext()) {
      Document doc = iterator.next();
      List<Document> scores = (List<Document>) doc.get("scores");

      Document hw1 = scores.get(2);
      Double hw1Score = hw1.getDouble("score");

      Document hw2 = scores.get(3);
      Double hw2Score = hw2.getDouble("score");

      if (hw1Score > hw2Score) {
        scores.remove(3);
      } else {
        scores.remove(2);
      }

      students.replaceOne(new Document("_id", doc.get("_id")), doc);
    }
  }
}
