package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.NewsDAO;
import ru.pelmegov.javashop.model.News;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class NewsDAOImpl extends AbstractDAO implements NewsDAO {

    public NewsDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Set<News> getAllNews() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<News> getNews(Integer count) {
        List<News> newsList = getSession().createCriteria(News.class).setMaxResults(count).list();
        return new HashSet<News>(newsList);
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
