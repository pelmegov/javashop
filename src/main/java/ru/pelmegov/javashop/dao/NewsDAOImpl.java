package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.NewsDAO;
import ru.pelmegov.javashop.model.News;

import java.util.*;

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
        return new HashSet<>(newsList);
    }

    @Override
    public News getNewsById(Integer id) {
        return (News) getSession().createCriteria(News.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public News getNewsByDate(Date date) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> getLastAddedNews(Integer count) {
        List<News> news = (List<News>) getSession()
                .createCriteria(News.class)
                .addOrder(Order.desc("id"))
                .setMaxResults(count)
                .list();
        return new ArrayList<>(news);
    }
}
