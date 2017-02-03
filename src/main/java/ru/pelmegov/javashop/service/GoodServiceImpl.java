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
    public Good getGoodByName(String name, Boolean active) {
        return goodDao.getGoodByName(name, active);
    }

    @Override
    @Transactional
    public Good getGoodById(Integer id) {
        return goodDao.getGoodById(id);
    }

    @Override
    @Transactional
    public Good getGoodById(Integer id, Boolean active) {
        return goodDao.getGoodById(id, active);
    }

    @Override
    @Transactional
    public Set<Good> getAllGoods() {
        return goodDao.getAllGoods();
    }

    @Override
    @Transactional
    public Set<Good> getAllGoods(Boolean active) {
        return goodDao.getAllGoods(active);
    }

    @Override
    @Transactional
    public Set<Good> getGoods(Integer count) {
        return goodDao.getGoods(count);
    }

    @Override
    @Transactional
    public Set<Good> getGoods(Integer count, Boolean active) {
        return goodDao.getGoods(count, active);
    }

    @Override
    @Transactional
    public Set<Good> getLastAddedGoods(Integer count) {
        return goodDao.getLastAddedGoods(count);
    }

    @Override
    @Transactional
    public Set<Good> getLastAddedGoods(Integer count, Boolean active) {
        return goodDao.getLastAddedGoods(count, active);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer categoryId) {
        return goodDao.getGoodsByCategory(categoryId);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer categoryId, Boolean active) {
        return goodDao.getGoodsByCategory(categoryId, active);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId) {
        return goodDao.getGoodsByCategory(count, categoryId);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId, Boolean active) {
        return goodDao.getGoodsByCategory(count, categoryId, active);
    }
}
