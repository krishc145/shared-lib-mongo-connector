// mongoConnector.groovy
@GrabResolver(name='localLib', root='file://C:/path/to/shared-lib-mongo-connector/lib/')
@Grab('org.mongodb:mongodb-driver-sync:4.11.5')

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient

def connect(String uri = "mongodb://localhost:27017") {
    echo "Connecting to MongoDB at ${uri}"
    MongoClient client = MongoClients.create(uri)
    return client
}
