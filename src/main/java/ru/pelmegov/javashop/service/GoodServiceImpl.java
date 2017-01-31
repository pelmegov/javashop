package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.GoodDAO;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.model.good.Good;

import java.util.Set;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDao;

    @Autowired
    public GoodServiceImpl(GoodDAO goodDao) {
        this.goodDao = goodDao;
    }

    @Override
    @Transactional
    public Good getGoodByName(String name) {
        return goodDao.getGoodByName(name);
    }

    @Override
    @Transactional
    public Good getGoodById(Integer id) {
        return goodDao.getGoodById(id);
    }

    @Override
    @Transactional
    public Set<Good> getAllGoods() {
        return goodDao.getAllGoods();
    }

    @Override
    @Transactional
    public Set<Good> getGoods(Integer count) {
        return goodDao.getGoods(count);
    }

    @Override
    @Transactional
    public Set<Good> getLastAddedGoods(Integer col) {
        return goodDao.getLastAddedGoods(col);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer categoryId) {
        return goodDao.getGoodsByCategory(categoryId);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId) {
        return goodDao.getGoodsByCategory(count, categoryId);
    }
}
