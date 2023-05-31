package Observer;// 5) Снимок, наблюдатель

class YoutubePost {
    private String title;

    public YoutubePost(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void onVideoPosted(YoutubePost youtubePost) {
        // Do something with the youtubePost posting
        System.out.println("Hi, " + this.name + "! New Post: " + youtubePost.getTitle());
    }
}
