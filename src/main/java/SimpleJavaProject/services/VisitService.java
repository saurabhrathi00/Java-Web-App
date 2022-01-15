package SimpleJavaProject.services;

import SimpleJavaProject.dao.RedisDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    RedisDb redis;

    private static final String VISITS = "visits_key";

    public String getVisits()
    {
        return redis.getData(VISITS);
    }

    public void setVisits(int value)
    {
        redis.setData(VISITS,String.valueOf(value));
    }

    public String incrementVisits()
    {
        int numOfVisits = 0;
        try {
            numOfVisits = Integer.valueOf(redis.getData(VISITS));
            numOfVisits++;
            redis.setData(VISITS,String.valueOf(numOfVisits));
        }
        catch (Exception e) {
            throw new RuntimeException("Unable to establish connection to redis server",e);
        }
        return String.valueOf(numOfVisits);

    }
}
