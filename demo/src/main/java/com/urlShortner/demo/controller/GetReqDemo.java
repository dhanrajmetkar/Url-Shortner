package com.urlShortner.demo.controller;

import com.urlShortner.demo.Entity.Url;
import com.urlShortner.demo.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@RestController
public class GetReqDemo {


    @Autowired
    private UrlService urlService;


      @GetMapping("/getAllDomains")
      public ResponseEntity<List<String>> getUrls()
      {

          List<String> allList=urlService.getAllUrl();
          if(allList.isEmpty())
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          return
                  ResponseEntity.of(Optional.of(allList));
      }
      @GetMapping("/getCount")
      public ResponseEntity<Object> getcount()
      {
          List<Map.Entry<String, Integer>>list =urlService.getcount();
          if(list.isEmpty())
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          return
                  ResponseEntity.of(Optional.of(list));

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

