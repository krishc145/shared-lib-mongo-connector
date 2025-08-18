// File: mongoConnector.groovy
// No @Grab needed since JAR is inside lib/ of shared library

package com.yourcompany.mongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients

class mongoConnector implements Serializable {

    /**
     * Connects to MongoDB.
     * @param uri MongoDB connection URI (default: "mongodb://localhost:27017")
     * @return MongoClient instance
     */
    static MongoClient connect(String uri = "mongodb://localhost:27017") {
        println "Connecting to MongoDB at ${uri}"
        MongoClient client = MongoClients.create(uri)
        return client
    }

    /**
     * Closes the given MongoClient connection.
     * @param client MongoClient instance to close
     */
    static void close(MongoClient client) {
        if (client != null) {
            client.close()
            println "MongoDB connection closed"
        }
    }
}
