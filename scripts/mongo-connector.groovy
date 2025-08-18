import com.mongodb.client.MongoClients
import com.yourcompany.mongo.MongoOperations

def mongoUri = "mongodb://localhost:27017"
def dbName = "krishna-admin-monogo"
def collectionName = "krishna-admin-collection-fruits"

println "[MongoConnector] Connecting to MongoDB at ${mongoUri}"
def client = MongoClients.create(mongoUri)

def db = MongoOperations.createDatabase(client, dbName)
MongoOperations.createCollection(db, collectionName)
MongoOperations.insertDocuments(db, collectionName, [
    [name: "apple"],
    [name: "orange"]
])

client.close()
println "[MongoConnector] MongoDB setup complete."