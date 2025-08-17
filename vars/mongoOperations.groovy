import org.bson.Document

def createDatabase(mongoClient, String dbName) {
    def db = mongoClient.getDatabase(dbName)
    echo "Database '${dbName}' is ready"
    return db
}

def createCollection(db, String collectionName) {
    try {
        db.createCollection(collectionName)
        echo "Collection '${collectionName}' created"
    } catch (Exception e) {
        echo "Collection '${collectionName}' may already exist: ${e.message}"
    }
}

def insertDocument(db, String collectionName, Map doc) {
    def collection = db.getCollection(collectionName)
    collection.insertOne(new Document(doc))
    echo "Inserted document into '${collectionName}' -> ${doc}"
}
