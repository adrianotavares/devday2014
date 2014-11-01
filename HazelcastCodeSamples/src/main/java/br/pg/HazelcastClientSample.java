package br.pg;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * HazelcastClientSample
 * 
 * @author adrianotavares
 *
 */
public class HazelcastClientSample {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("customers");
        System.out.println("Map Size:" + map.size());	
    }

}
