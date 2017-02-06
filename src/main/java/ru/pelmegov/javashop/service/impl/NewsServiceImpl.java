package ru.pelmegov.javashop.service.impl;

import org.springframework.stereotype.Service;
import ru.pelmegov.javashop.dao.NewsDAO;
import ru.pelmegov.javashop.service.NewsService;
import ru.pelmegov.javashop.model.news.News;

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

    @Override
    public void addNews(News news) {
        this.newsDAO.addNews(news);
    }

    @Override
    public void updateNews(News news) {
        this.newsDAO.updateNews(news);
    }

    @Override
    public void deleteNews(Integer id) {
        this.newsDAO.deleteNews(id);
    }
}
