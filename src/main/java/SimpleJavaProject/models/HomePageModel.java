package SimpleJavaProject.models;

public class HomePageModel {
    private String message;
    private VisitsResponseModel homePageVisits;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VisitsResponseModel getHomePageVisits() {
        return homePageVisits;
    }

    public void setHomePageVisits(VisitsResponseModel homePageVisits) {
        this.homePageVisits = homePageVisits;
    }
}
