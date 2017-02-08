package ru.pelmegov.javashop.service;

import ru.pelmegov.javashop.model.good.Good;

import java.util.Set;

public interface GoodService {

    public Good getGoodByName(String name);

    public Good getGoodByName(String name, Boolean active);

    public Good getGoodById(Integer id);

    public Good getGoodById(Integer id, Boolean active);

    public Set<Good> getAllGoods();

    public Set<Good> getAllGoods(Boolean active);

    public Set<Good> getGoods(Integer count);

    public Set<Good> getGoods(Integer count, Boolean active);

    public Set<Good> getLastAddedGoods(Integer count);

    public Set<Good> getLastAddedGoods(Integer count, Boolean active);

    public Set<Good> getGoodsByCategory(Integer categoryId);

    public Set<Good> getGoodsByCategory(Integer categoryId, Boolean active);

    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId);

    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId, Boolean active);

    void addGood(Good good);

    void updateGood(Good good);

    void deleteGood(Integer id);
}
