// vars/mongoConnector.groovy
def call() {
    echo "=== Running Mongo Connector ==="
    mongoOperations('setup')
}
