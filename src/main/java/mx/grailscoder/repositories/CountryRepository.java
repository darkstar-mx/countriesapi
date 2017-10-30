package mx.grailscoder.repositories;

import mx.grailscoder.countriesapi.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ArmandodeJesus
 * @email aj.montoya [ at ] outlook.com
 * @Date 10/30/2017
 * All rights reserved
 */
@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country mexico = new Country();
        mexico.setName("Mexico");
        mexico.setCapital("CDMX");
        mexico.setCurrency(Currency.MXN);
        mexico.setPopulation(120000000);

        countries.put(mexico.getName(), mexico);
    }

    public Country findCountry(String name){
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }

    public int getPopulationByCountry(String name){
        Assert.notNull(name, "The country's name must not be null");
        Country result = countries.get(name);
        return null != result?result.getPopulation():0;
    }

    public void addCountry(Country country){
        Assert.notNull(country, "Country details must not be null");
        countries.putIfAbsent(country.getName(), country);
    }

    public Collection<Country> listCountries(){
        return countries.values();
    }
}
