def call() {
    // Adjust path and classpath as needed
    bat """
    groovy -cp "K:\\...\\lib\\mongodb-driver-sync-5.5.0.jar" K:\\...\\mongoConnector.groovy
    """
}