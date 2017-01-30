package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.News;

import java.util.Date;
import java.util.Set;

public interface NewsService {
    Set<News> getAllNews();

    Set<News> getNews(Integer count);

    News getNewsById(Integer id);

    News getNewsByDate(Date date);
}
