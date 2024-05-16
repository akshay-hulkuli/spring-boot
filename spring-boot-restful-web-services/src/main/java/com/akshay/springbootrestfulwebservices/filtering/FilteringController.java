package com.akshay.springbootrestfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering", params = "version=1")
    public SomeBean getSomeBeanThoroughFilteringOld() {
        SomeBean someBean = new SomeBean("akshay", "anoop", "likithesh");
        return someBean;
    }

    @GetMapping("/filtering")
    public MappingJacksonValue getSomeBeanThoroughFiltering() {
        SomeBean someBean = new SomeBean("akshay", "anoop", "likithesh");
        MappingJacksonValue mappingJacksonValue =  new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field_1", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> getSomeBeansThoroughFiltering() {
        return Arrays.asList(new SomeBean("akshay", "anoop", "likithesh"), new SomeBean("value1", "value2", "value3"));
    }

}
