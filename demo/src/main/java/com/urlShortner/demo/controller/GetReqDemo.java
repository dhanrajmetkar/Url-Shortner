package com.urlShortner.demo.controller;

import com.urlShortner.demo.Entity.Url;
import com.urlShortner.demo.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.stereotype.Service;

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

        public RedirectView getUrl(@PathVariable("key") String key)
      {
          Url temp= urlService.getUrl(key);
          String url= temp.getUrlString();
          RedirectView redirectView=new RedirectView();
          redirectView.setUrl(url);
          return redirectView;
      }

        @PostMapping("/shortUrl")
        public String shorturl(@RequestBody String url)
        {
            RedirectView redirectView=new RedirectView();
            Url temp=this.urlService.addurl(url);
            String key="http://localhost:8080/"+temp.getShorturl();
            redirectView.setUrl(key);
            return key;
        }
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Url> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return urlRepository.findAll();
//    }

}

