package com.github.mdssjc.m101j;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogPostDAO {
  MongoCollection<Document> postsCollection;

  public BlogPostDAO(final MongoDatabase blogDatabase) {
    postsCollection = blogDatabase.getCollection("posts");
  }

  // Return a single post corresponding to a permalink
  public Document findByPermalink(String permalink) {
    return postsCollection.find(new Document("permalink", permalink))
                          .first();
  }

  // Return a list of posts in descending order. Limit determines
  // how many posts are returned.
  public List<Document> findByDateDescending(int limit) {
    return postsCollection.find()
                          .sort(Sorts.orderBy(new Document("_id", -1)))
                          .limit(limit)
                          .into(new ArrayList<>());
  }

  public String addPost(String title, String body, List tags, String username) {
    System.out.println("inserting blog entry " + title + " " + body);

    String permalink = title.replaceAll("\\s", "_"); // whitespace becomes _
    permalink = permalink.replaceAll("\\W", ""); // get rid of non alphanumeric
    permalink = permalink.toLowerCase();

    Document post = new Document().append("title", title)
                                  .append("author", username)
                                  .append("body", body)
                                  .append("permalink", permalink)
                                  .append("tags", tags)
                                  .append("comments", new ArrayList<>())
                                  .append("date", new Date());

    postsCollection.insertOne(post);

    return permalink;
  }

  // Append a comment to a blog post
  public void addPostComment(final String name, final String email, final String body,
                             final String permalink) {
    Document comment = new Document();

    comment.append("author", name);
    if (email != null) {
      comment.append("email", email);
    }
    comment.append("body", body);

    postsCollection.updateOne(new Document("permalink", permalink),
                              new Document("$push", new Document("comments", comment)));
  }
}
