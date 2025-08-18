package com.example

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.MongoCollection
import org.bson.Document

class MongoHelper {

    static void setup() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")
        MongoDatabase db = mongoClient.getDatabase("krishna-mongo-dba")
        
        // Create collection if not exists
        def collectionNames = db.listCollectionNames().into([])
        if (!collectionNames.contains("krishna-collection-fruits")) {
            db.createCollection("krishna-collection-fruits")
        }
        
        MongoCollection<Document> collection = db.getCollection("krishna-collection-fruits")
        
        // Insert sample data
        collection.insertMany([
            new Document("name", "apple"),
            new Document("name", "mango")
        ])
        
        println("Setup complete!")
        mongoClient.close()
    }
}
