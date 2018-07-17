package redistest1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {

	public static void main(String[] args) {
		JedisPool pool = new JedisPool("127.0.0.1");
		Jedis jedis = pool. getResource();
		String value = jedis.get("name");
		System.out.println(value);
		//jedis.setex("name",15,"rupeng");//数据有效期15秒
		//jedis.set("name", "qq");//key-value
		jedis.close();
		pool.close();
	}

}
