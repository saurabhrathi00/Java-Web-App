package SimpleJavaProject.controller;

import SimpleJavaProject.models.HomePageModel;
import SimpleJavaProject.models.VisitsResponseModel;
import SimpleJavaProject.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping(value = "visits", consumes = "application/json", produces = "application/json")
    public VisitsResponseModel getVisits()
    {

        VisitsResponseModel response = new VisitsResponseModel();
        String visits = visitService.getVisits();
        response.setVisits(visits);
        return response;
    }

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public HomePageModel homepage() {

        HomePageModel homePageModel = new HomePageModel();
        homePageModel.setMessage("Hi There");

        String visits = visitService.incrementVisits();
        VisitsResponseModel visitsResponseModel = new VisitsResponseModel();
        visitsResponseModel.setVisits(visits);
        homePageModel.setHomePageVisits(visitsResponseModel);
        return homePageModel;
    }
}
