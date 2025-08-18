// vars/mongoOperations.groovy
def call(String action = 'setup') {
    echo "=== Mongo Operations: ${action} ==="

    if (action == 'setup') {
        // Create database and collection, insert data
        bat """
            echo Creating database 'krishna-mongo-dba' and collection 'krishna-collection-fruits'...
            mongo --eval "db = db.getSiblingDB('krishna-mongo-dba'); db.createCollection('krishna-collection-fruits'); db['krishna-collection-fruits'].insertMany([{name: 'apple'}, {name: 'mango'}]); print('Setup complete!')"
        """
    } else {
        echo "Unknown action: ${action}"
    }
}
