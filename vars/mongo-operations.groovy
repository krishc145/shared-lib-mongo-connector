// vars/mongoOperations.groovy
import com.example.MongoHelper

def call(String action = 'setup') {
    echo "=== Mongo Operations: ${action} ==="

    if (action == 'setup') {
        MongoHelper.setup()
    } else {
        echo "Unknown action: ${action}"
    }
}
