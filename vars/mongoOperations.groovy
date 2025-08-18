@Grab(group='org.mongodb', module='mongodb-driver-sync', version='5.5.0')
import com.mongodb.client.*
import org.bson.Document

def call(String action = 'setup') {
    echo "=== Running Mongo Operations with action: ${action} ==="

    if (action == 'setup') {
        try {
            // ✅ Connect to MongoDB (default localhost:27017)
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")

            // ✅ Create DB
            MongoDatabase database = mongoClient.getDatabase("krishna-DB-admin")
            echo "MongoDB Database created/connected: krishna-DB-admin"

            // ✅ Create Collection
            MongoCollection<Document> collection = database.getCollection("dba-admin-fruits")
            echo "MongoDB Collection created/connected: dba-admin-fruits"

            // ✅ Insert documents
            List<Document> fruits = [
                new Document("name", "mango"),
                new Document("name", "apple"),
                new Document("name", "jackfruit")
            ]
            collection.insertMany(fruits)
            echo "Inserted fruits: mango, apple, jackfruit"

            // ✅ Verify insert
            collection.find().forEach { doc ->
                echo "DB Record -> ${doc.toJson()}"
            }

            mongoClient.close()
        } catch (Exception e) {
            error "Mongo operation failed: ${e.message}"
        }
    } else {
        echo "Unknown action: ${action}"
    }
}
