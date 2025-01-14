/*
 * Copyright 2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.mdssjc.m101j;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.commons.codec.binary.Base64;
import org.bson.Document;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class UserDAO {

  private final MongoCollection<Document> usersCollection;
  private Random random = new SecureRandom();

  public UserDAO(final MongoDatabase blogDatabase) {
    usersCollection = blogDatabase.getCollection("users");
  }

  // validates that username is unique and insert into db
  public boolean addUser(String username, String password, String email) {

    String passwordHash = makePasswordHash(password,
                                           Integer.toString(random.nextInt()));

    Document user = new Document();

    user.append("_id", username)
        .append("password", passwordHash);

    if (email != null && !email.equals("")) {
      // the provided email address
      user.append("email", email);
    }

    try {
      usersCollection.insertOne(user);
      return true;
    } catch (MongoWriteException e) {
      System.out.println("Username already in use: " + username);
      return false;
    }
  }

  public Document validateLogin(String username, String password) {
    Document user = usersCollection.find(Filters.eq("_id", username))
                                   .first();

    if (user == null) {
      System.out.println("User not in database");
      return null;
    }

    String hashedAndSalted = user.get("password")
                                 .toString();

    String salt = hashedAndSalted.split(",")[1];

    if (!hashedAndSalted.equals(makePasswordHash(password, salt))) {
      System.out.println("Submitted password is not a match");
      return null;
    }

    return user;
  }

  private String makePasswordHash(String password, String salt) {
    try {
      String saltedAndHashed = password + "," + salt;
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(saltedAndHashed.getBytes());
      Base64 encoder = new Base64();
      byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
      return encoder.encodeAsString(hashedBytes) + "," + salt;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("MD5 is not available", e);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
    }
  }
}
