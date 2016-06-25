package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.TableOperation;
import com.microsoft.azure.storage.table.TableQuery;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.House;

public class CloudRepository implements Repository {

    private CloudTable table;

    public CloudRepository(CloudTable table) {
        this.table = table;
    }

    @Override
    public void insertOrUpdate(HouseEntity house) throws StorageException {
        TableOperation operation = TableOperation.insertOrReplace(house);
        table.execute(operation);
    }


    @Override
    public HouseEntity delete(String id) throws StorageException {
        HouseEntity house = find(id);
        if (house==null) return null;
        TableOperation operation = TableOperation.delete(house);
        table.execute(operation);
        return house;
    }

    @Override
    public HouseEntity find(String id) throws StorageException {
        TableOperation operation =
                TableOperation.retrieve(
                        HouseEntity.getPartitionValue(),
                        id,
                        HouseEntity.class);
        return table.execute(operation).getResultAsType();
    }

    @Override
    public Iterable<HouseEntity> getAll() {
        TableQuery<HouseEntity> query =
                TableQuery.from(HouseEntity.class);
        return table.execute(query);
    }
}