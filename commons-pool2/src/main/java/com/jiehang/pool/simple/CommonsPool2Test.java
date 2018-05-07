package com.jiehang.pool.simple;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class CommonsPool2Test {

	public static void main(String[] args) throws Exception {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxIdle(8);
		config.setMaxTotal(8);
		config.setMaxWaitMillis(3000);
        ObjectPool<MyPooledObject> objectPool = new GenericObjectPool<MyPooledObject>(new SimplePooledObjectFactory(), config);
        for(int i= 0; i<50; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						MyPooledObject myPooledObject = objectPool.borrowObject();
						myPooledObject.getConnect();
						objectPool.returnObject(myPooledObject);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
        }
    }
}