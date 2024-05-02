package com.urlShortner.demo.controller;

import com.urlShortner.demo.Entity.Url;
import com.urlShortner.demo.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@RestController
public class GetReqDemo {


    @Autowired
    private UrlService urlService;


      @GetMapping("/getAllDomains")
      public List<Url> getUrls()
      {
         return urlService.getAllUrl();
      }
      @GetMapping("/getCount")
      public List<Map.Entry<String, Integer>> getcount()
      {
          Map <String,Integer>map=urlService.getcount();

          List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

          //Using Entry's comparingByValue() method for sorting in ascending order
          list.sort(Map.Entry.comparingByValue());
          Collections.reverse(list);
          if(list.size()<=3)
              return list;
          List<Map.Entry<String, Integer>> firstThreeElements = new ArrayList<>();
          for (int i = 0; i < 3; i++) {
              firstThreeElements.add(list.get(i));
          }
           return firstThreeElements;
      }

      @GetMapping("/{key}")

        public URL getUrl(@PathVariable("key") String key)
      {
          Url temp= urlService.getUrl(key);
          return temp.getUrl();
      }

        @PostMapping("/shortUrl")
        public String  shorturl(@RequestBody String url)
        {
            Url temp=this.urlService.addurl(url);
            String key="http://localhost:8080/"+temp.getKey();
            return key;
        }

}

