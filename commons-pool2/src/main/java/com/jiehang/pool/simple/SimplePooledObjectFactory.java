package com.jiehang.pool.simple;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class SimplePooledObjectFactory implements PooledObjectFactory<MyPooledObject>{

    @Override
    public PooledObject<MyPooledObject> makeObject() throws Exception {
        return new DefaultPooledObject<>(new MyPooledObject());
    }

    @Override
    public void destroyObject(PooledObject<MyPooledObject> p) throws Exception {
    }

    @Override
    public boolean validateObject(PooledObject<MyPooledObject> p) {
        return p.getObject() != null;
    }

    @Override
    public void activateObject(PooledObject<MyPooledObject> p) throws Exception {
        if (null == p.getObject())
            p = new DefaultPooledObject<MyPooledObject>(new MyPooledObject());
    }

    @Override
    public void passivateObject(PooledObject<MyPooledObject> p) throws Exception {
    }
}
