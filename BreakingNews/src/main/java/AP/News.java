package AP;

public class News
{
    private String _title;
    private String _description;
    private String _sourceName;
    private String _author;
    private String _URL;
    private String _publishedAt;
    public News(String title, String description, String sourceName, String author, String URL, String publishedAt)
    {
        _title = title;
        _description = description;
        _sourceName = sourceName;
        _author = author;
        _URL = URL;
        _publishedAt = publishedAt;
    }
    public String getTitle() { return _title; }
    public String getDescription() { return _description; }
    public String getSourceName() { return _sourceName; }
    public String getAuthor() { return _author; }
    public String getURL() { return _URL; }
    public String getPublishedAt() { return _publishedAt; }
    public void displayNews()
    {
        System.out.println("Title:" + _title);
        System.out.println("Description:" + _description);
        System.out.println("Source:" + _sourceName);
        System.out.println("Author:" + _author);
        System.out.println("URL:" + _URL);
        System.out.println("Published at:" + _publishedAt);
    }

}
