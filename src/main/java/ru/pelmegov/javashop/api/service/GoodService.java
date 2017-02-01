package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.good.Good;

import java.util.Set;

public interface GoodService {

    public Good getGoodByName(String name);

    public Good getGoodById(Integer id);

    public Set<Good> getAllGoods();

    public Set<Good> getGoods(Integer count);

    public Set<Good> getLastAddedGoods(Integer count);

    public Set<Good> getGoodsByCategory(Integer categoryId);

    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId);

}
