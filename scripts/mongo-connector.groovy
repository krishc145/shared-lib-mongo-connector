import com.mongodb.client.MongoClients
import com.yourcompany.mongo.MongoOperations

def client = MongoClients.create("mongodb://localhost:27017")
def db = MongoOperations.createDatabase(client, "testDB")
MongoOperations.createCollection(db, "users")
MongoOperations.insertDocument(db, "users", [name: "Krishnakumar", role: "developer"])
client.close()
