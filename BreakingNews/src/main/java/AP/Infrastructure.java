package AP;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.*;

public class Infrastructure
{
    private final String URL;
    private final String APIKEY;
    private final String JSONRESULT;
    private ArrayList<News> newsList;
    public Infrastructure(String APIKEY)
    {
        this.APIKEY = APIKEY;
        this.URL = "https://newsapi.org/v2/everything?q=tesla&from=" + LocalDate.now().minusDays(1) + "&sortBy=publishedAt&apiKey=";

        this.JSONRESULT = getInformation();
        if (JSONRESULT != null)
        {
            parseInformation(JSONRESULT);
        }else{
            this.newsList = new ArrayList<>();
        }
    }
    public ArrayList<News> getNewsList() {
        return newsList;
    }
    private String getInformation()
    {
        try
        {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + APIKEY))
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200)
            {
                return response.body();
            }
            else
            {
                throw new IOException("error code: " + response.statusCode());
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
        return null;
    }
    private void parseInformation(String JSONRESULT)
    {
        try
        {
            var jsonObject = JsonParser.parseString(JSONRESULT).getAsJsonObject();
            var articles = jsonObject.getAsJsonArray("articles");

            newsList = new ArrayList<>();

            for (int i = 0; i < (Math.min(20, articles.size())); i++)
            {
                var article = articles.get(i).getAsJsonObject();
                String title = article.has("title") && !article.get("title").isJsonNull() ?
                        article.get("title").getAsString() : "No title available.";
                String description = article.has("description") && !article.get("description").isJsonNull() ?
                        article.get("description").getAsString() : "No description provided.";
                String sourceName = article.has("source") && article.getAsJsonObject("source").has("name") ?
                        article.getAsJsonObject("source").get("name").getAsString() : "Unknown source.";
                String author = article.has("author") && !article.get("author").isJsonNull() ?
                        article.get("author").getAsString() : "Author unknown.";
                String url = article.has("url") && !article.get("url").isJsonNull() ?
                        article.get("url").getAsString() : "No URL available.";
                String publishedAt = article.has("publishedAt") && !article.get("publishedAt").isJsonNull() ?
                        article.get("publishedAt").getAsString() : "No date provided.";
                newsList.add(new News(title, description, sourceName, author, url, publishedAt));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean displayNewsList()
    {
        if (newsList.isEmpty())
        {
            System.out.println("404 - Not found");
            return false;
        }
        for (int i = 0; i < newsList.size(); i++)
        {
            System.out.println((i + 1) + ". " + newsList.get(i).getTitle());
        }
        return true;
    }
}
