package ru.pelmegov.javashop.api.dao;

import ru.pelmegov.javashop.model.Good;

import java.util.Set;

public interface GoodDAO {

    public Good getGoodByName(String goodName);

    public Good getGoodById(Long id);

    public Set<Good> allGoods();

    public Set<Good> getLastAddedGoods(Integer col);

}
