package com.hk.cityu.globalback.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.cityu.globalback.Models.Currency;
import com.hk.cityu.globalback.Models.Phone;
import com.hk.cityu.globalback.Repository.CurrencyRepository;
import com.hk.cityu.globalback.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneControllers {
    @Autowired
    private Environment env;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/getAll")
    public List<Phone> getAll(){
        Sort sortingCriteria = new Sort(Sort.Direction.ASC, "brand")
                .and(new Sort(Sort.Direction.ASC, "name"));

        return phoneRepository.findAll(sortingCriteria);
    }

    @GetMapping("/getLatestCurrency")
    public Currency getLatestCurrency(){
        return currencyRepository.findFirstByOrderByCreateDateDesc();
    }

    @GetMapping("/initCurrency")
    public Boolean initCurrency() throws IOException {
        ArrayList<Currency> currencyArrayList = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String fooResourceUrl = "https://api.exchangeratesapi.io/latest?base=HKD&symbols=USD,CNY,JPY,EUR,HKD";

        ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        Iterator<JsonNode> realElements = root.elements();

        root.get("rates").get("HKD").asDouble();

        JsonNode rateElement = root.get("rates");

        Currency currency = new Currency();
        currency.setHkRatio(rateElement.get("HKD").asDouble());
        currency.setJpRatio(rateElement.get("JPY").asDouble());
        currency.setCnRatio(rateElement.get("CNY").asDouble());
        currency.setUsRatio(rateElement.get("USD").asDouble());
        currency.setEuRatio(rateElement.get("EUR").asDouble());

        currencyArrayList.add(currency);

        if(currencyArrayList.size() > 0) {
            currencyRepository.saveAll(currencyArrayList);
        }

        return true;
    }

    @GetMapping("/initData")
    public Boolean initData() throws IOException {
        //Read Eligible Brands
        String whitelistBrands = env.getProperty("phoneapi.whitelistBrands");
        List<String> brandList = Arrays.asList(whitelistBrands.split(","));

        //Read Eligible Devices
        String whitelistDevices = env.getProperty("phoneapi.whitelistDevices");
        List<String> deviceList = Arrays.asList(whitelistDevices.split(","));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ArrayList<Phone> phoneArrayList = new ArrayList<>();

        for (String brand : brandList) {
            String filterBrand = brand + " ";
            String fooResourceUrl = "https://fonoapi.freshpixl.com/v1/getlatest?token=3ad50f57cbb31fe05e7c1d6885be677f450f4d626b8a4b27&brand=" + brand + "&limit=100";
            ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            Iterator<JsonNode> realElements = root.elements();
            while (realElements.hasNext()) {
                JsonNode realElement = realElements.next();
                String deviceName = realElement.get("DeviceName").asText().replace(filterBrand, "");
                if (deviceList.contains(deviceName)) {
                    System.out.println(realElement.toString());
                    Phone phone = this.setupPhoneData(realElement, deviceName);
                    phoneArrayList.add(phone);
                    //phoneRepository.save(phone);
                }
            }
        }

        if (phoneArrayList.size() > 0) {
            phoneRepository.saveAll(phoneArrayList);
        }

        return true;
    }

    private Phone setupPhoneData(JsonNode node, String name) {
        Phone phone = new Phone();
        //Name
        phone.setName(name);
        //Brand
        phone.setBrand(node.get("Brand").asText());
        //Color Variant
        if (node.get("colors") != null) {
            phone.setDeviceColor(node.get("colors").asText());
        }
        //Sim Card Type
        if (node.get("sim") != null) {
            phone.setSimCard(node.get("sim").asText());
        }
        //Screen Specs
        if (node.get("type") != null) {
            phone.setScreenType(node.get("type").asText());
        }
        if (node.get("size") != null) {
            phone.setScreenSize(node.get("size").asText());
        }
        if (node.get("resolution") != null) {
            phone.setScreenRes(node.get("resolution").asText());
        }
        if (node.get("display_c") != null) {
            phone.setScreenColor(node.get("display_c").asText());
        }
        if (node.get("protection") != null) {
            phone.setScreenProtection(node.get("protection").asText());
        }
        //SD Card
        if (node.get("card_slot") != null) {
            phone.setHasSDCard(node.get("card_slot").asText());
        }
        //Speaker Spec
        if (node.get("loudspeaker_") != null) {
            phone.setSpeakerSpec(node.get("loudspeaker_").asText());
        }
        if (node.get("sound_c") != null) {
            phone.setSoundCancelFeature(node.get("sound_c").asText());
        }
        //CPUGPU Spec
        if (node.get("cpu") != null) {
            phone.setCpuSpec(node.get("cpu").asText());
        }
        if (node.get("chipset") != null) {
            phone.setCpuChipset(node.get("chipset").asText());
        }
        if (node.get("gpu") != null) {
            phone.setGpuSpec(node.get("gpu").asText());
        }
        //Memory
        if (node.get("internal") != null) {
            phone.setMemoryStorage(node.get("internal").asText());
        }
        //Ear Jack
        if (node.get("_3_5mm_jack_") != null) {
            phone.setHasEarJack(node.get("_3_5mm_jack_").asText());
        }
        //Connectivity Spec
        if (node.get("wlan") != null) {
            phone.setWifiSpec(node.get("wlan").asText());
        }
        if (node.get("speed") != null) {
            phone.setCellSpeedSpec(node.get("speed").asText());
        }
        //Features
        if (node.get("features_c") != null) {
            phone.setMainFeatures(node.get("features_c").asText());
        }
        if (node.get("body_c") != null) {
            phone.setSubFeatures(node.get("body_c").asText());
        }
        if (node.get("body_c") != null) {
            phone.setSensorFeatures(node.get("sensors").asText());
        }
        //Battery and Charging
        if (node.get("battery_c") != null) {
            phone.setBatteryCap(node.get("battery_c").asText());
        }
        if (node.get("features_c") != null) {
            phone.setChargingSpec(node.get("features_c").asText());
        }
        //Camera Spec
        if (node.get("secondary") != null) {
            phone.setFrontCamSpec(node.get("secondary").asText());
        }
        if (node.get("primary_") != null) {
            phone.setBackCamSpec(node.get("primary_").asText());
        }
        else{
            /*Fallback detection for back-camera*/
            if(node.get("single") != null){
                phone.setBackCamSpec(node.get("single").asText());
            }
        }
        if (node.get("video") != null) {
            phone.setBackCamSpec(node.get("video").asText());
        }
        if (node.get("features") != null) {
            phone.setCamFeatures(node.get("features").asText());
        }
        return phone;
    }
}