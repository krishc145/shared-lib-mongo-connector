package com.yourcompany.mongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.MongoCollection
import org.bson.Document
import com.mongodb.MongoWriteException

class MongoOperations implements Serializable {

    static MongoDatabase createDatabase(MongoClient client, String dbName) {
        println "Database '${dbName}' is ready"
        return client.getDatabase(dbName)
    }

    static void createCollection(MongoDatabase db, String collectionName) {
        try {
            if (!db.listCollectionNames().into([]).contains(collectionName)) {
                db.createCollection(collectionName)
                println "Collection '${collectionName}' created"
            } else {
                println "Collection '${collectionName}' already exists"
            }
        } catch (MongoWriteException e) {
            println "Write exception: ${e.error.code} - ${e.error.message}"
        } catch (Exception e) {
            println "Error creating collection: ${e.message}"
        }
    }

    static void insertDocument(MongoDatabase db, String collectionName, Map data) {
        MongoCollection<Document> collection = db.getCollection(collectionName)
        try {
            collection.insertOne(new Document(data))
            println "Document inserted into '${collectionName}'"
        } catch (MongoWriteException e) {
            println "Write exception: ${e.error.code} - ${e.error.message}"
        } catch (Exception e) {
            println "Error inserting document: ${e.message}"
        }
    }
}