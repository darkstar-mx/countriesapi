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
public class PopulationEndpoint {

    private static final String NAMESPACE_URI="http://grailscoder.mx/countriesapi";

    private CountryRepository countryRepository;

    @Autowired
    public PopulationEndpoint(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPopulationRequest")
    @ResponsePayload
    public GetPopulationResponse getPopulation(@RequestPayload GetPopulationRequest request){
        GetPopulationResponse response = new GetPopulationResponse();
        response.setPopulation(countryRepository.getPopulationByCountry(request.getCountryName()));
        return response;
    }

}
