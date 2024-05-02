package com.urlShortner.demo.Services;

import com.urlShortner.demo.Entity.Url;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

@Component
public class UrlService {
    private  static List<Url> li=new ArrayList<>();
    private static Map<String,Integer> mp= new HashMap<>();

       public List<Url> getAllUrl(){
            return li;
        }

        public Url getUrl(String key)
        {
            Url url=null;
            url= li.stream().filter(i->i.getKey().equals(key)).findFirst().get();
            url.setCount(url.getCount()+1);
            return url;
        }
        public Url addurl(String url) {

            UUID uuid = UUID.randomUUID();
            for (Url url1 : li) {
                String temp=url1.getUrlString();
                if(temp.equals(url))
                {
                    return url1;
                }
            }

            URL ur;
            try {
                ur = new URL(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

                if(!mp.containsKey(ur.getHost()))
                {
                mp.put(ur.getHost(),1);
                }
                else {
                    mp.put(ur.getHost(),mp.get(ur.getHost())+1);
                }

                Url url1 = new Url(uuid.toString().substring(0, 4), url, 1);
                li.add(url1);
                return url1;

        }

        public Map getcount()
        {
return mp;

        }


    }
