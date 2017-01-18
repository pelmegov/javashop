package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.GoodDAO;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.model.Good;

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
    public Good getGoodById(Long id) {
        return goodDao.getGoodById(id);
    }

    @Override
    @Transactional
    public Set<Good> allGoods() {
        return goodDao.allGoods();
    }

    @Override
    @Transactional
    public Set<Good> getLastAddedGoods(Integer col) {
        return goodDao.getLastAddedGoods(col);
    }
}
