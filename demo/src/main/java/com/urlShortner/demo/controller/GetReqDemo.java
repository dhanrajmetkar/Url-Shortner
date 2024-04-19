package com.urlShortner.demo.controller;

import com.urlShortner.demo.Entity.Url;
import com.urlShortner.demo.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@RestController
public class GetReqDemo {


    @Autowired
    private UrlService urlService;


      @GetMapping("/url")
      public List<Url> getUrls()
      {
         return urlService.getAllUrl();
      }

      @GetMapping("/url/{key}")

        public Url getUrl(@PathVariable("key") String key)
      {
          return urlService.getUrl(key);
      }
    @GetMapping("url/count/{key}")
      public Url getCou(@PathVariable("key") String key)
    {
        return urlService.getcount(key);
    }

        @PostMapping("/url")
        public Url shorturl(@RequestBody String url)
        {
            Url temp=this.urlService.addurl(url);
           return temp;
        }

}

