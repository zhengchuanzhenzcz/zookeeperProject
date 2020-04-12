package cn.enjoy.product.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by VULCAN on 2018/7/25.
 */
public class ServiceRegister {

    private  static final String BASE_SERVICES = "/services";

    private static final String  SERVICE_NAME="/products";

    public  static void register(String address,int port) {
        try {
            String path = BASE_SERVICES + SERVICE_NAME;
            ZooKeeper zooKeeper =  new ZooKeeper("127.0.0.1:2181",5000, (watchedEvent)->{});
            Stat exists = zooKeeper.exists(BASE_SERVICES + SERVICE_NAME, false);

            //先判断服务根路径是否存在
            if(exists == null) {
                zooKeeper.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            String server_path = address+":" +port;
            zooKeeper.create(path+"/child",server_path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.err.println("产品服务注册成功");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
