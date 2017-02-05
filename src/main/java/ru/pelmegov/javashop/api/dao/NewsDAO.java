package ru.pelmegov.javashop.api.dao;


import ru.pelmegov.javashop.model.news.News;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface NewsDAO {

    Set<News> getAllNews();

    Set<News> getNews(Integer count);

    News getNewsById(Integer id);

    News getNewsByDate(Date date);

    List<News> getLastAddedNews(Integer count);

    void addNews(News news);

    void updateNews(News news);

    void deleteNews(Integer id);
}
