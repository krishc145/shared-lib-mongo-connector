// vars/mongoConnector.groovy
def call() {
    echo "=== Running Mongo Connector ==="
    
    // Call actual operations
    mongoOperations('setup')
}
