public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean isImageLoaded = false;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!isImageLoaded) {
            // Lazy initialization
            realImage = new RealImage(filename);
            isImageLoaded = true;
        }
        realImage.display();
    }
}
