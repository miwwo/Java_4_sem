package Observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Observable {
    private String name;
    private List<Observer> observers = new ArrayList<>();

    public YoutubeChannel(String name){
        this.name = name;
    }
    private void notify(YoutubePost youtubePosting) {
        for (Observer observer : this.observers) {
            observer.onVideoPosted(youtubePosting);
        }
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void addVideo(YoutubePost youtubePosting) {
        this.notify(youtubePosting);
    }
}

interface Observable {
    public void attach(Observer observer);
}

interface Observer {
    public void onVideoPosted(YoutubePost youtubePost);
}