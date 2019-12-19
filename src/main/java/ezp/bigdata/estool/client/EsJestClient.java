package ezp.bigdata.estool.client;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.io.IOException;
import java.util.Collection;

/**
 * @author nannan
 * @date 2019/10/21
 */
public class EsJestClient {

    private static JestClient jestClient;

    /**
     * 单节点
     * @param serverUrl esUrl
     * @return client
     */
    public static JestClient getJestClient(String serverUrl){
        HttpClientConfig config = new HttpClientConfig.Builder(serverUrl).build();
        return getJestClient(config);
    }

    /**
     * 集群获取方式
     * @param serverUris serverUris
     * @return  client
     */
    public static JestClient getJestClient(Collection<String> serverUris){
        HttpClientConfig config = new HttpClientConfig.Builder(serverUris).build();
        return getJestClient(config);
    }

    /**
     * 自由配置
     * @param config 配置类
     * @return  client
     */
    public static JestClient getJestClient(HttpClientConfig config){
        if(jestClient == null){
            JestClientFactory factory = new JestClientFactory();
            factory.setHttpClientConfig(config);
            jestClient = factory.getObject();
        }
        return jestClient;
    }

    public static void close(JestClient jestClient) throws IOException {
        if(jestClient !=null){
            jestClient.close();
        }
    }

}
