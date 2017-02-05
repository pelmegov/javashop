package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ru.pelmegov.javashop.api.service.MailService;
import ru.pelmegov.javashop.model.cart.Item;
import ru.pelmegov.javashop.model.order.Order;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Object object) {

        Order order = (Order) object;
        MimeMessagePreparator preparator = getMessagePreparator(order);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final Order order) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {

                StringBuilder items = new StringBuilder();
                for (Item item : order.getCart().getItems())
                    items.append("Good: " + item.getGood().getDescription()
                            + ". Count: " + item.getCount() + ". \n");

                String text = "Dear " + order.getUser().getLogin()
                        + ", thank you for placing order. "
                        + "Your order ID is " + order.getId() + ".\n"
                        + "Order status: " + order.getStatus() + "." + "\n"
                        + "SUM: " + order.getCart().getSum() + " RUB.\n"
                        + "Your cart: " + items;

                mimeMessage.setFrom(new InternetAddress("info@javashop.com", "JavaShop Corporation"));
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(order.getUser().getEmail()));
                mimeMessage.setText(text);
                mimeMessage.setSubject("Your order on JavaShop #" + order.getId());
            }
        };
        return preparator;
    }

}
