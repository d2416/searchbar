package searchbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    private final RestTemplate restTemplate;

    @Autowired
    public CountryService() {
        this.restTemplate = new RestTemplate();
    }


    // https://restcountries.com/#api-endpoints-v3-all
    public List<Object> getCountries() {
        String url = "https://restcountries.com/v3.1/all";
        Object[] result = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(result);
    }
}
