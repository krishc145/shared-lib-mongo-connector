def call() {
    def libPath = "${env.WORKSPACE}\\@libs\\shared-lib-mongo-connector"
    def jarPath = "${libPath}\\lib\\mongodb-driver-sync-5.5.0.jar"
    def scriptPath = "${libPath}\\scripts\\mongo-connector.groovy"

    bat """
    @echo off
    echo === Running Mongo Connector ===
    groovy -cp "${jarPath};${libPath}\\scripts" "${scriptPath}"
    """
}