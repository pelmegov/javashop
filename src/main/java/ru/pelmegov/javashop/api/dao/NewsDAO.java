package ru.pelmegov.javashop.api.dao;


import ru.pelmegov.javashop.model.News;

import java.util.Date;
import java.util.Set;

public interface NewsDAO {
    Set<News> getAllNews();

    Set<News> getNews(Integer count);

    News getNewsById(Integer id);

    News getNewsByDate(Date date);
}
