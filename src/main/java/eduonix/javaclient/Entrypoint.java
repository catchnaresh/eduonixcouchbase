package eduonix.javaclient;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;

/**
 * http://cbdocs.br19.com/developer/java-2.1/hello-couchbase.html
 */
public class Entrypoint {


    private static Bucket bucket;
    private static Cluster cluster;

    public static void main(String[] args) {


        // Connect Sync
        cluster = CouchbaseCluster.create();
        bucket = cluster.openBucket("beer-sample");

        JsonDocument contentFound = bucket.get("beer-sample");

        if (contentFound == null) {

            JsonObject content = JsonObject.create();

            content.put("name", "test data");
            content.put("id", "test id");

            JsonDocument doc =  JsonDocument.create("beer-sample", content);
            bucket.insert(doc);

        }

        else {

            System.out.println("Found: " + contentFound);

        }





    }
}
