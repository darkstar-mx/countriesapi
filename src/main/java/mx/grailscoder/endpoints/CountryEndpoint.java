package mx.grailscoder.endpoints;

import mx.grailscoder.countriesapi.*;
import mx.grailscoder.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author ArmandodeJesus
 * @email aj.montoya [ at ] outlook.com
 * @Date 10/30/2017
 * @Copyright Armando Montoya, 2017
 * All rights reserved
 */
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI="http://grailscoder.mx/countriesapi";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse addCountry(@RequestPayload AddCountryRequest request){
        AddCountryResponse response = new AddCountryResponse();
        countryRepository.addCountry(request.getCountry());
        Response responseDetails = new Response();
        responseDetails.setResultCode(0);
        responseDetails.setMessage("Country added successfully");
        response.setResponse(responseDetails);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCountriesRequest")
    @ResponsePayload
    public ListCountriesResponse listCountries(@RequestPayload ListCountriesRequest request){
        ListCountriesResponse response = new ListCountriesResponse();
        CountriesList countriesList = new CountriesList();
        countriesList.getCountry().addAll(countryRepository.listCountries());
        response.setCountries(countriesList);
        return response;
    }
}
