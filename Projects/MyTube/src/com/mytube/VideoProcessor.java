package MyJava.Projects.MyTube.src.com.mytube;

public class VideoProcessor {

    private Encoder encoder;
    private Database database;
    private Services services;

    public VideoProcessor(Encoder encoder, Database database, Services services) {
        this.encoder = encoder;
        this.database = database;
        this.services = services;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        services.sendEmail(video.getUser());
    }
}
