package MyJava.Projects.MyTube.src.com.mytube;

public class EmailService implements Services {
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
