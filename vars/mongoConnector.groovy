def call() {
    def libPath = "${env.WORKSPACE}\\@libs\\shared-lib-mongo-connector"
    def jarPath = "${libPath}\\lib\\mongodb-driver-sync-5.5.0.jar"
    def scriptPath = "${libPath}\\scripts\\mongo-connector.groovy"

    bat """
    @echo off
    set CLASSPATH="${jarPath};${libPath}\\scripts"
    groovy -cp %CLASSPATH% "%scriptPath%"
    """
}