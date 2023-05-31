package Observer;

public class YoutubeTest {
    public static void main(String[] args) {
        Subscriber sub_1 = new Subscriber("Anton Mokin");
        Subscriber sub_2 = new Subscriber("Aidar Alimbekov");
        Subscriber sub_3 = new Subscriber("Kirill Shapovalov");

        YoutubeChannel channel = new YoutubeChannel("A4");
        channel.attach(sub_1);
        channel.attach(sub_2);
        channel.attach(sub_3);

        channel.addVideo(new YoutubePost("24 hours in MIREA"));
    }
}
