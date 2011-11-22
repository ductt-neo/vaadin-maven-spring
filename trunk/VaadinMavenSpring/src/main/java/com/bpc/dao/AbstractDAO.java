package com.bpc.dao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractDAO<DomainObject, KeyType> {

    public DomainObject load(KeyType id);

    public void update(DomainObject object);

    public void save(DomainObject object);

    public void delete(DomainObject object);

    public void deleteById(KeyType id);

    public List<DomainObject> getList();

    public void deleteAll();

    public int count();

}


