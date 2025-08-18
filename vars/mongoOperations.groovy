// vars/mongoOperations.groovy
import com.mongodb.client.MongoClients
import org.bson.Document

def call(String action = 'setup') {
    echo "=== Running Mongo Operations (action: ${action}) ==="

    if (action == 'setup') {
        // Connect to MongoDB (default localhost:27017)
        def client = MongoClients.create("mongodb://localhost:27017")

        // Create database and collection
        def db = client.getDatabase("krishna-DB-admin")
        def coll = db.getCollection("dba-admin-fruits")

        // Insert sample data
        coll.insertOne(new Document("name", "mango"))
        coll.insertOne(new Document("name", "apple"))
        coll.insertOne(new Document("name", "jackfruit"))

        // Print inserted data
        coll.find().forEach { doc ->
            echo "Inserted -> ${doc.toJson()}"
        }

        client.close()
        echo "=== Mongo setup complete! ==="
    } else {
        echo "Unknown action: ${action}"
    }
}
