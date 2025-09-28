import java.util.*;

// Observer interface
interface Subscriber {
    void update(String news);
}

// Concrete Observer
class NewsSubscriber implements Subscriber {
    private String name;
    public NewsSubscriber(String name) { this.name = name; }
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

// Subject interface
interface NewsAgency {
    void subscribe(Subscriber sub);
    void unsubscribe(Subscriber sub);
    void notifySubscribers();
}

// Concrete Subject
class NewsChannel implements NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestNews;

    public void subscribe(Subscriber sub) { subscribers.add(sub); }
    public void unsubscribe(Subscriber sub) { subscribers.remove(sub); }
    public void setNews(String news) {
        this.latestNews = news;
        notifySubscribers();
    }
    public void notifySubscribers() {
        for (Subscriber sub : subscribers) {
            sub.update(latestNews);
        }
    }
}

// Demo
public class ObserverDemo {
    public static void main(String[] args) {
        NewsChannel channel = new NewsChannel();

        Subscriber alice = new NewsSubscriber("Alice");
        Subscriber bob = new NewsSubscriber("Bob");

        channel.subscribe(alice);
        channel.subscribe(bob);

        channel.setNews("Breaking News: Design Patterns in Java!");
    }
}
