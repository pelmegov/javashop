package ru.pelmegov.javashop.service;

import org.springframework.stereotype.Service;
import ru.pelmegov.javashop.api.dao.NewsDAO;
import ru.pelmegov.javashop.api.service.NewsService;
import ru.pelmegov.javashop.model.News;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsDAO newsDAO;

    public NewsServiceImpl(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @Override
    @Transactional
    public Set<News> getAllNews() {
        return newsDAO.getAllNews();
    }

    @Override
    @Transactional
    public Set<News> getNews(Integer count) {
        return newsDAO.getNews(count);
    }

    @Override
    @Transactional
    public News getNewsById(Integer id) {
        return newsDAO.getNewsById(id);
    }

    @Override
    @Transactional
    public News getNewsByDate(Date date) {
        return newsDAO.getNewsByDate(date);
    }

    @Override
    @Transactional
    public List<News> getLastAddedNews(Integer count) {
        return newsDAO.getLastAddedNews(count);
    }
}
