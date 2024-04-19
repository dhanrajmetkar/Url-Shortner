package com.urlShortner.demo.Services;

import com.urlShortner.demo.Entity.Url;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class UrlService {
    private  static List<Url> li=new ArrayList<>();

    static{

        UUID uuid = UUID.randomUUID();
        li.add(new Url(uuid.toString().substring(0, 4), "one", 1));
        }


       public List<Url> getAllUrl(){
            return li;
        }

        public Url getUrl(String key)
        {
            Url url=null;
            url= li.stream().filter(i->i.getKey().equals(key)).findFirst().get();
            return url;
        }
        public Url addurl(String url)
        {
            UUID uuid = UUID.randomUUID();
            Url url1=new Url(uuid.toString().substring(0, 4),url,1) ;
            li.add(url1);
            return url1;
        }

        public Url getcount(String key)
        {
            Url url=null;
            url= li.stream().filter(i->i.getKey().equals(key)).findFirst().get();
            url.setCount(url.getCount()+1);
            return url;
        }


    }
