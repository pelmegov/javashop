package ru.pelmegov.javashop.service;

import org.springframework.stereotype.Service;
import ru.pelmegov.javashop.api.dao.NewsDAO;
import ru.pelmegov.javashop.api.service.NewsService;
import ru.pelmegov.javashop.model.News;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;

@Service
public class NewsServiceImpl implements NewsService {
    private  final NewsDAO newsDAO;

    public NewsServiceImpl(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @Override
    public Set<News> getAllNews() {
        return null;
    }

    @Override
    @Transactional
    public Set<News> getNews(Integer count) {
        return newsDAO.getNews(count);
    }

    @Override
    public News getNewsById(Integer id) {
        return null;
    }

    @Override
    public News getNewsByDate(Date date) {
        return null;
    }
}
