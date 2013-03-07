package foo.nerz.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import foo.nerz.mapper.entity.City;
import foo.nerz.mapper.entity.Country;
import foo.nerz.mapper.repository.CityRepo;
import foo.nerz.mapper.repository.CountryRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:root-context.xml")
public class TestMongo {

	@Autowired CityRepo repository;
	
	@Autowired CountryRepo repoCountry;

    @Test
    public void readsFirstPageCorrectly() {

    	long startTime; 
		// ... do something ...
		long estimatedTime ;
		startTime = System.currentTimeMillis();
    	
      Page<City> persons = repository.findByNameRegex("^Mod", new PageRequest(0, 10,new Sort(new Order(Direction.DESC, "population"))));
      
      
      
      System.out.println(persons.getSize());
     List<City> ci= persons.getContent();
      for (int i=0; i<persons.getSize();i++){
    	  System.out.println(ci.get(i).getName()+" - "+ci.get(i).getPopulation());
      }
      
      estimatedTime = System.currentTimeMillis() - startTime;
		
		System.out.println(estimatedTime);
      
//      assertThat(persons.isFirstPage(), is(true));
		
		Iterable<Country> country=repoCountry.findAll();
		
		for(Country cur:country){
			System.out.println(cur.toString());
		}
		
    }
}
