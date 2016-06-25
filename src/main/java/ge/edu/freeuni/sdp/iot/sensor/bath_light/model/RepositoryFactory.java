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
                + "AccountKey=+9HqkIG/4PAMDmC9zKe7wjRPt/Nq6alKtKUOMbM7tSToWACOjNtw47sFuslrYAJkU8SYbeIhDi9CQ7VI0qcBoCg==";

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