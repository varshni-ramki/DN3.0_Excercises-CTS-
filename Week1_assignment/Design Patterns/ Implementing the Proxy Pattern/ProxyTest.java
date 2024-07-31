public class ProxyTest {
    public static void main(String[] args) {
        // Create a ProxyImage object for a given image
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display image1 - this will load the image from the server
        System.out.println("First display call for image1:");
        image1.display();

        // Display image1 again - this will use the cached image
        System.out.println("Second display call for image1:");
        image1.display();

        // Display image2 - this will load the image from the server
        System.out.println("First display call for image2:");
        image2.display();
    }
}
