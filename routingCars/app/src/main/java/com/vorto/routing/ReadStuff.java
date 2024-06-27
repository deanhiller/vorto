package com.vorto.routing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadStuff {

    private static final Logger log = LoggerFactory.getLogger(ReadStuff.class);

    public List<PickupDropoff> readInLocations(String arg) {
        BufferedReader reader;

        //if file was a large enough(really large!), could run 4 threads to read the file in starting at different locations
        List<PickupDropoff> locations = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(arg));
            String line = reader.readLine();
            //discard this line which is the title

            //add start location ->
            PickupDropoff baseLocation = new PickupDropoff();
            baseLocation.setLoadNumber(0);
            baseLocation.setDropoff(new GeoLocation());
            baseLocation.setPickup(new GeoLocation());
            locations.add(baseLocation);

            while (line != null) {
                // read next line
                line = reader.readLine();

                if(line != null) {
                    PickupDropoff location = convertLine(line);
                    locations.add(location);
                    log.info("location=" + location);
                }
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
        return locations;
    }

    private PickupDropoff convertLine(String line) {
        try {
            //assuming delimted by whitespace here
            String[] split = line.split("\\s+");
            PickupDropoff loc = new PickupDropoff();
            Integer loadNum = Integer.parseInt(split[0]);
            loc.setLoadNumber(loadNum);

            GeoLocation pickup = convertGeo(split[1]);
            GeoLocation dropoff = convertGeo(split[2]);
            loc.setPickup(pickup);
            loc.setDropoff(dropoff);

            return loc;
        } catch (RuntimeException e) {
            //for easy debugging on line failures...
            throw new RuntimeException("Could not convert line="+line, e);
        }
    }

    private GeoLocation convertGeo(String s) {
        GeoLocation geo = new GeoLocation();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        double lat = Double.parseDouble(split[0]);
        geo.setLatitude(lat);
        double longitude = Double.parseDouble(split[1]);
        geo.setLongitude(longitude);
        return geo;
    }

}
