package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;

public class RepositoryFactory {

    public static Repository create() throws StorageException {
        return new CloudRepository(getTable());
    }

    private static CloudTable getTable() throws StorageException {

        final String storageConnectionString = "DefaultEndpointsProtocol=http;"
                + "AccountName=wrinkl3;"
                + "AccountKey=7gd+LH8397613+5HxTNtemqTuP6ZrHL3Dq43g3uimJZn3gcrTHGxbxSQYB55w2/Ab5cdEKBUjyTDHfwkKKFe8Q==";

        CloudStorageAccount storageAccount;
        try {
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
        } catch (InvalidKeyException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        CloudTableClient tableClient = storageAccount.createCloudTableClient();
        final String tableName = "houses";
        CloudTable cloudTable;
        try {
            cloudTable = tableClient.getTableReference(tableName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        cloudTable.createIfNotExists();
        return cloudTable;
    }
}