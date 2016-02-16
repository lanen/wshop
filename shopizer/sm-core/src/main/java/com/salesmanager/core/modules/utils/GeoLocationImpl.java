package com.salesmanager.core.modules.utils;

import java.net.InetAddress;

import com.salesmanager.core.business.common.model.LoopbackAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.salesmanager.core.business.common.model.Address;

import javax.annotation.PostConstruct;


public class GeoLocationImpl implements GeoLocation {

    private DatabaseReader reader = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationImpl.class);

    //@Value("${dbPath:classpath:/reference/GeoLite2-Country.mmdb}")
    //private Resource db;


    @PostConstruct
    public void init(){

        if (reader == null) {
            //if(db!=null) {
            //File file = db.getFile();
            try {
                java.io.InputStream inputFile = GeoLocationImpl.class.getClassLoader().getResourceAsStream("reference/GeoLite2-City.mmdb");
                reader = new DatabaseReader.Builder(inputFile).build();
            } catch (Exception e) {
                LOGGER.error("Cannot instantiate IP database", e);
            }
            //}
        }

    }

    @Override
    public Address getAddress(String ipAddress) throws Exception {


        InetAddress inetAddress = InetAddress.getByName(ipAddress);

        if (inetAddress.isLoopbackAddress()){
            return new LoopbackAddress();
        }

//        inetAddress.isLoopbackAddress()
        CityResponse response = reader.city(inetAddress);


        Address address = new Address();

        address.setCountry(response.getCountry().getIsoCode());
        address.setPostalCode(response.getPostal().getCode());
        address.setZone(response.getMostSpecificSubdivision().getIsoCode());
        address.setCity(response.getCity().getName());

        return address;
    }


}
