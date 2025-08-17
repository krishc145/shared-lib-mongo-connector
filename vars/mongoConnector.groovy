@Grab('org.mongodb:mongodb-driver-sync:4.9.1')
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient

def connect(String uri = "mongodb://localhost:27017") {
    echo "Connecting to MongoDB at ${uri}"
    MongoClient client = MongoClients.create(uri)
    return client
}
